package com.example.mvp_funystory.Presenter;

import android.database.Cursor;
import android.provider.MediaStore;

import androidx.fragment.app.FragmentActivity;

import com.example.mvp_funystory.CallBackPresenter.CallImage;

import java.util.ArrayList;
import java.util.List;

public class ChooseImagePresenter extends BasePresenter<CallImage> {
    public ChooseImagePresenter(CallImage callBack) {
        super(callBack);
    }
    public List<String> getAllImage(FragmentActivity activity){
        List<String> listPath = new ArrayList<>();
        String[] projection = new String[]{MediaStore.Images.Media._ID,
                MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.DATA};

        Cursor cursor = activity.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,projection,null,null,null);
        int size = cursor.getCount();
        if(size > 0 ){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                int fileIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                String path = cursor.getString(fileIndex);
//                String fileName = path.substring(path.lastIndexOf("/")+1,path.length());
                listPath.add(path);
                cursor.moveToNext();
            }
        }
        return listPath;
    }
}
