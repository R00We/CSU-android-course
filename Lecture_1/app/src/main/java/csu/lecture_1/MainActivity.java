package csu.lecture_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etUser;
    EditText etPassword;

    View btSign;
    Button btRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btSign = findViewById(R.id.btSign);
        btRegistration = (Button)findViewById(R.id.btRegistration);

        btSign.setOnClickListener(buttonClickListener);
    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SecondActivity.startSecondActivity(MainActivity.this, etUser.getText().toString());
        }
    };

}
