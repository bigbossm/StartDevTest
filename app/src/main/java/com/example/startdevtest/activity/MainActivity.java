package com.example.startdevtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.startdevtest.R;

public class MainActivity extends AppCompatActivity {
    Button mStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        mStart = findViewById(R.id.btn_login);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, RestaurentActivity.class));
            }
        });
    }
}
