package csu.lecture_5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by R00We on 06/04/17.
 */

public class IntentS extends IntentService {
    public static final String ACTION = "csu.lecture_5.result";
    public static final String VALUE = "value";

    public IntentS() {
        super("IntentS");
        Log.d("IntentService", "Constructor");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            int value = intent.getIntExtra(VALUE, 0);
            for (int i = value; i > 0; i--) {
                MainActivity.delayOneSecond();
                Log.d("IntentService", "onNext - "+i);
                Intent result = new Intent(ACTION);
                result.addCategory(Intent.CATEGORY_DEFAULT);
                result.putExtra(VALUE, i);
                sendBroadcast(result);
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("IntentService", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("IntentService", "onDestroy");
    }
}
