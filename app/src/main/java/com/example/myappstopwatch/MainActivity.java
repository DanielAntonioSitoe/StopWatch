package com.example.myappstopwatch;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int seconds = 0;
    private boolean running ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
        }
        runtimer();
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }


    public void start(View view){
        running = true;

    }

    public void stop(View view){
        running = false;

    }

    public void reset(View view){
        running = false;
        seconds = 0;

    }
    private void runtimer(){
        final TextView timeView = (TextView) findViewById(R.id.textView2);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int horas = seconds/3600;
                int minutos = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d",horas,minutos,secs);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);

            }
        });

    }


}
