package com.example.won.healthnavi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import java.net.URISyntaxException;

public class ReservationActivity extends AppCompatActivity {

    private Socket socket;
    {
        try{
            socket = IO.socket("http://ec2-52-78-240-135.ap-northeast-2.compute.amazonaws.com:9000");
            //https로 사용했다가 삽질..
        } catch (URISyntaxException ue) {
            ue.printStackTrace();
        }
    }

    private Emitter.Listener onNew = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Button fiBtn = (Button)findViewById(R.id.button7);
                    int val = (int)args[0];
                    if(val == 0)
                    {
                        fiBtn.setBackgroundColor(Color.RED);
                        Toast.makeText(ReservationActivity.this,"val == 0",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        fiBtn.setBackgroundColor(Color.GREEN);
                        Toast.makeText(ReservationActivity.this,"val == 1",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Button FitnessEquipmentBtn1 = (Button)findViewById(R.id.button7);
        Button FitnessEquipmentBtn2 = (Button)findViewById(R.id.button8);
        Button FitnessEquipmentBtn3 = (Button)findViewById(R.id.button9);
        Button FitnessEquipmentBtn4 = (Button)findViewById(R.id.button10);
        Button FitnessEquipmentBtn5 = (Button)findViewById(R.id.button11);
        Button FitnessEquipmentBtn6 = (Button)findViewById(R.id.button12);

        socket.on("checkOn",onNew);
        socket.connect();

        FitnessEquipmentBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socket.emit("checkIn");
            }
        });


    }


}
