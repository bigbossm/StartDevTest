package com.example.startdevtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.startdevtest.R;
import com.example.startdevtest.model.RestaurantItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RestaurentAdapter extends RecyclerView.Adapter<RestaurentAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<RestaurantItem> mRestaurantItemList;
    private OnItemClickListener mListener;

    public RestaurentAdapter(Context context, ArrayList<RestaurantItem> exampleList) {
        mContext = context;
        mRestaurantItemList = exampleList;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_main_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        RestaurantItem currentItem = mRestaurantItemList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getMrestaurentName();
        int likeCount = currentItem.getmMinOrder();

        holder.mRestaurantName.setText(creatorName);
        holder.mMinOrderPrice.setText("Likes: " + likeCount);
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mRestaurantItemList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mRestaurantName;
        public TextView mMinOrderPrice;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mRestaurantName = itemView.findViewById(R.id.text_view_creator);
            mMinOrderPrice = itemView.findViewById(R.id.text_view_likes);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}