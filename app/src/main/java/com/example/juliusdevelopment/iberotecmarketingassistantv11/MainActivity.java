package com.example.juliusdevelopment.iberotecmarketingassistantv11;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
//import android.provider.MediaStore;
import android.provider.MediaStore;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
//import android.widget.Toast;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity implements MyListFragment.onItemSelectedListener,
        GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

    //Declaring controllers
    Button registrationButton,modeButton;
    Button videoMasterButton,pictureMasterButton;
    //Button registerButton;
    MediaController mdc1,mdc2;
    VideoView videoDeMuestra,videoDeMuestra2,videoDeMuestra3;
    String status="pictures";
    boolean hid=true;
    private GestureDetectorCompat mDetector;

    //Creating and declaring all
    //MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultando al principio el fragment
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.hide(getFragmentManager().findFragmentById(R.id.fragment1));
        ft.commit();
        hid=true;

        //Definiendo botones y sus eventos

        videoMasterButton=(Button)findViewById(R.id.videoMasterButton);
        pictureMasterButton=(Button)findViewById(R.id.pictureMasterButton);
        registrationButton=(Button)findViewById(R.id.registro_btn);
        modeButton=(Button)findViewById(R.id.mode_btn);


        videoMasterButton.setOnClickListener(centralHandler);
        pictureMasterButton.setOnClickListener(centralHandler);
        registrationButton.setOnClickListener(centralHandler);
        modeButton.setOnClickListener(centralHandler);
        //Fin de la definicion de botones

        videoDeMuestra=(VideoView) findViewById(R.id.videoView);

        String path1="android.resource://"+getPackageName()+"/"+R.raw.video_frecuencia_latina;
        //String path2="android.resource://"+getPackageName()+"/"+R.raw.video_globo;
        mdc1=new MediaController(this);
        videoDeMuestra.setVideoURI(Uri.parse(path1));
        mdc1.setAnchorView(videoDeMuestra);
        videoDeMuestra.setMediaController(mdc1);
        //videoDeMuestra.setMediaController(null);
        mDetector=new GestureDetectorCompat(this,this);
    }
    //New component hardcoded free
    private String getFileName(int index,TypedArray content){
        String finalString="";
        finalString = "android.resource://" + getPackageName() + "/" + content.getResourceId(index,-1);
        return finalString;
    }

    //Getting files from listfragment output strings
    //Defecto, está en código duro, task unhard it
    /*
    private String getFileName(String selector){
        String finalString="";
        switch (selector) {
            case "Hexacóptero":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_hexacoptero;
                break;
            case "Hexápodo":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_hexapodo;
                break;
            case "Redes":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_redes;
                break;
            case "Electrónica":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_electronica;
                break;
            case "Instituto1":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_instituto;
                break;
            case "Interior":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_interior_instituto;
                break;
            case "Telecomunicaciones":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_telecomunicaciones;
                break;
            case "Física":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_fisica;
                break;
            case "Domotica":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_domotica;
                break;
            case "Globo":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.picture_globo;
                break;
            case "Drone construido":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_drone_construido;
                break;
            case "Frecuencia Latina":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_frecuencia_latina;
                break;
            case "Globo video":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_globo;
                break;
            case "Superpoderes":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_superpoderes;
                break;
            case "Teleamor":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_teleamor;
                break;
            case "Mundo Moderno":
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_telecomunicaciones;
                break;
        }
        return finalString;
    }*/

    //Void for playing video
    private void playVideo(String path)
    {
        videoDeMuestra.setMediaController(mdc1);
        //String uriPath=path;
        Uri uri = Uri.parse(path);
        videoDeMuestra.setBackground(null);
        videoDeMuestra.setVideoURI(uri);
        videoDeMuestra.requestFocus();
        if(videoDeMuestra.isPlaying())
        {
            videoDeMuestra.stopPlayback();
        }
        videoDeMuestra.start();
    }
    //Void for showing pics
    private void showPicture(String path) throws IOException {
        videoDeMuestra.setMediaController(null);
        //String uriPath=path;
        Uri uri = Uri.parse(path);
        Bitmap bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);

        if(videoDeMuestra.isPlaying())
        {
            videoDeMuestra.stopPlayback();
        }
        //Bitmap bmd= BitmapFactory.decodeResource(getResources(), R.raw.picture_instituto);
        //Drawable d=new BitmapDrawable(getResources(),bmd);
        Drawable d=new BitmapDrawable(getResources(),bitmap);
        videoDeMuestra.setBackground(d);
        //InputStream stream=getContentResolver().openInputStream(uri);
        //videoDeMuestra.setBackground(stream);
        //videoDeMuestra.setBackground(getResources().getDrawable(R.raw.picture_electronica));
        //videoDeMuestra.start();
    }

    //Transforming common fragment into videoFragment
    public void callVideoFragment(){
        MyListFragment leListFragment= (MyListFragment) getFragmentManager().findFragmentById(R.id.fragment1);
        //leListFragment.testingMessage();
        if(modeButton.getText().toString().equals("Cara a Cara")){
            leListFragment.setVideoAdapter(true);
        }else{
            leListFragment.setVideoAdapter();
        }
        status="video";
        FragmentTransaction ft=getFragmentManager().beginTransaction();

        ft.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_left,0,0);

        ft.show(getFragmentManager().findFragmentById(R.id.fragment1));
        ft.commit();
        hid=false;
    }
    //Getting picture fragment
    public void callPictureFragment(){
        MyListFragment leListFragment= (MyListFragment) getFragmentManager().findFragmentById(R.id.fragment1);
        //leListFragment.testingMessage();

        if(modeButton.getText().toString().equals("Cara a Cara")){
            leListFragment.setPictureAdapter(true);
        }else{
            leListFragment.setPictureAdapter();
        }

        FragmentTransaction ft=getFragmentManager().beginTransaction();

        ft.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_left,0,0);

        ft.show(getFragmentManager().findFragmentById(R.id.fragment1));
        ft.commit();

        hid=false;
        status="pictures";
    }

    //Main Handler
    View.OnClickListener centralHandler=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String videoString;
            switch (v.getId()){
                //Button videoMasterButton,pictureMasterButton;
                case R.id.videoMasterButton:
                    //Toast.makeText(MainActivity.this, "Video !!!", Toast.LENGTH_SHORT).show();
                    callVideoFragment();
                    break;
                case R.id.pictureMasterButton:
                    //Toast.makeText(MainActivity.this, "Fotos !!!", Toast.LENGTH_SHORT).show();
                    callPictureFragment();
                    break;
                //playVideoTest(3);
                case R.id.registro_btn:
                    loadRegistrationPage();
                    break;
                case R.id.mode_btn:
                    changeMode();
                    break;
            }
        }
    };
    //Changing to face to face mode to together mode
    public void changeMode(){
        if(modeButton.getText().toString().equals("Cara a Cara")){
            modeButton.setText("Unipersonal");
            //Rotando el ListFragment
            MyListFragment leListFragment= (MyListFragment) getFragmentManager().findFragmentById(R.id.fragment1);
            //leListFragment.testingMessage();
            if(status.equals("video")){
                leListFragment.setVideoAdapter();
            }else if(status.equals("pictures")){
                leListFragment.setPictureAdapter();
            }
            //leListFragment.changeAdapter(false);
            //Rotando botonoes
            modeButton.setRotation(0);
            registrationButton.setRotation(0);
            videoMasterButton.setRotation(0);
            pictureMasterButton.setRotation(0);
            //Toast.makeText(MainActivity.this, "Éxito!!!", Toast.LENGTH_SHORT).show();
        }else{
            modeButton.setText("Cara a Cara");
            //Rotando el ListFragment
            MyListFragment leListFragment= (MyListFragment) getFragmentManager().findFragmentById(R.id.fragment1);
            //leListFragment.testingMessage();
            if(status.equals("video")){
                leListFragment.setVideoAdapter(true);
            }else if(status.equals("pictures")){
                leListFragment.setPictureAdapter(true);
            }
            //leListFragment.changeAdapter(true);
            modeButton.setRotation(180);
            registrationButton.setRotation(180);
            videoMasterButton.setRotation(180);
            pictureMasterButton.setRotation(180);
            //Toast.makeText(MainActivity.this, "Éxito también!!!", Toast.LENGTH_SHORT).show();
        }
    }
    //Void for registrating pages
    public void loadRegistrationPage(){
        Intent intent=new Intent(this,ClientRegistration.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Getting data from the list fragment
    @Override
    public void onItemSelected(int message) {
        String[] pictureTitles,videoTitles;
        TypedArray pictureId,videoId;
        pictureTitles=getResources().getStringArray(R.array.picture_titles);
        videoTitles=getResources().getStringArray(R.array.video_titles);
        pictureId=getResources().obtainTypedArray(R.array.picture_id);
        videoId=getResources().obtainTypedArray(R.array.video_id);
        //Hiding fragment
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.no_slide_in_left,R.animator.slide_out_left,0,0);
        ft.hide(getFragmentManager().findFragmentById(R.id.fragment1));
        ft.commit();
        hid=true;
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        //Declaring arrays


        if(status.equals("pictures")){
            //Toast.makeText(this, getFileName(message), Toast.LENGTH_LONG).show();
            try {
                //Toast.makeText(this, getFileName(0,pictureId), Toast.LENGTH_LONG).show();
                //Toast.makeText(this, getFileName(message), Toast.LENGTH_LONG).show();
                showPicture(getFileName(message,pictureId));
                //showPicture(getFileName(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(status.equals("video")){
            //getFileName(message,videoId);
            //Toast.makeText(this, getFileName(0,videoId), Toast.LENGTH_LONG).show();
            //Toast.makeText(this, getFileName(message), Toast.LENGTH_LONG).show();
            playVideo(getFileName(message,videoId));
            //playVideo(getFileName(message));
        }
    }
    //Gestures Commands
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //Toast.makeText(this, "Lol!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float sensitivity=50;
        //String[] menuTitles;
        //menuTitles=getResources().getStringArray(R.array.video_titles);
        if((e1.getX()-e2.getX())>sensitivity && hid==false){
            //Toast.makeText(this, "Trolol!", Toast.LENGTH_SHORT).show();
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.animator.no_slide_in_left,R.animator.slide_out_left,0,0);
            ft.hide(getFragmentManager().findFragmentById(R.id.fragment1));
            ft.commit();
            hid=true;
        }
        //int x=(int)event.getX();
        //int y=(int)event.getY();
        //Toast.makeText(this, "Trolol!", Toast.LENGTH_SHORT).show();
        //return super.onFling;
        return true;
    }
}