package com.example.mvp_funystory.View.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_funystory.DAO.CallHomeDAO;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Presenter.HomePresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.adapter.CategoryStoriesAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeDAOFragment extends BaseFragment<HomePresenter> implements CallHomeDAO {
    public static final String KEY_SHOW_STORY = "KEY_SHOW_STORY";
    public static final String KEY_SHOW_INSERT = "KEY_SHOW_INSERT";
    public static final String KEY_SHOW_UPDATE = "KEY_SHOW_UPDATE";
    public static final String KEY_SHOW_DEL = "KEY_SHOW_DEL";
    private RecyclerView rv_listStory;
    private List<CategoryStories> storiesList;
    private ImageView imgDrawer;
    public static final String TAG = HomeDAOFragment.class.getName();
    public static final String KEY_SHOW_HOME = "KEY_SHOW_HOME";


    @Override
    public HomePresenter getMpresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void initView() {
//        getMpresenter().insertStory(new CategoryStories(1,1,"Tây du kí",108,"Ngô thừa ân","10-06-2020"));
//        getMpresenter().insertStory(new CategoryStories(2,2,"Đội bóng thiếu lâm",18,"Châu tinh trì","10-06-2020"));
//        getMpresenter().insertStory(new CategoryStories(3,3,"Thám tử conan",123,"kudo shinichi","10-06-2020"));
//        getMpresenter().insertStory(new CategoryStories(4,4,"Tấm cám  ",12,"chưa cập nhật","10-06-2020"));
//        getMpresenter().insertStory(new CategoryStories(5,5,"Doremon",134,"tokuda mazawa","10-06-2020"));


        imgDrawer = findViewById(R.id.imgDrawerMenu,this);

        rv_listStory = findViewById(R.id.rv_allStory);
        rv_listStory.setLayoutManager(new LinearLayoutManager(getContext()));
        CategoryStoriesAdapter adapter = new CategoryStoriesAdapter(getContext(),getAllCateStori(),this);
        rv_listStory.setAdapter(adapter);
        adapter.setEven(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgDrawerMenu:
                showPopUpMenu();
        }
    }

    private void showPopUpMenu() {
        PopupMenu popupMenu = new PopupMenu(context,imgDrawer);
        popupMenu.getMenuInflater().inflate(R.menu.nav_drawer_menu,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.insert_story:
                        even.callBack(KEY_SHOW_INSERT,null);
                        break;
                    case R.id.update_story:
                        even.callBack(KEY_SHOW_UPDATE,null);
                        break;
                    case R.id.del_story:
                        even.callBack(KEY_SHOW_DEL,null);
                        break;
                }
                return false;
            }
        });
    }


    @Override
    public List<CategoryStories> getAllCateStori() {

        storiesList = getMpresenter().getAllStory();
        return storiesList;
    }

    @Override
    public void insertStory(CategoryStories categorystories) {

    }

//    @Override
//    public void deleteStory(CategoryStories categorystories) {
//
//    }
//
//    @Override
//    public void deleteStoryByID(CategoryStories id) {
//    }

    @Override
    public void gotoStory(int id) {
        even.callBack(KEY_SHOW_STORY,null);
        getStorage().setIdStory(id);
    }

}
