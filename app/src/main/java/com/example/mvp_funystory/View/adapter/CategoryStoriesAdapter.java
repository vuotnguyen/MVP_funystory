package com.example.mvp_funystory.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_funystory.DAO.CallHomeDAO;
import com.example.mvp_funystory.DAO.CallStoryByCateDAO;
import com.example.mvp_funystory.Model.CategoryStories;
import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.Fragment.HomeDAOFragment;

import java.util.List;

public class CategoryStoriesAdapter extends RecyclerView.Adapter<CategoryStoriesAdapter.HolderStories> {
    private Context context;
    private List<CategoryStories> listStory;
    private CallHomeDAO even;
    private CallStoryByCateDAO even1;
    private int status;

    public CategoryStoriesAdapter(Context context, List<CategoryStories> listStory,CallHomeDAO even,int status) {
            this.context = context;
        this.listStory = listStory;
        this.even = even;
        this.status = status;
    }
    public CategoryStoriesAdapter(Context context, List<CategoryStories> listStory,CallStoryByCateDAO even1,int status) {
        this.context = context;
        this.listStory = listStory;
        this.even1 = even1;
        this.status = status;
    }

    public void setEven(CallHomeDAO even) {
        this.even = even;
    }

    @NonNull
    @Override
    public HolderStories onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stories_adapter,parent,false);
        return new HolderStories(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderStories holder, int position) {
        CategoryStories categorystories = listStory.get(position);
        holder.img_avatar.setImageResource(R.drawable.ic_baseline_menu_book_24);
        holder.tv_name.setText(categorystories.getStory_name());
        holder.tv_chuong.setText("Chương: "+categorystories.getTotal_chapter());
        holder.tv_author.setText("Tác Giả: "+categorystories.getAuthor());
        holder.tv_dateMo.setText("NGày cập nhật: "+categorystories.getModified_date());
        if(status == 1){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(even != null){
                        even.gotoStory(categorystories.getId());
                    }
                    if(even1!= null){
                        even1.gotoStory(categorystories.getId());
                    }
                }
            });
        }
        if(status == 0){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    even.deleteStoryCateByID(categorystories);
                    notifyDataSetChanged();
                    return true;
                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return listStory.size();
    }

    public class HolderStories extends RecyclerView.ViewHolder {
        private ImageView img_avatar;
        private TextView tv_name,tv_chuong,tv_author,tv_dateMo;
        public HolderStories(@NonNull View itemView) {
            super(itemView);
            img_avatar = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_chuong = itemView.findViewById(R.id.tv_chuong);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_dateMo  = itemView.findViewById(R.id.tv_dateMo);

        }
    }
}
