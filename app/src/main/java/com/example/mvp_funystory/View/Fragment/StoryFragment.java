package com.example.mvp_funystory.View.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_funystory.DAO.CallStoryDAO;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.Model.Story;
import com.example.mvp_funystory.Presenter.StoryPresenter;
import com.example.mvp_funystory.R;

import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryFragment extends BaseFragment<StoryPresenter> implements CallStoryDAO {
    public static final String TAG = StoryFragment.class.getName();

    private TextView tvName,tvAuthor,tvCate,tvType,tvChapter,tvDateUp,tvModifi,tvContent;
    private ImageView imgAvartar;
    private CircleImageView circleImageView;
    private int idStory;

    @Override
    public StoryPresenter getMpresenter() {
        return new StoryPresenter(this);
    }

    @Override
    protected void initView() {
        idStory = getStorage().getIdStory();
//        upDateDATA("avatar/a1.jpg","content1.txt",1);
//        insertStory(new Story(3,3,3,"2020-10-05 16:22:02","avatar/a3.jpg","2020-10-05 16:22:02",1,"content/content3.txt"));
//        insertStory(new Story(4,4,4,"2020-10-05 16:22:02","avatar/a4.jpg","2020-10-05 16:22:02",2,"content/content4.txt"));
//        insertStory(new Story(5,5,5,"2020-10-05 16:22:02","avatar/a5.jpg","2020-10-05 16:22:02",2,"content/content5.txt"));

        tvName = findViewById(R.id.tv_Name);
        tvAuthor = findViewById(R.id.tv_Author);
        tvCate = findViewById(R.id.tv_Cate);
        tvType = findViewById(R.id.tv_Type);
        tvChapter = findViewById(R.id.tv_Chapter);
        tvDateUp = findViewById(R.id.tv_DateUP);
        tvModifi = findViewById(R.id.tv_Modifi);
        tvContent = findViewById(R.id.tv_content);

        findViewById(R.id.img_Like,this);
        findViewById(R.id.img_Share,this);
        findViewById(R.id.img_Down,this);
        circleImageView = findViewById(R.id.profile_image);
        circleImageView.setImageBitmap(getMpresenter().getBitmapImage(context,idStory));
        imgAvartar = findViewById(R.id.img_Avatar);

        imgAvartar.setImageBitmap(getMpresenter().getBitmapImage(context,idStory));
        tvDateUp.setText("Ngày up: "+getStoryByID(idStory).created_date);
        tvModifi.setText("Ngày cập nhật: "+getStoryByID(idStory).modified_date);
        tvType.setText(getStoryByID(idStory).status == 1 ? "Trạng thái: Đang ra" : "Trạng thái: Đã hết");
        tvName.setText(getCS(idStory).getStory_name());
        tvAuthor.setText("Tác Giả: "+getCS(idStory).getAuthor());
        tvChapter.setText("Số chương: "+getCS(idStory).getTotal_chapter());

        int idCate = getCS(idStory).getCategory_id();
        tvCate.setText("Thể loại: "+getNameCATE(idCate));
        tvContent.setText(getMpresenter().getTextContent(context,idStory));

       findViewById(R.id.bt_Read,this);

    }


    @Override
    protected int getLayoutID() {
        return R.layout.story_fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_Like:
                likeStory();
                break;
            case R.id.img_Share:
                shareStory();
                break;
            case R.id.img_Down:
                downStory();
                break;
            case R.id.bt_Read:
                readStory();
                break;
        }
    }

    private void readStory() {
        even.callBack(ToTalChapterFragment.KEY_SHOW_CHAPTER,null);
        Log.i("TAG", "readStory: "+idStory);
    }

    private void downStory() {
    }

    private void shareStory() {
    }

    private void likeStory() {
    }

    @Override
    public Story getStoryByID(int id) {
        return getMpresenter().getStoryByID(id);
    }

    @Override
    public void upDateDATA(String url, String content, int id) {
        getMpresenter().upDateData(url,content,id);
    }

    @Override
    public void insertStory(Story story) {
        getMpresenter().insert(story);
    }

    @Override
    public CategoryStories getCS(int id) {
        return getMpresenter().geCSByID(id);
    }

    @Override
    public String getNameCATE(int id) {
        return getMpresenter().getNameCate(id);
    }
}
