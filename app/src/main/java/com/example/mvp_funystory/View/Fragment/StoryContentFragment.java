package com.example.mvp_funystory.View.Fragment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mvp_funystory.DAO.CallStoryContent;
import com.example.mvp_funystory.Model.StoryContent;
import com.example.mvp_funystory.Presenter.StoryContentPresenter;
import com.example.mvp_funystory.R;

public class StoryContentFragment extends BaseFragment<StoryContentPresenter> implements CallStoryContent {

    private TextView tvName,tvContent;


    private int chapterStory;
    @Override
    public StoryContentPresenter getMpresenter() {
        return new StoryContentPresenter(this);
    }

    @Override
    protected void initView() {
        tvName = findViewById(R.id.tv_nameStory);
        tvContent = findViewById(R.id.tv_contentStory);

        tvName.setText("Chương "+getStoryContent(chapterStory).chapter+" : "+getStoryContent(chapterStory).chapter_name);
        tvContent.setText(getContentStory(chapterStory,context));

    }

    private String getContentStory(int chapter, Context context) {
        return getMpresenter().getContentText(chapter,context);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.story_content_fragment;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public StoryContent getStoryContent(int chapter) {
        return getMpresenter().getStoryContent(chapter);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void setChapterStory(int chapter) {
        chapterStory = chapter;
    }
}
