package com.study.apptimer;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {
    Handler handler;
    Thread thread;
    int sec_count = -1;
    int min_count = 0;
    int hour_count = 0;
    TextView txt_hour;
    TextView txt_min;
    TextView txt_sec;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_hour = (TextView) findViewById(R.id.txt_hour);
        txt_min = (TextView) findViewById(R.id.txt_min);
        txt_sec = (TextView) findViewById(R.id.txt_sec);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                txt_sec.setText(Integer.toString(sec_count));
                txt_min.setText(Integer.toString(min_count));
                txt_hour.setText(Integer.toString(hour_count));
            }
        };
        thread = new Thread() {
            @Override
            public void run() {
                while (sec_count < 61) {
                    if (flag) {
                        sec_count++;
                        if (sec_count == 61) {
                            sec_count = 1;
                            min_count++;
                            if (min_count == 61) {
                                min_count = 1;
                                hour_count++;
                                if (hour_count == 25) {
                                    hour_count = 1;
                                }
                            }
                        }
                        try {
                            handler.sendEmptyMessage(0);
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread.start();
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
                flag = true;
                break;
            case R.id.bt_stop:
                flag = false;
                break;
            case R.id.bt_reset:
                reset();
                break;
        }
    }

    public void reset() {
        sec_count = 0;
        min_count = 0;
        hour_count = 0;
        txt_sec.setText(Integer.toString(sec_count));
        txt_min.setText(Integer.toString(min_count));
        txt_hour.setText(Integer.toString(hour_count));
        flag = false;

    }


}
