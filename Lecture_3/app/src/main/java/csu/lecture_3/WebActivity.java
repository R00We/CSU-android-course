package csu.lecture_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by R00We on 23/03/17.
 */

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        WebFragment webFragment = (WebFragment)getFragmentManager().findFragmentById(R.id.webFragment);
        webFragment.loadUrl(getIntent().getStringExtra(WebFragment.URL));
    }
}
