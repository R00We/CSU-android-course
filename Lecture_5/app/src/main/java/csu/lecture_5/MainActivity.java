package csu.lecture_5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by r00we on 06/04/2017.
 */

public class MainActivity extends AppCompatActivity {
    protected EditText etInput;
    protected TextView tvValue;

    public String TAG = getClass().getCanonicalName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText)findViewById(R.id.input);
        tvValue = (TextView)findViewById(R.id.value);
    }

    public void go(View view) {

    }

    public void cancel(View view) {

    }

    protected Integer getInput(){
        return Integer.valueOf(etInput.getText().toString());
    }

    protected void setValue(Integer value) {
        tvValue.setText(value.toString());
    }

    public static void delayOneSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
