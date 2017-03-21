package csu.lecture_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by R00We on 16/03/17.
 *
 */

public class CustomArrayAdapter extends ArrayAdapter<String> {

    public CustomArrayAdapter(@NonNull Context context, String[] elements) {
        super(context, R.layout.row, elements);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(getItem(position));

        return convertView;
    }
}
