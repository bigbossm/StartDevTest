package com.example.startdevtest.activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startdevtest.R;
import com.example.startdevtest.adapter.RestaurentDetailAdapter;
import com.example.startdevtest.model.ProductItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.example.startdevtest.activity.RestaurentActivity.EXTRA_CREATOR;
import static com.example.startdevtest.activity.RestaurentActivity.EXTRA_LIKES;
import static com.example.startdevtest.activity.RestaurentActivity.EXTRA_URL;


public class RestaurentDetailActivity extends AppCompatActivity  implements RestaurentDetailAdapter.onItemClickListener{

    private  static  int finalPrice = 0;
    private List<ProductItem> mProductItemList;
    private TextView mItemPrice;
    private RecyclerView mRecyclerView;
    private RestaurentDetailAdapter mExampleAdapter;
    private List<ProductItem> mProductItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurent_detail);

        mRecyclerView = findViewById(R.id.recycler_view);
        mItemPrice = findViewById(R.id.item_price);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProductItem = new ArrayList<>();
        ProductItem productItem1 = new ProductItem("edzed", 1);
        ProductItem productItem2 = new ProductItem("aze", 2);
        ProductItem productItem3 = new ProductItem("edazeazzed", 3);

        mProductItem.add(productItem1);
        mProductItem.add(productItem2);
        mProductItem.add(productItem3);

        mExampleAdapter = new RestaurentDetailAdapter(this, mProductItem);
        mExampleAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mExampleAdapter);


        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        final String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        final int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        final TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);
        ImageButton add = findViewById(R.id.popular_food_plus);
        Button send = findViewById(R.id.confirmation_button);
      //  Picasso.get().load(imageUrl).fit().centerInside().into(imageView);
      //  textViewCreator.setText(creatorName);
      //  textViewLikes.setText("Likes: " + likeCount);

        if (mProductItemList == null)
        {
            mProductItemList = new ArrayList<>();
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RestaurentOrderActivity.class);
                Gson gson = new Gson();

                String jsonCars = gson.toJson(mProductItemList);
                String totalPrice = String.valueOf(finalPrice);
                intent.putExtra("list",jsonCars);
                intent.putExtra("finalprice",totalPrice);
                startActivity(intent);


            }
        });

    }
    public  void priceUpdate( int price ){
        finalPrice = finalPrice + price;
        mItemPrice.setText(Double.toString(finalPrice));
    }
    @Override
    public void itemClick(int position) {
        ProductItem productItemN = mProductItem.get(position);
        mProductItemList.add(productItemN);
        int price = mProductItem.get(position).getPrice();
        priceUpdate(price);

    }
}