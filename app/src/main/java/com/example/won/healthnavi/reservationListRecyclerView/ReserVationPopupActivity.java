package com.example.won.healthnavi.reservationListRecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.won.healthnavi.R;
import com.example.won.healthnavi.reservationListRecyclerView.ReservationListAdapter;
import com.example.won.healthnavi.reservationListRecyclerView.ReservationListInfo;

import java.util.ArrayList;

public class ReserVationPopupActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reservation_popup);

        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ReservationListInfo> reservationListInfoArrayList = new ArrayList<>();
        reservationListInfoArrayList.add(new ReservationListInfo("09:00",true));
        reservationListInfoArrayList.add(new ReservationListInfo("09:20",true));
        reservationListInfoArrayList.add(new ReservationListInfo("09:40",true));
        reservationListInfoArrayList.add(new ReservationListInfo("10:00",true));
        reservationListInfoArrayList.add(new ReservationListInfo("10:20",true));
        reservationListInfoArrayList.add(new ReservationListInfo("10:40",true));
        reservationListInfoArrayList.add(new ReservationListInfo("11:00",true));
        reservationListInfoArrayList.add(new ReservationListInfo("11:20",true));
        reservationListInfoArrayList.add(new ReservationListInfo("11:40",true));
        reservationListInfoArrayList.add(new ReservationListInfo("12:00",true));

        ReservationListAdapter reservationListAdapter = new ReservationListAdapter(reservationListInfoArrayList, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Toast.makeText(ReserVationPopupActivity.this, "click" + position, Toast.LENGTH_SHORT).show();
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
