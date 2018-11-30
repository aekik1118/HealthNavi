package com.example.won.healthnavi.reservationListRecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.example.won.healthnavi.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReservationChoiceTimeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    List<String> timeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reservation_choice_time);

        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        timeList = new ArrayList<String>();
        timeList.add("09:00");
        timeList.add("09:20");
        timeList.add("09:40");
        timeList.add("10:00");
        timeList.add("10:20");
        timeList.add("10:40");
        timeList.add("11:00");
        timeList.add("11:20");
        timeList.add("11:40");
        timeList.add("12:00");

        ArrayList<ReservationListInfo> reservationListInfoArrayList = new ArrayList<>();

        for(String s : timeList)
            reservationListInfoArrayList.add(new ReservationListInfo(s,true));

        ReservationListAdapter reservationListAdapter = new ReservationListAdapter(reservationListInfoArrayList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Toast.makeText(ReservationChoiceTimeActivity.this, timeList.get(position) + "에 예약되셨습니다", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        mRecyclerView.setAdapter(reservationListAdapter);

        //데이터 가져오기
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        return;
    }


}
