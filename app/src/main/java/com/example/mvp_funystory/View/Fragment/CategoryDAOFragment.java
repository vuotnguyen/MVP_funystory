package com.example.mvp_funystory.View.Fragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.Presenter.CategoryPresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.DAO.CallCategoryDAO;
import com.example.mvp_funystory.View.adapter.CategoryAdapter;

import java.util.List;

public class CategoryDAOFragment extends BaseFragment<CategoryPresenter> implements CallCategoryDAO {
    public static final String TAG = CategoryDAOFragment.class.getName();
    private TextView tvTitle;
    private RecyclerView rv_cate;
    public List<Categories> listCate;
    private CategoryAdapter categoryAdapter;

    @Override
    public CategoryPresenter getMpresenter() {
        return new CategoryPresenter(this);
    }

    @Override
    protected void initView() {
        listCate = getALlStory();
        getStorage().setListCate(listCate);

//        getMpresenter().insert(new Categories(5,"Nhật bản","Ý nghĩa"));
//        getMpresenter().insert(new Categories(6,"Chuyện tranh",""));
//        getMpresenter().insert(new Categories(7,"Thiếu nhi","vui"));

        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Thể Loại");
        rv_cate = findViewById(R.id.rv_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rv_cate.setLayoutManager(gridLayoutManager);
        categoryAdapter = new CategoryAdapter(context,getALlStory(),this);
        rv_cate.setAdapter(categoryAdapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.theloai_fragment;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public List<Categories> getALlStory() {
        return getMpresenter().getAllCategory();
    }

    @Override
    public void insertStory(Categories category) {

    }

    @Override
    public void deleteStory(Categories category) {

    }

    @Override
    public void deleteStoryByID(Categories id) {

    }

    @Override
    public void gotoStoryByCate(int id) {
        even.callBack(StoryByCateFragment.KEY_SHOW_BYCATE,null);
        getStorage().setIdCate(id);
    }
}
