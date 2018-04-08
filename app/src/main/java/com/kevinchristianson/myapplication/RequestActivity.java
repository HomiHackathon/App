package com.kevinchristianson.myapplication;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
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
import com.google.firebase.auth.FirebaseAuth;


import java.sql.DatabaseMetaData;

import butterknife.OnClick;

public class RequestActivity extends AppCompatActivity {

    Button buttonborrow;
    Button rightBtn;
    Button leftBtn;
    EditText textItemBrrw;
    EditText textItemCtgry;
    EditText textRadius;
    EditText textDaysBrrw;

    DatabaseReference requests = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid());
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child("requests");
    DatabaseReference itmBrrwdRef = mRootRef.child("Item Requested");
    DatabaseReference itmCtgryRef = itmBrrwdRef.child("Item Category");
    DatabaseReference radiusRef = mRootRef.child("Distance for Item");
    DatabaseReference daysBrrwRef = mRootRef.child("Number of Days Needed to Borrow");


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
        rightBtn = (Button) findViewById(R.id.rightShare);
        leftBtn = (Button) findViewById(R.id.leftShare);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Button rightBtn = findViewById(R.id.rightShare);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestActivity.this, MainActivity.class));
                finish();
            }
        });

        Button leftBtn = findViewById(R.id.leftShare);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestActivity.this, ProfileActivity.class));
                finish();
            }
        });

        itmBrrwdRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textItemBrrw.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        itmCtgryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textItemCtgry.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        radiusRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textRadius.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        daysBrrwRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textDaysBrrw.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        buttonborrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itmBrrwdRef.setValue(textItemBrrw.getText().toString());
                itmCtgryRef.setValue(textItemCtgry.getText().toString());
                radiusRef.setValue(textRadius.getText().toString());
                daysBrrwRef.setValue(textDaysBrrw.getText().toString());

                Intent intent = new Intent(RequestActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


