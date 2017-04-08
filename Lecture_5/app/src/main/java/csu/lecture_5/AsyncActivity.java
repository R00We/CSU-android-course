package csu.lecture_5;

import android.os.AsyncTask;
import android.view.View;

/**
 * Created by R00We on 06/04/17.
 */

public class AsyncActivity extends MainActivity {
    Async async;

    @Override
    public void go(View view) {
        async = new Async(){
            @Override
            protected void onProgressUpdate(Integer... values) {
                setValue(values[0]);
            }
        };
//        async.execute(getInput());
        async.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, getInput());

    }

    @Override
    public void cancel(View view) {
        if (async != null) {
            async.cancel(true);
        }

    }
}
