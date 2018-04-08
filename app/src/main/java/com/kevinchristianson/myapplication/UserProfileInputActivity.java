package com.kevinchristianson.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import butterknife.OnClick;

public class UserProfileInputActivity extends AppCompatActivity {

    Button mButtonSubmit;
    EditText mFirstName;
    EditText mLastName;
    EditText mCollege;
    EditText mBday;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid());
    DatabaseReference mFirstNameRef = mRootRef.child("first name");
    DatabaseReference mLastNameRef = mRootRef.child("last name");
    DatabaseReference mCollegeRef = mRootRef.child("college");
    DatabaseReference mBirthdayRef = mRootRef.child("birthday");

    @OnClick(R.id.button3)
    void onClick() {
        Intent intent = new Intent(this, ShareActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_input);

        mButtonSubmit = (Button) findViewById(R.id.button3);
        mFirstName = (EditText) findViewById(R.id.firstNameUser);
        mLastName = (EditText) findViewById(R.id.lastNameUser);
        mCollege = (EditText) findViewById(R.id.collegeUser);
        mBday = (EditText) findViewById(R.id.birthdayUser);

    }
    @Override
    protected void onStart() {
        super.onStart();

        mFirstNameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mFirstName.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

        mLastNameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mLastName.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

        mCollegeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mCollege.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

        mBirthdayRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mBday.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirstNameRef.setValue(mFirstName.getText().toString());
                mLastNameRef.setValue(mLastName.getText().toString());
                mCollegeRef.setValue(mCollege.getText().toString());
                mBirthdayRef.setValue(mBday.getText().toString());

            }
        });



        }



    }


