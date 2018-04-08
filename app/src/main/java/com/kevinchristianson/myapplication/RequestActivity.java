package com.kevinchristianson.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.OnClick;

public class RequestActivity extends AppCompatActivity {

    Button buttonborrow;
    EditText textItemBrrw;
    EditText textItemCtgry;
    EditText textRadius;
    EditText textDaysBrrw;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference requests = mRootRef.child("Request");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_page);

        //Get UI  elements
        buttonborrow = (Button) findViewById(R.id.article_heading);
        textItemBrrw = (EditText) findViewById(R.id.editTextItmBrrw);
        textItemCtgry = (EditText) findViewById(R.id.editTextItemctgry);
        textRadius = (EditText) findViewById(R.id.editTextRadius);
        textDaysBrrw = (EditText) findViewById(R.id.editTextdaysbrrw);

        buttonborrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requests.setValue("hello world");
                Intent intent = new Intent(RequestActivity.this, RequestActivity.class);
                startActivity(intent);
                finish();
            }
        });


//        @Override
//        public void onClick(View view){
//            String requestItem = textItemBrrw.getText().toString() + " ," + textItemCtgry.getText().toString() +
//                    ", " + textRadius.getText().toString() + ", " + textDaysBrrw.getText().toString();
//
//        }
    }
}