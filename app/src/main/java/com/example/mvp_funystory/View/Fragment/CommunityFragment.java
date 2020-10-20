package com.example.mvp_funystory.View.Fragment;

import android.view.View;
import android.widget.TextView;

import com.example.mvp_funystory.Presenter.CommunityPresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.CallBackPresenter.CallCommunity;

public class CommunityFragment extends BaseFragment<CommunityPresenter> implements CallCommunity {
    public static final String TAG = CommunityFragment.class.getName() ;
    private TextView tvTitle;
    @Override
    public CommunityPresenter getMpresenter() {
        return null;
    }

    @Override
    protected void initView() {
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Cộng đồng");
    }

    @Override
    protected int getLayoutID() {
        return R.layout.community_fragment;
    }

    @Override
    public void onClick(View v) {

    }
}
