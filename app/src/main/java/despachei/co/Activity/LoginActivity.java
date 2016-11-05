package despachei.co.Activity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.VideoView;



/**
 * Created by SENAI on 29/10/2016.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private VideoView videoview;
    private Button btnEntrar, btnInscrever;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

    }



    @Override
    protected void onStart() {
        super.onStart();

        videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.teste);
        videoview.setVideoURI(uri);
        videoview.start();

        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        btnEntrar= (Button) findViewById(R.id.btnEntrar);
        btnInscrever= (Button) findViewById(R.id.btnInscrever);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, EntrarActivity.class);
                startActivity(i);
                finish();
            }
        });
    }



    @Override
    public void onClick(View v) {

    }


    public void Entrar(View view) {
        Intent i= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);

    }




}

