package com.example.lalit.eventit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {



    private ImageView ivSplash;
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

               ivSplash=(ImageView)findViewById(R.id.ivSplash);

        Animation splash = AnimationUtils.loadAnimation(this,R.anim.splash_animation);

        ivSplash.startAnimation(splash);
   final Intent intent;
//        if(!session.checkLogin())
//        {
//             intent=new Intent(this,MainEventActivity.class);
//        }else
//        {
//             intent=new Intent(this,MainActivity.class);
//        }
        intent=new Intent(this,MainActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(1500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

}
