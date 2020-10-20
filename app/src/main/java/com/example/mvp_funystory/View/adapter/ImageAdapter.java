package com.example.mvp_funystory.View.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp_funystory.CallBackPresenter.CallImage;

import com.example.mvp_funystory.R;
import com.example.mvp_funystory.View.Fragment.PersonalFragment;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImagesHolder> {
    private Context context;
    private List<String> list;

    private CallImage callImage;

    public ImageAdapter(Context context, List<String> list, CallImage callImage) {
        this.callImage = callImage;
        this.context = context;
        this.list = list;
    }

    public void setCallImage(String tag,CallImage callImage) {
        this.callImage = callImage;
    }

    @NonNull
    @Override
    public ImagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_adapter,parent,false);
        return new ImagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesHolder holder, int position) {
        String path = list.get(position);
        Glide.with(context).load(path).into(holder.imgItem);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callImage.sendBM(path);
//                callImage.gobackInsert(path);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImagesHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        public ImagesHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_item);
        }
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
