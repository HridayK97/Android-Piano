package com.example.hriday.virtualpiano;

import android.content.Intent;
import android.media.MediaRecorder;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import static com.example.hriday.virtualpiano.MainActivity.mFileName1;
import static com.example.hriday.virtualpiano.MainActivity.mFileName2;
import static com.example.hriday.virtualpiano.MainActivity.mFileName3;
import static com.example.hriday.virtualpiano.MainActivity.mFileName4;
import static com.example.hriday.virtualpiano.MainActivity.mFileName5;
import static com.example.hriday.virtualpiano.MainActivity.mFileName6;


public class recordings extends AppCompatActivity{
    private MediaPlayer mPlayer;
    boolean mStartPlaying = true;
    private Button record1;
    private Button record2;
    private Button record3;
    private Button record4;
    private Button record5;
    private Button record6;
    private boolean isplaying1;
    private boolean isplaying2;
    private boolean isplaying3;
    private boolean isplaying4;
    public boolean isplaying5;
    public boolean isplaying6;

    private boolean isplaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordings);
        record1=(Button)findViewById(R.id.record1);
        record2=(Button)findViewById(R.id.record2);
        record3=(Button)findViewById(R.id.record3);
        record4=(Button)findViewById(R.id.record4);
        record5=(Button)findViewById(R.id.record5);
        record6=(Button)findViewById(R.id.record6);
        isplaying1=false;
        isplaying2=false;
        isplaying3=false;
        isplaying4=false;
        isplaying5=false;
        isplaying6=false;

        isplaying=false;


    }


    public void play1(View view) {


        if(!isplaying1&&!isplaying) {
            record1.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(1);
            isplaying1 = true;
            isplaying=true;

        }
        else if(!isplaying1&&isplaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);
            isplaying1=false;
            isplaying2=false;
            isplaying3=false;
            isplaying4=false;
            isplaying5=false;
            isplaying6=false;

            record1.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(1);
            isplaying1 = true;



        }
        else {
            record1.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying1 = false;
            isplaying=false;
        }
    }
    public void play2(View view) {
        if(!isplaying2&&!isplaying) {
            record2.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(2);
            isplaying2 = true;
            isplaying=true;
        }
        else if(!isplaying2&&isplaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);
            isplaying1=false;
            isplaying2=false;
            isplaying3=false;
            isplaying4=false;
            isplaying5=false;
            isplaying6=false;

            record2.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(2);
            isplaying2 = true;

        }
        else {
            record2.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying2 = false;
            isplaying=false;
        }
    }
    public void play3(View view) {
        if(!isplaying3&&!isplaying) {
            record3.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(3);
            isplaying3 = true;
            isplaying=true;
        }
        else if(!isplaying3&&isplaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);
            isplaying1=false;
            isplaying2=false;
            isplaying3=false;
            isplaying4=false;
            isplaying5=false;
            isplaying6=false;

            record3.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(3);
            isplaying3 = true;

        }
        else {
            record3.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying3 = false;
            isplaying=false;
        }
    }
    public void play4(View view) {
        if(!isplaying4&&!isplaying) {
            record4.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(4);
            isplaying4 = true;
            isplaying=true;
        }
        else if(!isplaying4&&isplaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);
            isplaying1=false;
            isplaying2=false;
            isplaying3=false;
            isplaying4=false;
            isplaying5=false;
            isplaying6=false;;
            isplaying5=false;

            record4.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(4);
            isplaying4 = true;

        }
        else {
            record4.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying4 = false;
            isplaying=false;
        }
    }
    public void play5(View view) {
        if(!isplaying5&&!isplaying) {
            record5.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(5);
            isplaying5 = true;
            isplaying=true;
        }
        else if(!isplaying5&&isplaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);
            isplaying1=false;
            isplaying2=false;
            isplaying3=false;
            isplaying4=false;
            isplaying5=false;
            isplaying6=false;

            record5.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(5);
            isplaying5 = true;

        }
        else {
            record5.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying5 = false;
            isplaying=false;
        }
    }

    public void play6(View view){
        if(!isplaying6&&!isplaying) {
            record6.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(6);
            isplaying6 = true;
            isplaying=true;
        }
        else if(!isplaying6&&isplaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);
            isplaying1=false;
            isplaying2=false;
            isplaying3=false;
            isplaying4=false;
            isplaying5=false;
            isplaying6=false;

            record6.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(6);
            isplaying6 = true;

        }
        else {
            record6.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying6 = false;
            isplaying=false;
        }
    }

    private void startPlaying(int recordingno) {
        mPlayer = new MediaPlayer();
        try {
            switch(recordingno){
                case 1: mPlayer.setDataSource(mFileName1);
                    break;
                case 2: mPlayer.setDataSource(mFileName2);
                    break;
                case 3: mPlayer.setDataSource(mFileName3);
                    break;
                case 4: mPlayer.setDataSource(mFileName4);
                    break;
                case 5: mPlayer.setDataSource(mFileName5);
                    break;
                case 6: mPlayer.setDataSource(mFileName6);
                    break;
            }
            //mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();

            //while(mPlayer.isPlaying())
            //{}
            //record1.setBackgroundResource(R.drawable.playsongshape);
        } catch (IOException e) {
            Log.e("Player", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer =null;
    }


    protected void onPause(){
        super.onPause();
        if(mPlayer!=null) {
            mPlayer.release();

            mPlayer = null;
        }

    }


    protected void onStop(){
        super.onStop();
        if(mPlayer!=null) {
            mPlayer.release();

            mPlayer = null;
        }


    }
}
