
package com.kevinchristianson.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView helloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);
=======
        setContentView(R.layout.request_page);
>>>>>>> 5e347c437a8515f839ad4cf6b032eaeb3b779872
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((TextView) findViewById(R.id.textView)).setText("Clicked");
//            }
//        });
        //setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void onClick() {
        //this can also be done with a toggle button
        Intent intent = new Intent(this, MapsActivity.class);
             startActivity(intent);

    }

}
