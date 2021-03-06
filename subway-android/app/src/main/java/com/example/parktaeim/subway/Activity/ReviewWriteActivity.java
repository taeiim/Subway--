package com.example.parktaeim.subway.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.parktaeim.subway.R;

/**
 * Created by parktaeim on 2018. 4. 20..
 */

public class ReviewWriteActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private TextView ratingTv;
    private TextView toolbarTv;
    private TextView nameTv;
    private int reviewType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_write);

        nameTv = (TextView) findViewById(R.id.reviewWrite_menuNameTv);
        toolbarTv = (TextView) findViewById(R.id.reviewWrite_toolbarTitleTv);

        Intent getIntent = getIntent();
        int reviewType = getIntent.getExtras().getInt("reviewType");
        Log.d("reviewType get===",String.valueOf(reviewType));
        switch (reviewType) {
            case 0:
                toolbarTv.setText("메뉴 리뷰 작성");
                break;
            case 1:
                toolbarTv.setText("꿀조합 리뷰 작성");
                break;
        }

        // Setting RatingBar
        ratingBar = (RatingBar) findViewById(R.id.reviewWrite_ratingBar);
        ratingTv = (TextView) findViewById(R.id.reviewWrite_ratingTv);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTv.setText(String.valueOf(rating));
            }
        });

    }
}
