package com.kevinchristianson.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RequestActivity extends AppCompatActivity {

    Button buttonborrow;
    EditText textItemBrrw;
    EditText textItemCtgry;
    EditText textRadius;
    EditText textDaysBrrw;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_page);

        //Get UI  elements
        buttonborrow = (Button)findViewById(R.id.article_heading);
        textItemBrrw = (EditText) findViewById(R.id.editTextItmBrrw);
        textItemCtgry = (EditText) findViewById(R.id.editTextItemctgry);
        textRadius = (EditText) findViewById(R.id.editTextRadius);
        textDaysBrrw = (EditText) findViewById(R.id.editTextdaysbrrw);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
