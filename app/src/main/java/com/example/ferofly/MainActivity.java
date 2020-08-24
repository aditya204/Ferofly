package com.example.ferofly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout  linearLayout;
   private TextView textView1,textView2,textView3,textView4,textView5;
    private ProgressBar mProgressBar,mProgressBar2,mProgressBa3,mProgressBar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        toolbar=findViewById( R.id.toolbar_address );
        mProgressBar=findViewById( R.id.progressBar1);

        linearLayout=findViewById( R.id.linearLayout );
        mProgressBar4=findViewById( R.id.progressBar2);
        mProgressBar2=findViewById( R.id.progressBar);
        mProgressBa3=findViewById( R.id.progressBar3);





        linearLayout.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=2nd Floor, Hno 12, Road no 37, Back side of MGS Hospital ,West Punjabi Bhag ,Punjabi Bhag, Delhi, 110026, India");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        } );


        textView1=findViewById( R.id.tv1 );
        textView2=findViewById( R.id.tv2 );

        textView3=findViewById( R.id.tv3 );

        textView4=findViewById( R.id.tv4 );
        textView5=findViewById( R.id.tv5 );



        toolbar.setTitle( "Order details" );
        setSupportActionBar( toolbar );
        getSupportActionBar( ).setDisplayShowHomeEnabled( true );
        getSupportActionBar( ).setDisplayHomeAsUpEnabled( true );




        SetProgress( mProgressBar);
        new Handler(  ).postDelayed( new Runnable( ) {
            @Override
            public void run(){
                SetProgress( mProgressBar2);

                textView2.setTextColor( Color.parseColor( "#000000" ) );
            }
        },5000 );
        new Handler(  ).postDelayed( new Runnable( ) {
            @Override
            public void run(){
                SetProgress( mProgressBa3);
                textView3.setTextColor( Color.parseColor( "#000000" ) );

            }
        },10000 );
        new Handler(  ).postDelayed( new Runnable( ) {
            @Override
            public void run(){
                SetProgress( mProgressBar4);
                textView4.setTextColor( Color.parseColor( "#000000" ) );

            }
        },15000 );
        new Handler(  ).postDelayed( new Runnable( ) {
            @Override
            public void run(){
                textView5.setTextColor( Color.parseColor( "#000000" ) );

            }
        },20000 );





    }

    public void SetProgress(final ProgressBar progressBar){

        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
        animation.setDuration(5000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) { }

            @Override
            public void onAnimationEnd(Animator animator) {
                //do something when the countdown is complete
            }

            @Override
            public void onAnimationCancel(Animator animator) { }

            @Override
            public void onAnimationRepeat(Animator animator) { }
        });
        animation.start();

    }
}
