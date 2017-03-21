package csu.lecture_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] foods = { "Молоко", "Сметана Колбаска Колбаска Колбаска Колбаска Колбаска Яйцо Яйцо Яйцо Яйцо Яйцо Яйцо Яйцо Яйцо", "Колбаска", "Сыр", "Мышка",
            "Ананас", "Икра черная", "Икра кабачковая", "Яйцо", "Ананас", "Икра черная", "Икра кабачковая", "Яйцо", "Ананас", "Икра черная", "Икра кабачковая", "Яйцо" };

    private AbsListView absListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        absListView = (AbsListView) findViewById(R.id.absListView);

        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this, foods);
        absListView.setAdapter(customArrayAdapter);

        absListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, foods[position], Toast.LENGTH_LONG).show();
            }
        });

    }
}
