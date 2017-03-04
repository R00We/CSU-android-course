package csu.lecture_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by R00We on 02/03/17.
 *
 */

public class SecondActivity extends AppCompatActivity {

    private static final String USER_EXTRA = "user";

    TextView tvMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        tvMessage = (TextView)findViewById(R.id.tvMessage);
        String name = getIntent().getStringExtra(USER_EXTRA);
        // Подробнее тут http://developer.alexanderklimov.ru/android/theory/resources.php
        tvMessage.setText(String.format(getString(R.string.hello), name));
    }


    // Хорошим тоном считается вынечения логики запуска Activity в статичный метод самой Activity
    public static void startSecondActivity(@NonNull Context context, @NonNull String name){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(USER_EXTRA, name);
        context.startActivity(intent);
    }
}
