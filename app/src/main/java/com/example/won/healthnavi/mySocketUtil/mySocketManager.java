package com.example.won.healthnavi.mySocketUtil;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONObject;

import java.net.URISyntaxException;

/**
 * Created by WON on 2018-11-29.
 */

public class mySocketManager {
    private Socket socket;
    {
        try{
            socket = IO.socket("http://ec2-52-78-240-135.ap-northeast-2.compute.amazonaws.com:9000");
            //https로 사용했다가 삽질..
        } catch (URISyntaxException ue) {
            ue.printStackTrace();
        }
    }


    public void emit(String message,JSONObject obj )
    {



    }




}
