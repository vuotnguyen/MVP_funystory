package com.example.mvp_funystory.View.Fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_funystory.DAO.CallStoryByCateDAO;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Presenter.StoryByCatePresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.adapter.CategoryStoriesAdapter;

import java.util.List;

public class StoryByCateFragment extends BaseFragment<StoryByCatePresenter> implements CallStoryByCateDAO {
    public static final String KEY_SHOW_BYCATE = "KEY_SHOW_BYCATE";
    public static final String TAG = StoryByCateFragment.class.getName();

    private RecyclerView rvStoryByCate;
    private int idCate;
    private CategoryStoriesAdapter adapter;
    private List<CategoryStories> listByCate;

    @Override
    public StoryByCatePresenter getMpresenter() {
        return new StoryByCatePresenter(this);
    }

    @Override
    protected void initView() {
        idCate = getStorage().getIdCate();

        listByCate = getStoryByCate(idCate);

        rvStoryByCate = findViewById(R.id.rv_storyByCate);
        rvStoryByCate.setLayoutManager(new LinearLayoutManager(context));
        adapter = new CategoryStoriesAdapter(context,listByCate,this,getStorage().getStatus());
        rvStoryByCate.setAdapter(adapter);
        Log.i("TAG", "initView: "+listByCate.size());
    }

    @Override
    protected int getLayoutID() {
        return R.layout.storybycate_fragment;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public List<CategoryStories> getStoryByCate(int id) {
        return getMpresenter().getStoryByCate(id);
    }
    @Override
    public void gotoStory(int id) {
        even.callBack(HomeDAOFragment.KEY_SHOW_STORY,null);
        getStorage().setIdStory(id);
    }
}
