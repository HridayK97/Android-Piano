package com.example.hriday.virtualpiano;
//color #ffcccccc

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.media.MediaRecorder;
        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.os.Environment;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.HorizontalScrollView;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;


        import org.billthefarmer.mididriver.MidiDriver;

        import java.io.File;
        import java.io.IOException;

        import static android.R.attr.duration;
        import static com.example.hriday.virtualpiano.R.id.text;

public class MainActivity extends AppCompatActivity implements MidiDriver.OnMidiStartListener,
        View.OnTouchListener, AdapterView.OnItemSelectedListener {

    private MidiDriver midiDriver;
    private byte[] event;
    private int[] config;
    private int octaveno;
    public int recordingno;


    private HorizontalScrollView scrollpiano;
    private TextView octave;


    private Button buttonC3;
    private Button buttonC3sharp;
    private Button buttonD3;
    private Button buttonD3sharp;
    private Button buttonE3;
    private Button buttonF3;
    private Button buttonF3sharp;
    private Button buttonG3;
    private Button buttonG3sharp;
    private Button buttonA3;
    private Button buttonA3sharp;
    private Button buttonB3;

    private Button buttonC4;
    private Button buttonC4sharp;
    private Button buttonD4;
    private Button buttonD4sharp;
    private Button buttonE4;
    private Button buttonF4;
    private Button buttonF4sharp;
    private Button buttonG4;
    private Button buttonG4sharp;
    private Button buttonA4;
    private Button buttonA4sharp;
    private Button buttonB4;

    private Button buttonC5;
    private Button buttonC5sharp;
    private Button buttonD5;
    private Button buttonD5sharp;
    private Button buttonE5;
    private Button buttonF5;
    private Button buttonF5sharp;
    private Button buttonG5;
    private Button buttonG5sharp;
    private Button buttonA5;
    private Button buttonA5sharp;
    private Button buttonB5;

    private Button buttonC6;
    private Button buttonC6sharp;
    private Button buttonD6;
    private Button buttonD6sharp;
    private Button buttonE6;
    private Button buttonF6;
    private Button buttonF6sharp;
    private Button buttonG6;
    private Button buttonG6sharp;
    private Button buttonA6;
    private Button buttonA6sharp;
    private Button buttonB6;

    private Button buttonC7;
    private Button buttonC7sharp;
    private Button buttonD7;
    private Button buttonD7sharp;
    private Button buttonE7;
    private Button buttonF7;
    private Button buttonF7sharp;
    private Button buttonG7;
    private Button buttonG7sharp;
    private Button buttonA7;
    private Button buttonA7sharp;
    private Button buttonB7;


    private TextView tc3;
    private TextView td3;
    private TextView te3;
    private TextView tf3;
    private TextView tg3;
    private TextView ta3;
    private TextView tb3;

    private TextView tc4;
    private TextView td4;
    private TextView te4;
    private TextView tf4;
    private TextView tg4;
    private TextView ta4;
    private TextView tb4;

    private TextView tc5;
    private TextView td5;
    private TextView te5;
    private TextView tf5;
    private TextView tg5;
    private TextView ta5;
    private TextView tb5;

    private TextView tc6;
    private TextView td6;
    private TextView te6;
    private TextView tf6;
    private TextView tg6;
    private TextView ta6;
    private TextView tb6;

    private TextView tc7;
    private TextView td7;
    private TextView te7;
    private TextView tf7;
    private TextView tg7;
    private TextView ta7;
    private TextView tb7;




    private Button nextbutton;
    private Button prevbutton;




    private Spinner spinnerInstruments;

    private MediaRecorder mRecorder;
    private MediaPlayer   mPlayer;
    public static String mFileName1 = null;
    public static String mFileName2 = null;
    public static String mFileName3 = null;
    public static String mFileName4 = null;
    public static String mFileName5 = null;
    public static String mFileName6 = null;
    private Button recordbutton;
    private Button playbutton;
    boolean mStartRecording = true;
    boolean mStartPlaying = true;
    //File audiofile = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFileName1 = getExternalCacheDir().getAbsolutePath();
        mFileName1 += "/audiorecordtest1.3gp";
        mFileName2 = getExternalCacheDir().getAbsolutePath();
        mFileName2 += "/audiorecordtest2.3gp";
        mFileName3 = getExternalCacheDir().getAbsolutePath();
        mFileName3 += "/audiorecordtest3.3gp";
        mFileName4 = getExternalCacheDir().getAbsolutePath();
        mFileName4 += "/audiorecordtest4.3gp";
        mFileName5 = getExternalCacheDir().getAbsolutePath();
        mFileName5 += "/audiorecordtest5.3gp";
        mFileName6 = getExternalCacheDir().getAbsolutePath();
        mFileName6 += "/audiorecordtest6.3gp";
        SharedPreferences prefs = getSharedPreferences("FILENO", MODE_PRIVATE);
        recordingno= prefs.getInt("fileno", 1);


        // Set up the buttons.
        recordbutton=(Button)findViewById(R.id.record) ;
        //playbutton=(Button)findViewById(R.id.play);
        //nextbutton=(Button)findViewById(R.id.next);
        //prevbutton=(Button)findViewById(R.id.previous);
        //recordingno=1;
        //octave=(TextView) findViewById(R.id.octave);

        scrollpiano=(HorizontalScrollView)findViewById(R.id.scrollpiano);

        buttonC3 = (Button)findViewById(R.id.w1);
        buttonC3.setOnTouchListener(this);
        buttonC3sharp = (Button)findViewById(R.id.b1);
        buttonC3sharp.setOnTouchListener(this);
        buttonD3 = (Button)findViewById(R.id.w2);
        buttonD3.setOnTouchListener(this);
        buttonD3sharp = (Button)findViewById(R.id.b2);
        buttonD3sharp.setOnTouchListener(this);
        buttonE3 = (Button)findViewById(R.id.w3);
        buttonE3.setOnTouchListener(this);
        buttonF3 = (Button)findViewById(R.id.w4);
        buttonF3.setOnTouchListener(this);
        buttonF3sharp = (Button)findViewById(R.id.b3);
        buttonF3sharp.setOnTouchListener(this);
        buttonG3 = (Button)findViewById(R.id.w5);
        buttonG3.setOnTouchListener(this);
        buttonG3sharp = (Button)findViewById(R.id.b4);
        buttonG3sharp.setOnTouchListener(this);
        buttonA3 = (Button)findViewById(R.id.w6);
        buttonA3.setOnTouchListener(this);
        buttonA3sharp = (Button)findViewById(R.id.b5);
        buttonA3sharp.setOnTouchListener(this);
        buttonB3 = (Button)findViewById(R.id.w7);
        buttonB3.setOnTouchListener(this);

        buttonC4 = (Button)findViewById(R.id.w8);
        buttonC4.setOnTouchListener(this);
        buttonC4sharp = (Button)findViewById(R.id.b6);
        buttonC4sharp.setOnTouchListener(this);
        buttonD4 = (Button)findViewById(R.id.w9);
        buttonD4.setOnTouchListener(this);
        buttonD4sharp = (Button)findViewById(R.id.b7);
        buttonD4sharp.setOnTouchListener(this);
        buttonE4 = (Button)findViewById(R.id.w10);
        buttonE4.setOnTouchListener(this);
        buttonF4 = (Button)findViewById(R.id.w11);
        buttonF4.setOnTouchListener(this);
        buttonF4sharp = (Button)findViewById(R.id.b8);
        buttonF4sharp.setOnTouchListener(this);
        buttonG4 = (Button)findViewById(R.id.w12);
        buttonG4.setOnTouchListener(this);
        buttonG4sharp = (Button)findViewById(R.id.b9);
        buttonG4sharp.setOnTouchListener(this);
        buttonA4 = (Button)findViewById(R.id.w13);
        buttonA4.setOnTouchListener(this);
        buttonA4sharp = (Button)findViewById(R.id.b10);
        buttonA4sharp.setOnTouchListener(this);
        buttonB4 = (Button)findViewById(R.id.w14);
        buttonB4.setOnTouchListener(this);

        buttonC5 = (Button)findViewById(R.id.w15);
        buttonC5.setOnTouchListener(this);
        buttonC5sharp = (Button)findViewById(R.id.b11);
        buttonC5sharp.setOnTouchListener(this);
        buttonD5 = (Button)findViewById(R.id.w16);
        buttonD5.setOnTouchListener(this);
        buttonD5sharp = (Button)findViewById(R.id.b12);
        buttonD5sharp.setOnTouchListener(this);
        buttonE5 = (Button)findViewById(R.id.w17);
        buttonE5.setOnTouchListener(this);
        buttonF5 = (Button)findViewById(R.id.w18);
        buttonF5.setOnTouchListener(this);
        buttonF5sharp = (Button)findViewById(R.id.b13);
        buttonF5sharp.setOnTouchListener(this);
        buttonG5 = (Button)findViewById(R.id.w19);
        buttonG5.setOnTouchListener(this);
        buttonG5sharp = (Button)findViewById(R.id.b14);
        buttonG5sharp.setOnTouchListener(this);
        buttonA5 = (Button)findViewById(R.id.w20);
        buttonA5.setOnTouchListener(this);
        buttonA5sharp = (Button)findViewById(R.id.b15);
        buttonA5sharp.setOnTouchListener(this);
        buttonB5 = (Button)findViewById(R.id.w21);
        buttonB5.setOnTouchListener(this);

        buttonC6 = (Button)findViewById(R.id.w22);
        buttonC6.setOnTouchListener(this);
        buttonC6sharp = (Button)findViewById(R.id.b16);
        buttonC6sharp.setOnTouchListener(this);
        buttonD6 = (Button)findViewById(R.id.w23);
        buttonD6.setOnTouchListener(this);
        buttonD6sharp = (Button)findViewById(R.id.b17);
        buttonD6sharp.setOnTouchListener(this);
        buttonE6 = (Button)findViewById(R.id.w24);
        buttonE6.setOnTouchListener(this);
        buttonF6 = (Button)findViewById(R.id.w25);
        buttonF6.setOnTouchListener(this);
        buttonF6sharp = (Button)findViewById(R.id.b18);
        buttonF6sharp.setOnTouchListener(this);
        buttonG6 = (Button)findViewById(R.id.w26);
        buttonG6.setOnTouchListener(this);
        buttonG6sharp = (Button)findViewById(R.id.b19);
        buttonG6sharp.setOnTouchListener(this);
        buttonA6 = (Button)findViewById(R.id.w27);
        buttonA6.setOnTouchListener(this);
        buttonA6sharp = (Button)findViewById(R.id.b20);
        buttonA6sharp.setOnTouchListener(this);
        buttonB6 = (Button)findViewById(R.id.w28);
        buttonB6.setOnTouchListener(this);

        buttonC7 = (Button)findViewById(R.id.w29);
        buttonC7.setOnTouchListener(this);
        buttonC7sharp = (Button)findViewById(R.id.b21);
        buttonC7sharp.setOnTouchListener(this);
        buttonD7 = (Button)findViewById(R.id.w30);
        buttonD7.setOnTouchListener(this);
        buttonD7sharp = (Button)findViewById(R.id.b22);
        buttonD7sharp.setOnTouchListener(this);
        buttonE7 = (Button)findViewById(R.id.w31);
        buttonE7.setOnTouchListener(this);
        buttonF7 = (Button)findViewById(R.id.w32);
        buttonF7.setOnTouchListener(this);
        buttonF7sharp = (Button)findViewById(R.id.b23);
        buttonF7sharp.setOnTouchListener(this);
        buttonG7 = (Button)findViewById(R.id.w33);
        buttonG7.setOnTouchListener(this);
        buttonG7sharp = (Button)findViewById(R.id.b24);
        buttonG7sharp.setOnTouchListener(this);
        buttonA7 = (Button)findViewById(R.id.w34);
        buttonA7.setOnTouchListener(this);
        buttonA7sharp = (Button)findViewById(R.id.b25);
        buttonA7sharp.setOnTouchListener(this);
        buttonB7 = (Button)findViewById(R.id.w35);
        buttonB7.setOnTouchListener(this);



        tc3=(TextView)findViewById(R.id.tc3);
        td3=(TextView)findViewById(R.id.td3);
        te3=(TextView)findViewById(R.id.te3);
        tf3=(TextView)findViewById(R.id.tf3);
        tg3=(TextView)findViewById(R.id.tg3);
        ta3=(TextView)findViewById(R.id.ta3);
        tb3=(TextView)findViewById(R.id.tb3);

        tc4=(TextView)findViewById(R.id.tc4);
        td4=(TextView)findViewById(R.id.td4);
        te4=(TextView)findViewById(R.id.te4);
        tf4=(TextView)findViewById(R.id.tf4);
        tg4=(TextView)findViewById(R.id.tg4);
        ta4=(TextView)findViewById(R.id.ta4);
        tb4=(TextView)findViewById(R.id.tb4);

        tc5=(TextView)findViewById(R.id.tc5);
        td5=(TextView)findViewById(R.id.td5);
        te5=(TextView)findViewById(R.id.te5);
        tf5=(TextView)findViewById(R.id.tf5);
        tg5=(TextView)findViewById(R.id.tg5);
        ta5=(TextView)findViewById(R.id.ta5);
        tb5=(TextView)findViewById(R.id.tb5);

        tc6=(TextView)findViewById(R.id.tc6);
        td6=(TextView)findViewById(R.id.td6);
        te6=(TextView)findViewById(R.id.te6);
        tf6=(TextView)findViewById(R.id.tf6);
        tg6=(TextView)findViewById(R.id.tg6);
        ta6=(TextView)findViewById(R.id.ta6);
        tb6=(TextView)findViewById(R.id.tb6);

        tc7=(TextView)findViewById(R.id.tc7);
        td7=(TextView)findViewById(R.id.td7);
        te7=(TextView)findViewById(R.id.te7);
        tf7=(TextView)findViewById(R.id.tf7);
        tg7=(TextView)findViewById(R.id.tg7);
        ta7=(TextView)findViewById(R.id.ta7);
        tb7=(TextView)findViewById(R.id.tb7);


        tc3.setOnTouchListener(this);
        td3.setOnTouchListener(this);
        te3.setOnTouchListener(this);
        tf3.setOnTouchListener(this);
        tg3.setOnTouchListener(this);
        ta3.setOnTouchListener(this);
        tb3.setOnTouchListener(this);

        tc4.setOnTouchListener(this);
        td4.setOnTouchListener(this);
        te4.setOnTouchListener(this);
        tf4.setOnTouchListener(this);
        tg4.setOnTouchListener(this);
        ta4.setOnTouchListener(this);
        tb4.setOnTouchListener(this);

        tc5.setOnTouchListener(this);
        td5.setOnTouchListener(this);
        te5.setOnTouchListener(this);
        tf5.setOnTouchListener(this);
        tg5.setOnTouchListener(this);
        ta5.setOnTouchListener(this);
        tb5.setOnTouchListener(this);

        tc6.setOnTouchListener(this);
        td6.setOnTouchListener(this);
        te6.setOnTouchListener(this);
        tf6.setOnTouchListener(this);
        tg6.setOnTouchListener(this);
        ta6.setOnTouchListener(this);
        tb6.setOnTouchListener(this);

        tc7.setOnTouchListener(this);
        td7.setOnTouchListener(this);
        te7.setOnTouchListener(this);
        tf7.setOnTouchListener(this);
        tg7.setOnTouchListener(this);
        ta7.setOnTouchListener(this);
        tb7.setOnTouchListener(this);
       scrollpiano.post(new Runnable() {
            public void run() {

                int vLeft = buttonF5.getLeft();
                int vRight = buttonF5.getRight();
                int sWidth = scrollpiano.getWidth();
                scrollpiano.scrollTo(((vLeft + vRight - sWidth) / 2),0);
            }
        }
        );


        //octave.setText("Octave "+octaveno);

        // Set up the instruments spinner.
        /*spinnerInstruments = (Spinner)findViewById(R.id.spinnerInstruments);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.instruments_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInstruments.setAdapter(adapter);
        spinnerInstruments.setOnItemSelectedListener(this);*/

        // Instantiate the driver.
        midiDriver = new MidiDriver();
        // Set the listener.
        midiDriver.setOnMidiStartListener(this);
    }

    public void record(View view)
    {    onRecord(mStartRecording);
        if (mStartRecording) {
            recordbutton.setText("Finish");
            recordbutton.setBackgroundResource(R.drawable.recordbuttonpressed);
        } else {
            recordbutton.setText("Record");
            recordbutton.setBackgroundResource(R.drawable.recordbutton);
        }
        mStartRecording = !mStartRecording;

    }
    public void play(View view)
    {  /* onPlay(mStartPlaying);
        if (mStartPlaying) {
            playbutton.setText("Stop playing");
        } else {
            playbutton.setText("Start playing");
        }
        mStartPlaying = !mStartPlaying;
        */

        Intent recordingsintent = new Intent(this,recordings.class);
        startActivity(recordingsintent);
    }
    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
            if(recordingno==1)
            {
                Toast recordingmsg = Toast.makeText(getApplicationContext(),"Song "+6+" saved", Toast.LENGTH_SHORT);
                recordingmsg.show();
            }
            else
            {   int temprecordingno=recordingno-1;
                Toast recordingmsg = Toast.makeText(getApplicationContext(),"Song "+temprecordingno+" Saved", Toast.LENGTH_LONG);
                recordingmsg.show();
            }
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }
    private void startPlaying() {
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
        } catch (IOException e) {
            Log.e("Player", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {

        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
    switch(recordingno) {


        case 1:
            mRecorder.setOutputFile(mFileName1);
            recordingno++;
            if(recordingno==7)
                recordingno=1;
            break;
        case 2:
            mRecorder.setOutputFile(mFileName2);
            recordingno++;
            if(recordingno==7)
                recordingno=1;
            break;
        case 3:
            mRecorder.setOutputFile(mFileName3);
            recordingno++;
            if(recordingno==7)
                recordingno=1;
            break;
        case 4:
            mRecorder.setOutputFile(mFileName4);
            recordingno++;
            if(recordingno==7)
                recordingno=1;
            break;
        case 5:
            mRecorder.setOutputFile(mFileName5);
            recordingno++;
            if(recordingno==7)
                recordingno=1;
            break;
        case 6:
            mRecorder.setOutputFile(mFileName6);
            recordingno++;
            if(recordingno==7)
                recordingno=1;
            break;
    }

        SharedPreferences.Editor editor = getSharedPreferences("FILENO", MODE_PRIVATE).edit();
        editor.putInt("fileno",recordingno);
        editor.commit();
       // mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e("prepare fail", "prepare() failed");
        }
        Log.d("recorder has started","recorder has started");
        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        midiDriver.start();

        // Get the configuration.
        config = midiDriver.config();

        // Print out the details.
        Log.d(this.getClass().getName(), "maxVoices: " + config[0]);
        Log.d(this.getClass().getName(), "numChannels: " + config[1]);
        Log.d(this.getClass().getName(), "sampleRate: " + config[2]);
        Log.d(this.getClass().getName(), "mixBufferSize: " + config[3]);


    }

    @Override
    protected void onPause() {
        super.onPause();
        midiDriver.stop();
        if(mPlayer!=null) {
            mPlayer.release();

            mPlayer = null;
        }
    }

    @Override
    public void onMidiStart() {
        Log.d(this.getClass().getName(), "onMidiStart()");
    }

    private void playNote(int noteNumber) {

        // Construct a note ON message for the note at maximum velocity on channel 1:
        event = new byte[3];
        event[0] = (byte) (0x90 | 0x00);  // 0x90 = note On, 0x00 = channel 1
        event[1] = (byte) noteNumber;
        event[2] = (byte) 0x7F;  // 0x7F = the maximum velocity (127)

        // Send the MIDI event to the synthesizer.
        midiDriver.write(event);

    }

    private void stopNote(int noteNumber, boolean sustainUpEvent) {

        // Stop the note unless the sustain button is currently pressed. Or stop the note if the
        // sustain button was depressed and the note's button is not pressed.
        if (sustainUpEvent) {
            // Construct a note OFF message for the note at minimum velocity on channel 1:
            event = new byte[3];
            event[0] = (byte) (0x80 | 0x00);  // 0x80 = note Off, 0x00 = channel 1
            event[1] = (byte) noteNumber;
            event[2] = (byte) 0x00;  // 0x00 = the minimum velocity (0)

            // Send the MIDI event to the synthesizer.
            midiDriver.write(event);
        }
    }

    private void selectInstrument(int instrument) {

        // Construct a program change to select the instrument on channel 1:
        event = new byte[2];
        event[0] = (byte)(0xC0 | 0x00); // 0xC0 = program change, 0x00 = channel 1
        event[1] = (byte)instrument;

        // Send the MIDI event to the synthesizer.
        midiDriver.write(event);

    }
    public void next(View view) {

        octaveno = octaveno + 1;
        octave.setText("Octave "+octaveno);
        prevbutton.setEnabled(true);
        if(octaveno==8)
            nextbutton.setEnabled(false);

    }
    public void prev(View view) {
        octaveno = octaveno - 1;
        octave.setText("Octave "+octaveno);
        nextbutton.setEnabled(true);
        if(octaveno==2)
            prevbutton.setEnabled(false);

    }





    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Log.d(this.getClass().getName(), "Motion event: " + event);


            // Stop any notes whose buttons are not held down.
            if (!buttonC3.isPressed()) {
                stopNote(octaveno*12, true);
            }
            if (!buttonC3sharp.isPressed()) {
                stopNote(octaveno*12+1, true);
            }
            if (!buttonD3.isPressed()) {
                stopNote(octaveno*12+2, true);
            }
            if (!buttonD3sharp.isPressed()) {
                stopNote(octaveno*12+3, true);
            }
            if (!buttonE3.isPressed()) {
                stopNote(octaveno*12+4, true);
            }
            if (!buttonF3.isPressed()) {
                stopNote(octaveno*12+5, true);
            }
            if (!buttonF3sharp.isPressed()) {
                stopNote(octaveno*12+6, true);
            }if (!buttonG3.isPressed()) {
                stopNote(octaveno*12+7, true);
            }
            if (!buttonG3sharp.isPressed()) {
                stopNote(octaveno*12+8, true);
            }
            if (!buttonA3.isPressed()) {
                stopNote(octaveno*12+9, true);
            }
            if (!buttonA3sharp.isPressed()) {
                stopNote(octaveno*12+10, true);
            }
            if (!buttonB3.isPressed()) {
                stopNote(octaveno*12+11, true);



        }

        int noteNumber;

        switch (v.getId()) {


            //case R.id.tc3:
            case R.id.w1:
                noteNumber = 36;
                //buttonC3.setPressed(false);
                break;
            case R.id.b1:
                noteNumber = 37;
                break;

            case R.id.td3:
            case R.id.w2:
                noteNumber = 38;
                break;
            case R.id.b2:
                noteNumber = 39;
                break;

            case R.id.te3:
            case R.id.w3:
                noteNumber = 40;
                break;

            case R.id.tf3:
            case R.id.w4:
                noteNumber = 41;
                break;
            case R.id.b3:
                noteNumber = 42;
                break;

            case R.id.tg3:
            case R.id.w5:
                noteNumber = 43;
                break;
            case R.id.b4:
                noteNumber = 44;
                break;

            case R.id.ta3:
            case R.id.w6:
                noteNumber = 45;
                break;
            case R.id.b5:
                noteNumber = 46;
                break;

            case R.id.tb3:
            case R.id.w7:
                noteNumber = 47;
                break;

            case R.id.tc4:
            case R.id.w8:
                noteNumber = 48;
                break;
            case R.id.b6:
                noteNumber = 49;
                break;

            case R.id.td4:
            case R.id.w9:
                noteNumber = 50;
                break;
            case R.id.b7:
                noteNumber = 51;
                break;

            case R.id.te4:
            case R.id.w10:
                noteNumber = 52;
                break;

            case R.id.tf4:
            case R.id.w11:
                noteNumber = 53;
                break;
            case R.id.b8:
                noteNumber = 54;
                break;

            case R.id.tg4:
            case R.id.w12:
                noteNumber = 55;
                break;
            case R.id.b9:
                noteNumber = 56;
                break;

            case R.id.ta4:
            case R.id.w13:
                noteNumber = 57;
                break;
            case R.id.b10:
                noteNumber = 58;
                break;

            case R.id.tb4:
            case R.id.w14:
                noteNumber = 59;
                break;

            case R.id.tc5:
            case R.id.w15:
                noteNumber = 60;
                break;
            case R.id.b11:
                noteNumber = 61;
                break;

            case R.id.td5:
            case R.id.w16:
                noteNumber = 62;
                break;
            case R.id.b12:
                noteNumber = 63;
                break;

            case R.id.te5:
            case R.id.w17:
                noteNumber = 64;
                break;

            case R.id.tf5:
            case R.id.w18:
                noteNumber = 65;
                break;
            case R.id.b13:
                noteNumber = 66;
                break;

            case R.id.tg5:
            case R.id.w19:
                noteNumber = 67;
                break;
            case R.id.b14:
                noteNumber = 68;
                break;

            case R.id.ta5:
            case R.id.w20:
                noteNumber = 69;
                break;
            case R.id.b15:
                noteNumber = 70;
                break;

            case R.id.tb5:
            case R.id.w21:
                noteNumber = 71;
                break;


            case R.id.tc6:
            case R.id.w22:
                noteNumber = 72;
                break;
            case R.id.b16:
                noteNumber = 73;
                break;

            case R.id.td6:
            case R.id.w23:
                noteNumber = 74;
                break;
            case R.id.b17:
                noteNumber = 75;
                break;

            case R.id.te6:
            case R.id.w24:
                noteNumber = 76;
                break;

            case R.id.tf6:
            case R.id.w25:
                noteNumber = 77;
                break;
            case R.id.b18:
                noteNumber = 78;
                break;

            case R.id.tg6:
            case R.id.w26:
                noteNumber = 79;
                break;
            case R.id.b19:
                noteNumber = 80;
                break;

            case R.id.ta6:
            case R.id.w27:
                noteNumber = 81;
                break;
            case R.id.b20:
                noteNumber = 82;
                break;

            case R.id.tb6:
            case R.id.w28:
                noteNumber = 83;
                break;


            case R.id.tc7:
            case R.id.w29:
                noteNumber = 84;
                break;
            case R.id.b21:
                noteNumber = 85;
                break;

            case R.id.td7:
            case R.id.w30:
                noteNumber = 86;
                break;
            case R.id.b22:
                noteNumber = 87;
                break;

            case R.id.te7:
            case R.id.w31:
                noteNumber = 88;
                break;

            case R.id.tf7:
            case R.id.w32:
                noteNumber = 89;
                break;
            case R.id.b23:
                noteNumber = 90;
                break;

            case R.id.tg7:
            case R.id.w33:
                noteNumber = 91;
                break;
            case R.id.b24:
                noteNumber = 92;
                break;

            case R.id.ta7:
            case R.id.w34:
                noteNumber = 93;
                break;
            case R.id.b25:
                noteNumber = 94;
                break;

            case R.id.tb7:
            case R.id.w35:
                noteNumber = 95;
                break;

            default:
                noteNumber = -1;
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d(this.getClass().getName(), "MotionEvent.ACTION_DOWN");
            playNote(noteNumber);
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.d(this.getClass().getName(), "MotionEvent.ACTION_UP");
            stopNote(noteNumber, false);
        }

        return false;
    }

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p/>
     * Impelmenters can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectInstrument(position);
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
