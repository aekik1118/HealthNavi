package com.example.won.healthnavi.reservationListRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.won.healthnavi.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by WON on 2018-11-29.
 */

public class ReservationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final ClickListener listener;
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Button btReservationSubmit;
        TextView tvReservationTime;
        TextView tvIsResvationEmpty;
        private WeakReference<ClickListener> listenerRef;

        MyViewHolder(View view, ClickListener listener){
            super(view);
            tvReservationTime = view.findViewById(R.id.reservationTimeTxt);
            tvIsResvationEmpty = view.findViewById(R.id.reservationFlagTxt);
            btReservationSubmit = view.findViewById(R.id.reservationButton);

            btReservationSubmit.setOnClickListener(this);
            listenerRef = new WeakReference<ClickListener>(listener);
        }
        @Override
        public void onClick(View v) {
            if (v.getId() == btReservationSubmit.getId()) {
                Toast.makeText(v.getContext(), "ITEM PRESSED = ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(v.getContext(), "ROW PRESSED = " , Toast.LENGTH_SHORT).show();
            }

            listenerRef.get().onPositionClicked(getAdapterPosition());
        }

    }

    private ArrayList<ReservationListInfo> reservationListInfoArrayList;
    ReservationListAdapter(ArrayList<ReservationListInfo> reservationListInfoArrayList, ClickListener listener){
        this.reservationListInfoArrayList = reservationListInfoArrayList;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_list_recycler_view_item, parent, false);
        return new MyViewHolder(v, listener);
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
