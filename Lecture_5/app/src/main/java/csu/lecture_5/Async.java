package csu.lecture_5;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by R00We on 06/04/17.
 */

public class Async extends AsyncTask<Integer, Integer, Integer> {

    @Override
    protected Integer doInBackground(Integer... params) {
        int i;
        for (i = params[0]; i > 0; i--) {
            Log.d("Async", "name - "+this.toString()+" i = "+i);
            publishProgress(i);
            MainActivity.delayOneSecond();
            if (isCancelled()) {
                return 0;
            }
        }
        return i;
    }



    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d("Async", "onCancelled");
    }
}
