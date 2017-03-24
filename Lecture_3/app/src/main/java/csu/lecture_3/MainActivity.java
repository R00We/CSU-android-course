package csu.lecture_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LinkFragment.OnUrlSelectedInterface {
    private static final String TAG = "MainActivity";
    private WebFragment webFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webFragment = (WebFragment)getFragmentManager().findFragmentById(R.id.webFragment);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onUrlSelected(String url) {
        Log.d(TAG, "onUrlSelected - "+url);
        if (webFragment != null) {
            webFragment.loadUrl(url);
        } else {
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtra(WebFragment.URL, url);
            startActivity(intent);
        }

    }
}
