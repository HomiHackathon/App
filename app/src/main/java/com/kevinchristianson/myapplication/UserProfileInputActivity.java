package com.kevinchristianson.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class UserProfileInputActivity extends AppCompatActivity {

    Button mButtonSubmit;
    EditText mFirstName;
    EditText mLastName;
    EditText mCollege;
    EditText mBday;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mFirstNameRef = mRootRef.child("first name");
    DatabaseReference mLastNameRef = mRootRef.child("last name");
    DatabaseReference mCollegeRef = mRootRef.child("college");
    DatabaseReference mBirthdayRef = mRootRef.child("birthday");

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
                mFirstNameRef.setValue(mFirstName);
                mLastNameRef.setValue(mLastName);
                mCollegeRef.setValue(mCollege);
                mBirthdayRef.setValue(mBday);
            }
        });

    }
}
