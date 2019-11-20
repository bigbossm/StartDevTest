package com.example.startdevtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startdevtest.R;
import com.example.startdevtest.adapter.RestaurentOrderAdapter;
import com.example.startdevtest.model.ProductItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class RestaurentOrderActivity extends AppCompatActivity {

    private TextView FoodName;
    private TextView FoodPrice;
    private TextView mTotalPrice;
    private RecyclerView mRecyclerView;
    private Button mContinue,mCancel;
    private RestaurentOrderAdapter mExampleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retaurent_order);

        mRecyclerView = findViewById(R.id.recycler_viewa);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FoodName = findViewById(R.id.cart_food_title);
        FoodPrice = findViewById(R.id.cart_food_price);
        mTotalPrice = findViewById(R.id.restaurent_order_price);
        mContinue = findViewById(R.id.confirmation_button);
        mCancel = findViewById(R.id.cancel_button);

        String test = getIntent().getStringExtra("list");
        String price = getIntent().getStringExtra("finalprice");
        mTotalPrice.setText(price+"$");



        Gson gson = new Gson();
        Type type = new TypeToken<List<ProductItem>>(){}.getType();
        List<ProductItem> carsList = gson.fromJson(test, type);

        mExampleAdapter = new RestaurentOrderAdapter(this, carsList);
        mRecyclerView.setAdapter(mExampleAdapter);


        mContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurentOrderActivity.this, FinalActivity.class));

            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurentOrderActivity.this, RestaurentActivity.class));


            }
        });


     //   for (ProductItem cars : mProductItem){
     //       Log.i("Car Data", cars.getName()+"-"+cars.getPrice());
     //       FoodName.setText(cars.getName());
     //       FoodPrice.setText(String.valueOf(cars.getPrice()));
    //    }


  //      FoodPrice.setText(String.valueOf(mProductItemList.get(0).getPrice()));



    }

}
