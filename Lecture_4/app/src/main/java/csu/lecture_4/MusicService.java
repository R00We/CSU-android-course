package csu.lecture_4;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by R00We on 30/03/17.
 *
 */

public class MusicService extends Service {

    private static final String TAG = MusicService.class.getCanonicalName();
    public static final String URL = "url";

    public static final String PLAY_STREAM = "play_stream";
    public static final String STOP_STREAM = "stop_stream";
    private MediaPlayer player;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Log.d(TAG, "onStartCommand - " + startId + " intent - " + intent.getStringExtra(URL));
            String action =intent.getAction();
            if (action != null) {
                switch (action) {
                    case PLAY_STREAM:
                        String url = intent.getStringExtra(URL);
                        start(url);
                        break;

                    case STOP_STREAM:
                        stop();
                        break;
                }
            }
        } else {
            stopSelf();
        }
        return Service.START_STICKY_COMPATIBILITY;
    }


    private void start(String url) {
        if (player == null) {
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
        try {
            player.setDataSource(url);
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stop(){
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stop();
        Log.d(TAG, "onDestroy");
    }
}
