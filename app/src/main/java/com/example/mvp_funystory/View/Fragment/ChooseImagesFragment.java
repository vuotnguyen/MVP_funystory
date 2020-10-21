package com.example.mvp_funystory.View.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.View;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_funystory.CallBackPresenter.CallImage;
import com.example.mvp_funystory.Presenter.ChooseImagePresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChooseImagesFragment extends BaseFragment<ChooseImagePresenter> implements CallImage {

    public static final String KEY_SHOW_IMAGES = "KEY_SHOW_IMAGES";
    public static final String TAG = ChooseImagesFragment.class.getName() ;
    private RecyclerView rvImages;
    private ImageAdapter adapter;
    private LoadImageAsynTask asynTask;
    private String tagFrag;


    @Override
    public ChooseImagePresenter getMpresenter() {
        return new ChooseImagePresenter(this);
    }

    @Override
    protected void initView() {
        tagFrag = getStorage().getTagFrag();

        rvImages = findViewById(R.id.rv_Image);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        rvImages.setLayoutManager(gridLayoutManager);
        asynTask = new LoadImageAsynTask();
        asynTask.execute();
    }


    private void loadRV(List<String> list){
        adapter = new ImageAdapter(getContext(),list,this);
        rvImages.setAdapter(adapter);

        adapter.setCallImage(tagFrag,new CallImage() {
            @Override
            public void sendBM(String bm) {
                if(tagFrag.equals(PersonalFragment.TAG)){
                    SharedPreferences sharedPreferences =getActivity().getSharedPreferences(PersonalFragment.KEY_AVARTAR, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.putString(PersonalFragment.KEY_PATH, bm);
                    editor.commit();
                    even.callBack(PersonalFragment.KEY_SHOW_PERSONAL,null);
                    getChildFragmentManager().isDestroyed();
                    //hủy fragment
                }
                if(tagFrag.equals(InsertStoryFragment.TAG)){
                    getStorage().setSendBM(bm);
                    even.callBack(HomeDAOFragment.KEY_SHOW_INSERT,null);
                }

            }

        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.choose_image_fragment;
    }

    @Override
    public void onClick(View v) {

    }


    private class LoadImageAsynTask extends AsyncTask<Void,ArrayList<String>,List<String>>{
        private List<String> listImages;

        @Override
        protected List<String> doInBackground(Void... voids) {
            listImages = new ArrayList<>();

            String[] projection = new String[]{MediaStore.Images.Media._ID,
                    MediaStore.Images.Media.TITLE,
                    MediaStore.Images.Media.DATA};

            Cursor cursor = getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,projection,null,null,null);
            int size = cursor.getCount();
            if(size > 0 ){
                cursor.moveToFirst();
                while (cursor.isAfterLast() == false){
                    int fileIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    String path = cursor.getString(fileIndex);
                    listImages.add(path);

                    cursor.moveToNext();
                }
                publishProgress();
            }
            return listImages;
        }
        @Override
        protected void onProgressUpdate(ArrayList<String> ...values) {
            super.onProgressUpdate(values);
            loadRV(listImages);
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


    }
}
