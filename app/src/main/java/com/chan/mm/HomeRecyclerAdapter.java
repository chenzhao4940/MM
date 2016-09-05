package com.chan.mm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

/**
 * Created by chan on 2016/9/1.
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<HomeEntity> mDatas;

    public HomeRecyclerAdapter(Context mContext, List<HomeEntity> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewHolder vHolder = new ViewHolder(inflater.inflate(R.layout.item_home_waterfall, parent, false));
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textDes.setText(mDatas.get(position).getDes());
        Glide.with(mContext)
                .load(mDatas.get(position).getCoversUrl())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(final Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.imgCover.post(new Runnable() {
                            @Override
                            public void run() {
                                float imgViewWidth = holder.imgCover.getWidth();
                                float bitmapHeight = resource.getHeight();
                                float bitmapWidth = resource.getWidth();
                                final float imgViewHeight = (bitmapHeight / bitmapWidth) * imgViewWidth;
                              //  resource.setWidth((int) imgViewWidth);
                             //   resource.setHeight((int) imgViewHeight);
                                ((Activity)mContext).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.imgCover.getLayoutParams();
                                        params.height = (int)imgViewHeight;
                                        holder.imgCover.setLayoutParams(params);
                                        holder.imgCover.setImageBitmap(resource);
                                    }
                                });
                            }
                        });
                    }
                });
        Glide.with(mContext).load(mDatas.get(position).getCoversUrl()).into(holder.imgCover);
    }

    @Override
    public int getItemCount() {
        return mDatas == null || mDatas.size() <= 0 ? 0 : mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCover;
        private TextView textDes;

        public ViewHolder(View itemView) {
            super(itemView);
            imgCover = (ImageView) itemView.findViewById(R.id.img);
            textDes = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
