package com.example.mvp_funystory.View.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.CallBack.CallBack;
import com.example.mvp_funystory.View.Fragment.BaseFragment;
import com.example.mvp_funystory.View.Fragment.ChooseImagesFragment;
import com.example.mvp_funystory.View.Fragment.CommunityFragment;
import com.example.mvp_funystory.View.Fragment.HomeDAOFragment;
import com.example.mvp_funystory.View.Fragment.InsertStoryFragment;
import com.example.mvp_funystory.View.Fragment.LibraryFragment;
import com.example.mvp_funystory.View.Fragment.MenuDrawerFragment;
import com.example.mvp_funystory.View.Fragment.PersonalFragment;
import com.example.mvp_funystory.View.Fragment.SignInFragment;
import com.example.mvp_funystory.View.Fragment.UserDAOFragment;
import com.example.mvp_funystory.View.Fragment.SplashFragment;
import com.example.mvp_funystory.View.Fragment.CategoryDAOFragment;
import com.example.mvp_funystory.View.Fragment.StoryByCateFragment;
import com.example.mvp_funystory.View.Fragment.StoryFragment;
import com.example.mvp_funystory.View.Fragment.ToTalChapterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements CallBack, View.OnClickListener {
    private String currenTag;
    private BottomNavigationView botomMenu;
    private boolean doubleBackToExitPressedOnce;
//    private DrawerLayout drawerLayout;
//    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        doubleBackToExitPressedOnce = false;

//        drawerLayout = findViewById(R.id.ln_main);

//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,null,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(drawerToggle);
//        drawerToggle.setDrawerIndicatorEnabled(true);
//        drawerToggle.syncState();

        botomMenu = findViewById(R.id.menu_bot);
        botomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        addFragment(HomeDAOFragment.TAG);
                        botomMenu.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.navigation_theLoai:
                        addFragment(CategoryDAOFragment.TAG);

                        return true;
                    case R.id.navigation_library:
                        addFragment(LibraryFragment.TAG);

                        return true;
                    case R.id.navigation_congDong:
                        addFragment(CommunityFragment.TAG);

                        return true;
                    case R.id.navigation_caNhan:
                        addFragment(PersonalFragment.TAG);
                        return true;
                }
                return false;
            }
        });
        addFragment(HomeDAOFragment.TAG);

    }

    public void showFragment(String tag) {
        try {
            Class<?> clazz = Class.forName(tag);
            BaseFragment baseFragment = (BaseFragment) clazz.newInstance();
            baseFragment.setCallBack(this);
            currenTag = tag;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.ln_main,baseFragment,tag).commit();
            transaction.addToBackStack(baseFragment.getClass().getName());
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addFragment(String tag) {
        try {
            Class<?> clazz = Class.forName(tag);
            BaseFragment baseFragment = (BaseFragment) clazz.newInstance();
            baseFragment.setCallBack(this);
            currenTag = tag;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.ln_main,baseFragment,tag).commit();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//        this.doubleBackToExitPressedOnce = true;
//
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce=false;
//            }
//        }, 2000);
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void callBack(String key, Object data) {
        switch (key){
            case HomeDAOFragment.KEY_SHOW_STORY:
                showFragment(StoryFragment.TAG);
                botomMenu.setVisibility(View.INVISIBLE);
                break;
            case ToTalChapterFragment.KEY_SHOW_CHAPTER:
                showFragment(ToTalChapterFragment.TAG);
                botomMenu.setVisibility(View.INVISIBLE);
                break;
            case StoryByCateFragment.KEY_SHOW_BYCATE:
                showFragment(StoryByCateFragment.TAG);
                botomMenu.setVisibility(View.INVISIBLE);
                break;
            case MenuDrawerFragment.KEY_SHOW_DRAWER:
                showFragment(MenuDrawerFragment.TAG);
                break;
            case ChooseImagesFragment.KEY_SHOW_IMAGES:
                showFragment(ChooseImagesFragment.TAG);
                break;
            case PersonalFragment.KEY_SHOW_PERSONAL:
                showFragment(PersonalFragment.TAG);
                break;
            case HomeDAOFragment.KEY_SHOW_INSERT:
                showFragment(InsertStoryFragment.TAG);
                botomMenu.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public void showDrawerMenu() {
        Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
    }



//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(drawerToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        drawerLayout.closeDrawer(GravityCompat.START);
//        switch (menuItem.getItemId()){
//            case R.id.navigation_trangchu:
//                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
//               break;
//            case R.id.navigation_theLoai:
//                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.navigation_caNhan:
//                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
//                break;
//                case R.id.navigation_thongbao:
//                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.navigation_thuvien:
//                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//        return true;
//    }
}