package com.example.mvp_funystory.View.Fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mvp_funystory.DAO.CallTotalChapter;
import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.Presenter.TotalChapterPresenter;
import com.example.mvp_funystory.R;

import java.util.List;

public class ToTalChapterFragment extends BaseFragment<TotalChapterPresenter> implements CallTotalChapter {
    public static final String KEY_SHOW_CHAPTER = "KEY_SHOW_CHAPTER";
    public static final String TAG = ToTalChapterFragment.class.getName();
    private ViewPager viewPagerChapter;
    private PagerAdapter adapter;
    private int storyID;
    private List<StoryContent> listChapter;

    @Override
    public TotalChapterPresenter getMpresenter() {
        return new TotalChapterPresenter(this);
    }

    @Override
    protected void initView() {

//        insertStory(new StoryContent(1,1,"1","Đường tăng xuất hành","detail/tayduky1.txt"));
//        insertStory(new StoryContent(2,1,"2","Đại thánh hồi sinh","detail/tayduky2.txt"));
//        insertStory(new StoryContent(3,1,"3","Thu nạp thủy quái","detail/tayduk3.txt"));
//        insertStory(new StoryContent(4,1,"4","Đại náo thiên cung","detail/tayduky4.txt"));
//        insertStory(new StoryContent(5,1,"5","Nữ nhi quốc","detail/tayduk5.txt"));
//        insertStory(new StoryContent(6,2,"6","Thu nhận đệ tử","detail/dbtl1.txt"));
//        insertStory(new StoryContent(7,2,"7","Khổ luyện","detail/dbtl2.txt"));
//        insertStory(new StoryContent(8,2,"8","Chung kết đẫm máu","detail/dbtl3.txt"));
//        insertStory(new StoryContent(9,4,"9","Tấm Cám","detail/tamcam.txt"));
//        insertStory(new StoryContent(10,4,"10","Tấm Cám","detail/tamcam.txt"));


//        delAll();

        storyID = getStorage().getIdStory();


        listChapter = getStoryContentById(storyID);

        viewPagerChapter = findViewById(R.id.vp_chapter);
        adapter = new StoryContentAdapter(getChildFragmentManager());
        viewPagerChapter.setAdapter(adapter);
    }


    @Override
    protected int getLayoutID() {
        return R.layout.total_chapter_fragment;
    }

    @Override
    public void onClick(View v) {

    }

    private class StoryContentAdapter extends FragmentStatePagerAdapter {
        public StoryContentAdapter(FragmentManager frg) {
            super(frg);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Log.i("TAG", "idStory: "+position);
            StoryContentFragment frg = new StoryContentFragment();
            frg.setChapterStory(Integer.parseInt(listChapter.get(position).chapter));

            Log.i("TAG", "getItem: "+listChapter.get(position).chapter);
            return frg ;
        }

        @Override
        public int getCount() {
            return listChapter.size();
        }
    }
    @Override
    public List<StoryContent> getStoryContentById(int id) {
        return getMpresenter().getStoryContentByID(id);
    }
    @Override
    public void insertStory(StoryContent content) {
        getMpresenter().insertContentStory(content);
    }

    @Override
    public void updateStoryContent(String chapter,int idStory, int id) {
        getMpresenter().updateStoryContent(chapter,idStory,id);
    }

    @Override
    public void delAll() {
        getMpresenter().delAll();
    }
}
