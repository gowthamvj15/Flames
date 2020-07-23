package com.example.flames;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class result extends AppCompatActivity {

    private ImageView imageView;
    private Button btn;
    private String s;
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imageView = (ImageView) findViewById(R.id.result);
        btn = (Button) findViewById(R.id.retry);
        s = getIntent().getStringExtra("answer");
        find_yourLuck();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                player.stop();
                finish();
            }
        });
    }

    private void find_yourLuck()
    {
        if(s.equals("single"))
        {
            imageView.setImageResource(R.drawable.single);
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.thug_life);
             player.start();
            }
        }
        else if(s.equals("f"))
        {
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.result);
                player.start();
            }
            imageView.setImageResource(R.drawable.friends);
        }
        else if(s.equals("l"))
        {
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.result);
                player.start();
            }
            imageView.setImageResource(R.drawable.love);
        }
        else if(s.equals("a"))
        {
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.result);
                player.start();
            }
            imageView.setImageResource(R.drawable.affection);
        }
        else if(s.equals("m"))
        {
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.result);
                player.start();
            }
            imageView.setImageResource(R.drawable.marry);
        }
        else if(s.equals("e"))
        {
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.result);
                player.start();
            }
            imageView.setImageResource(R.drawable.enemy);
        }
        else if(s.equals("s"))
        {
            if(player == null)
            {player = MediaPlayer.create(this,R.raw.result);
                player.start();
            }
            imageView.setImageResource(R.drawable.siblings);
        }
    }
}