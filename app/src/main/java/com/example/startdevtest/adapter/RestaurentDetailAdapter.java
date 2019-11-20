package com.example.startdevtest.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startdevtest.model.ProductItem;
import com.example.startdevtest.R;

import java.util.List;


public class RestaurentDetailAdapter extends RecyclerView.Adapter<RestaurentDetailAdapter.RestaurentDetailViewHolder> {
    private Context mContext;
    private List<ProductItem> mExampleList;
    private RestaurentDetailAdapter.onItemClickListener mListener;



    public RestaurentDetailAdapter(Context context, List<ProductItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }


    public void setOnItemClickListener(RestaurentDetailAdapter.onItemClickListener listener) {
        mListener = listener;
    }


    @Override
    public RestaurentDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.restaurent_detail_item, parent, false);
        return new RestaurentDetailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurentDetailViewHolder holder, int position) {
        ProductItem currentItem = mExampleList.get(position);


        String creatorName = currentItem.getName();
        long likeCount = currentItem.getPrice();
        //String imageUrl = currentItem.getImageUrl();


        holder.RestaurantName.setText(creatorName);
        holder.Price.setText("Likes: " + likeCount);
      //  Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);


    }




    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class RestaurentDetailViewHolder extends RecyclerView.ViewHolder {
        public TextView RestaurantName;
        public TextView Price;
        public ImageView mImageView;
        public ImageButton addToCard;

        public RestaurentDetailViewHolder(View itemView) {
            super(itemView);


            mImageView = itemView.findViewById(R.id.image_view_detail);
            RestaurantName = itemView.findViewById(R.id.text_view_creator_detail);
            Price = itemView.findViewById(R.id.text_view_like_detail);
            addToCard = itemView.findViewById(R.id.popular_food_plus);

            addToCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            mListener.itemClick(position);
                        }
                    }
                }
            });

        }
    }
    public interface onItemClickListener {
         void itemClick (int position);
    }

}