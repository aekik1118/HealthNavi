package com.example.won.healthnavi.reservationListRecyclerView;

/**
 * Created by WON on 2018-11-29.
 */

public class ReservationListInfo {
    public String reservationTime;
    public boolean isResvationEmpty;

    public ReservationListInfo(String reservationTime, boolean isResvationEmpty){
        this.reservationTime = reservationTime;
        this.isResvationEmpty = isResvationEmpty;
    }
}
