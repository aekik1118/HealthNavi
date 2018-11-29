package com.example.won.healthnavi.reservationListRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.won.healthnavi.R;

import java.util.ArrayList;

/**
 * Created by WON on 2018-11-29.
 */

public class ReservationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvReservationTime;
        TextView tvIsResvationEmpty;

        MyViewHolder(View view){
            super(view);
            tvReservationTime = view.findViewById(R.id.reservationTimeTxt);
            tvIsResvationEmpty = view.findViewById(R.id.reservationFlagTxt);
        }
    }

    private ArrayList<ReservationListInfo> reservationListInfoArrayList;
    ReservationListAdapter(ArrayList<ReservationListInfo> reservationListInfoArrayList){
        this.reservationListInfoArrayList = reservationListInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_list_recycler_view_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tvReservationTime.setText(reservationListInfoArrayList.get(position).reservationTime);
        if(reservationListInfoArrayList.get(position).isResvationEmpty)
            myViewHolder.tvIsResvationEmpty.setText("예약 가능");
        else
            myViewHolder.tvIsResvationEmpty.setText("예약 불가");
    }

    @Override
    public int getItemCount() {
        return reservationListInfoArrayList.size();
    }

}
