package com.example.mvp_funystory.View.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Random;

public class InsertStoryFragment extends BaseFragment<InsertStoryPresenter> implements CallInsertStory, CallCategoryDAO, CallHomeDAO, CallStoryDAO {
    public static final String TAG = InsertStoryFragment.class.getName();
    private EditText edtNameSto, edtAuthor, edtTotalChapte, edtDate, edtAvatar, edtMoTa;
    private TextView tvAvatar;
    private Spinner spCate;
    private List<String> listCate;
    private String cate, name, author, date, avatar, linkMota;
    private RadioButton rbDone, rbUPdate;

    private int status, idCate, chapter;
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

    @Override
    public InsertStoryPresenter getMpresenter() {
        return new InsertStoryPresenter(this);
    }

    @Override
    protected void initView() {
//        deleteStoryByID(getStoryByID(6));
//        deleteStoryByID(getStoryByID(7));
//        deleteStoryByID(getStoryByID(8));
//        deleteStoryCateByID(getCateStoriByID(6));
//        deleteStoryCateByID(getCateStoriByID(7));
//        deleteStoryCateByID(getCateStoriByID(8));

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

    private void getDateUp() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = Calendar.getInstance().getTime();
        String time = df.format(date);
        edtDate.setText(time);
    }

    private void chooseCate() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listCate);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spCate.setAdapter(arrayAdapter);
        spCate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cate = listCate.get(position);
                idCate = position + 1;
                Log.i("TAG", "onItemSelected: " + cate);
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
        switch (v.getId()) {
            case R.id.edt_avartar:
                even.callBack(ChooseImagesFragment.KEY_SHOW_IMAGES, null);
                getStorage().setTagFrag(TAG);
                break;
            case R.id.bt_add:
                getInfor();
                insertStory(new CategoryStories(generateId(), idCate, name, chapter, author, date));
                insertStory(new Story(generateId(), generateId(), generateId(),
                        date, avatar, date, status, linkMota));
                Toast.makeText(context, "Thêm Thành công", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void getInfor() {
        name = edtNameSto.getText().toString();
        author = edtAuthor.getText().toString();
        date = edtDate.getText().toString();
        chapter = Integer.parseInt(edtTotalChapte.getText().toString());
        avatar = edtAvatar.getText().toString();
        linkMota = edtMoTa.getText().toString();
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

        new HomePresenter(this).insertStory(categorystories);
    }

    @Override
    public CategoryStories getCateStoriByID(int id) {
        return new HomePresenter(this).getCateStoriByID(id);
    }

    @Override
    public void deleteStoryCateByID(CategoryStories categoryStories) {
        new HomePresenter(this).deleteStory(categoryStories);
    }

    @Override
    public void insertStory(Story story) {
        new StoryPresenter(this).insert(story);
    }

    @Override
    public CategoryStories getCS(int id) {
        return null;
    }

    @Override
    public Story getStoryByID(int id) {
        return new StoryPresenter(this).getStoryByID(id);
    }

    @Override
    public boolean deleteStoryByID(Story story) {
        return new StoryPresenter(this).delStoryByID(story);
    }

    public int generateId() {
        Random random = new Random();

        int id = 0;
        for (int i = 0; i < getAllCateStori().size(); i++) {
            while (getAllCateStori().get(i).getId() == id) {
                id = random.nextInt(33);
            }
        }

        return id;
    }

    public  String getFileName (String input) {
return null;
    }

}
