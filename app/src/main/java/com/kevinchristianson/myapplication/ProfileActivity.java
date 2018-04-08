
package com.kevinchristianson.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    ImageView mIcon;
    Button mFollow;
    Button rightBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        rightBtn = (Button) findViewById(R.id.rightShare);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button rightBtn = findViewById(R.id.rightShare);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, ShareActivity.class));
                finish();
            }
        });

        mIcon = findViewById(R.id.ivProfile);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.steviep);
        RoundedBitmapDrawable mDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        mDrawable.setCircular(true);
        mDrawable.setColorFilter(ContextCompat.getColor(ProfileActivity.this, R.color.colorAccent), PorterDuff.Mode.DST_OVER);
        mIcon.setImageDrawable(mDrawable);

        mFollow = findViewById(R.id.btnFollow);
        mFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFollow.getText().toString().equalsIgnoreCase("Follow me")) {
                    mFollow.setText("Following");
                } else {
                    mFollow.setText("Follow me");
                }
            }
        });

//        String k = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        ((TextView) findViewById(R.id.tvName)).setText(k);
    }

}
