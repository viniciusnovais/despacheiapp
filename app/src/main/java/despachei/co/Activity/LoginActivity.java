package despachei.co.Activity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;

import static despachei.co.Activity.R.raw.video;


/**
 * Created by SENAI on 29/10/2016.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoview;
    Button btnEntrar, btnInscrever;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

            videoview = (VideoView) findViewById(R.id.videoView);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + video);
            videoview.setVideoURI(uri);
            videoview.start();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        btnEntrar= (Button) findViewById(R.id.btnEntrar);
        btnInscrever =(Button) findViewById(R.id.btnInscrever);


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onClick(View v) {
    }


    public void Entrar(View view) {
        Intent i= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);

    }
}

