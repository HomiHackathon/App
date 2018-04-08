package com.kevinchristianson.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.OnClick;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_page);

        Button rightBtn = findViewById(R.id.rightShare);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareActivity.this, FeedActivity.class));
                finish();
            }
        });

        Button leftBtn = findViewById(R.id.leftShare);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareActivity.this, RequestActivity.class));
                finish();
            }
        });
    }

    @OnClick(R.id.button)
    void onClick() {
        //this can also be done with a toggle button
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
