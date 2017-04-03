package csu.lecture_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static csu.lecture_4.R.id.url;

public class MainActivity extends AppCompatActivity {

    private Button startService;
    private Button stopService;
    private Button playStream;
    private Button stopStream;
    private EditText erlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = (Button) findViewById(R.id.start);
        stopService = (Button) findViewById(R.id.stop);
        playStream = (Button) findViewById(R.id.goButton);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                startService(intent);
            }
        });

        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                MainActivity.this.stopService(intent);
            }
        });

        playStream = (Button) findViewById(R.id.goButton);
        stopStream = (Button) findViewById(R.id.stopButton);
        erlEditText = (EditText)findViewById(url);

        playStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = erlEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                intent.setAction(MusicService.PLAY_STREAM);
                intent.putExtra(MusicService.URL, url);
                startService(intent);
            }
        });

        stopStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                intent.setAction(MusicService.STOP_STREAM);
                startService(intent);
            }
        });


    }
}
