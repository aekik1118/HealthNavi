package com.example.won.healthnavi.reservationListRecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.won.healthnavi.R;
import com.example.won.healthnavi.reservationListRecyclerView.ReservationListAdapter;
import com.example.won.healthnavi.reservationListRecyclerView.ReservationListInfo;

import java.util.ArrayList;

public class ReserVationPopupActivity extends Activity {

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

        ReservationListAdapter reservationListAdapter = new ReservationListAdapter(reservationListInfoArrayList);
        mRecyclerView.setAdapter(reservationListAdapter);

        Button closeBtn = (Button)findViewById(R.id.button13);
        Button checkBtn = (Button)findViewById(R.id.button14);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
