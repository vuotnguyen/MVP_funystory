package com.example.mvp_funystory.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_funystory.CallBackPresenter.CallLibrary;
import com.example.mvp_funystory.DAO.CallCategoryDAO;
import com.example.mvp_funystory.Model.Categories;
import com.example.mvp_funystory.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateHolder> {
    private Context context;
    private List<Categories> listCate;
    private CallCategoryDAO even;

//    public void setEven(CallCategoryDAO even) {
//        this.even = even;
//    }

    public CategoryAdapter(Context context, List<Categories> listCate,CallCategoryDAO even) {
        this.context = context;
        this.listCate = listCate;
        this.even = even;
    }

    @NonNull
    @Override
    public CateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cate_adapter,parent,false);

        return new CateHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CateHolder holder, int position) {
        holder.tvNameCate.setText(listCate.get(position).getCategory_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                even.gotoStoryByCate(listCate.get(position).id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCate.size();
    }

    public class CateHolder extends RecyclerView.ViewHolder {
        private TextView tvNameCate;
        public CateHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCate = itemView.findViewById(R.id.tv_nameCate);
        }
    }
}
