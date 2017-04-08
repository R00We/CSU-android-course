package csu.lecture_5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by R00We on 06/04/17.
 */

public class IntentActivity extends MainActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter(IntentS.ACTION);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    public void go(View view) {

        Intent intent = new Intent(this, IntentS.class);
        intent.putExtra(IntentS.VALUE, getInput());
        startService(intent);
    }

    @Override
    public void cancel(View view) {
        Intent intent = new Intent(this, IntentS.class);
        stopService(intent);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int result = intent
                    .getIntExtra(IntentS.VALUE, 0);
            setValue(result);
        }
    }
}
