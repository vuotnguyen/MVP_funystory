package com.example.mvp_funystory.View.Fragment;

import android.view.View;
import android.widget.TextView;

import com.example.mvp_funystory.Presenter.LibraryPresenter;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.CallBackPresenter.CallLibrary;

public class LibraryFragment extends BaseFragment<LibraryPresenter> implements CallLibrary {
    public static final String TAG = LibraryFragment.class.getName() ;
    private TextView tvTitle;
    @Override
    public LibraryPresenter getMpresenter() {
        return new LibraryPresenter(this);
    }

    @Override
    protected void initView() {
        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("Thư Viện");

    }

    @Override
    protected int getLayoutID() {
        return R.layout.library_fragment;
    }

    @Override
    public void onClick(View v) {

    }
}
