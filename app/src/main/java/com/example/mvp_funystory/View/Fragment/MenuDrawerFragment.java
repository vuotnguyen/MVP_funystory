package com.example.mvp_funystory.View.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_funystory.CallBackPresenter.CallDrawerMenu;
import com.example.mvp_funystory.Presenter.MenuDrawerPresenter;
import com.example.mvp_funystory.R;

public class MenuDrawerFragment extends BaseFragment<MenuDrawerPresenter> implements CallDrawerMenu {
    public static final String KEY_SHOW_HOME = "KEY_SHOW_HOME";
    public static final String KEY_SHOW_DRAWER = "KEY_SHOW_DRAWER";

    private static final String KEY_SHOW_LIBRARY = "KEY_SHOW_LIBRARY";
    private static final String KEY_SHOW_NOTIFY = "KEY_SHOW_NOTIFY";
    private static final String KEY_SHOW_HISTORY = "KEY_SHOW_HISTORY";
    private static final String KEY_SHOW_VOTE = "KEY_SHOW_VOTE";
    private static final String KEY_SHOW_ABOUT = "KEY_SHOW_ABOUT";

    public static final String TAG = MenuDrawerFragment.class.getName();
    private ImageView imgAvatar;
    private TextView tvName,tvHome,tvLibrary,tvNotify,tvHistory,tvVote,tvAbout;

    @Override
    public MenuDrawerPresenter getMpresenter() {
        return new MenuDrawerPresenter(this);
    }

    @Override
    protected void initView() {
        imgAvatar = findViewById(R.id.img_avatar);
        tvName = findViewById(R.id.tv_name);
        tvHome = findViewById(R.id.tv_home,this);
        tvLibrary = findViewById(R.id.tv_libry,this);
        tvNotify = findViewById(R.id.tv_notifi,this);
        tvHistory = findViewById(R.id.tv_history,this);
        tvVote = findViewById(R.id.tv_vote,this);
        tvAbout = findViewById(R.id.tv_about,this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.menu_drawable_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_home:
                even.callBack(KEY_SHOW_HOME,null);
                even.showDrawerMenu();
                break;
            case R.id.tv_libry:
                even.callBack(KEY_SHOW_LIBRARY,null);
                break;
            case R.id.tv_notifi:
                even.callBack(KEY_SHOW_NOTIFY,null);
                break;
            case R.id.tv_history:
                even.callBack(KEY_SHOW_HISTORY,null);
                break;
            case R.id.tv_vote:
                even.callBack(KEY_SHOW_VOTE,null);
                break;
            case R.id.tv_about:
                even.callBack(KEY_SHOW_ABOUT,null);
                break;
        }
    }
}
