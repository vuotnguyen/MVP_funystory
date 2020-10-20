package com.example.mvp_funystory.View.Fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mvp_funystory.CallBackPresenter.CallInsertStory;
import com.example.mvp_funystory.DAO.CallCategoryDAO;
import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.Presenter.CategoryPresenter;
import com.example.mvp_funystory.Presenter.InsertStoryPresenter;
import com.example.mvp_funystory.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InsertStoryFragment extends BaseFragment<InsertStoryPresenter> implements CallInsertStory, CallCategoryDAO {
    public static final String TAG = InsertStoryFragment.class.getName();
    private EditText edtNameSto,edtAuthor,edtTotalChapte,edtDate,edtAvatar;
    private TextView tvAvatar;
    private Spinner spCate;
    private List<String> listCate;
    private String cate,name;

    private int status;


    @Override
    public InsertStoryPresenter getMpresenter() {
        return new InsertStoryPresenter(this);
    }

    @Override
    protected void initView() {
        listCate = new ArrayList<>();
        for (int i = 0;i<getALlStory().size()-1;i++){
            listCate.add(getALlStory().get(i).category_name);
        }
        Log.i("TAG", "initViewCate: "+listCate.size());
        edtNameSto = findViewById(R.id.edt_nameSto);
        edtAuthor = findViewById(R.id.edt_author);
        edtTotalChapte = findViewById(R.id.edt_totalChapter);

        edtDate = findViewById(R.id.edt_chooseDate);
        getDateUp();

        spCate = findViewById(R.id.spinner);
        chooseCate();

        tvAvatar = findViewById(R.id.edt_avartar,this);
        edtAvatar = findViewById(R.id.edtAvarta);
        edtAvatar.setText(getStorage().getSendBM());

    }

    private void getDateUp() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = Calendar.getInstance().getTime();
        String time = df.format(date);
        edtDate.setText(time);
    }

    private void chooseCate(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,listCate);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spCate.setAdapter(arrayAdapter);
        spCate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cate = listCate.get(position);
                Log.i("TAG", "onItemSelected: "+cate);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.insert_story_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edt_avartar:
                even.callBack(ChooseImagesFragment.KEY_SHOW_IMAGES,null);
                getStorage().setTagFrag(TAG);
                break;
        }
    }

    @Override
    public List<Categories> getALlStory() {
        return new CategoryPresenter(this).getAllCategory();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
