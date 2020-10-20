package com.example.mvp_funystory.View.Fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mvp_funystory.CallBackPresenter.CallInsertStory;
import com.example.mvp_funystory.DAO.CallCategoryDAO;
import com.example.mvp_funystory.DAO.CallHomeDAO;
import com.example.mvp_funystory.DAO.CallStoryDAO;
import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Model.Story;
import com.example.mvp_funystory.Presenter.CategoryPresenter;
import com.example.mvp_funystory.Presenter.HomePresenter;
import com.example.mvp_funystory.Presenter.InsertStoryPresenter;
import com.example.mvp_funystory.Presenter.StoryPresenter;
import com.example.mvp_funystory.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InsertStoryFragment extends BaseFragment<InsertStoryPresenter> implements CallInsertStory, CallCategoryDAO, CallHomeDAO, CallStoryDAO {
    public static final String TAG = InsertStoryFragment.class.getName();
    private EditText edtNameSto,edtAuthor,edtTotalChapte,edtDate,edtAvatar,edtMoTa;
    private TextView tvAvatar;
    private Spinner spCate;
    private List<String> listCate;
    private String cate,name,author,date,avatar,linkMota;
    private RadioButton rbDone,rbUPdate;

    private int status,idCate,chapter;



    @Override
    public InsertStoryPresenter getMpresenter() {
        return new InsertStoryPresenter(this);
    }

    @Override
    protected void initView() {
        deleteStoryByID(6);
        deleteStoryByID(7);
        deleteStoryByID(8);
        deleteStoryCateByID(6);
        deleteStoryCateByID(7);
        deleteStoryCateByID(8);

        listCate = new ArrayList<>();
        for (int i = 0; i < getALlStory().size() - 1; i++) {
            listCate.add(getALlStory().get(i).category_name);
        }
        Log.i("TAG", "initViewCate: " + listCate.size());
        edtNameSto = findViewById(R.id.edt_nameSto);

        edtAuthor = findViewById(R.id.edt_author);
        edtTotalChapte = findViewById(R.id.edt_totalChapter);

        edtDate = findViewById(R.id.edt_chooseDate);
        getDateUp();

        spCate = findViewById(R.id.spinner);
        chooseCate();

        tvAvatar = findViewById(R.id.edt_avartar, this);
        edtAvatar = findViewById(R.id.edtAvarta);
        edtAvatar.setText(getStorage().getSendBM());

        findViewById(R.id.bt_add, this);

        rbDone = findViewById(R.id.rb_done);

        rbDone.setOnCheckedChangeListener(listener);
        rbUPdate = findViewById(R.id.rb_update);
        rbUPdate.setOnCheckedChangeListener(listener);


        edtMoTa = findViewById(R.id.edt_mota);

    }
    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getText().equals("Đã hoàn thành")) {
                status = 1;
            }
            if (buttonView.getText().equals("Đang cập nhật")) {
                status = 2;
            }
        }
    };



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
                idCate = position+1;
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
            case R.id.bt_add:
                insertStory(new CategoryStories(getAllCateStori().size()+2,idCate,name,chapter,author,date));
                insertStory(new Story(getAllCateStori().size()+2,getAllCateStori().size()+2,getAllCateStori().size()+2,
                        date,avatar,date,status,linkMota));
                break;
        }
    }

    @Override
    public List<Categories> getALlStory() {
        return new CategoryPresenter(this).getAllCategory();
    }

    @Override
    public List<CategoryStories> getAllCateStori() {
        return new HomePresenter(this).getAllStory();
    }


    @Override
    public void insertStory(CategoryStories categorystories) {
        name = edtNameSto.getText().toString();
        author = edtAuthor.getText().toString();
        date = edtDate.getText().toString();
        chapter = Integer.parseInt(edtTotalChapte.getText().toString());
        avatar = edtAvatar.getText().toString();
        linkMota = edtMoTa.getText().toString();
        new HomePresenter(this).insertStory(categorystories);
    }

    @Override
    public boolean deleteStoryCateByID(int id) {
        return new HomePresenter(this).deleteStory(id);
    }

    @Override
    public void insertStory(Story story) {
        new StoryPresenter(this).insert(story);
    }

    @Override
    public boolean deleteStoryByID(int id) {
        return new StoryPresenter(this).delStoryByID(id);
    }
}
