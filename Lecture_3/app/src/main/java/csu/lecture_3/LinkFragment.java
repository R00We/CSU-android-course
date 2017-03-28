package csu.lecture_3;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by R00We on 23/03/17.
 */

public class LinkFragment extends Fragment {

    private static final String URL_KEY = "url";

    private EditText urlEditText;
    private Button goButton;
    private ListView urlHistorylistView;

    private SharedPreferences sharedPreferences;
    private ArrayAdapter<String> urlHistoryAdapter;

    private OnUrlSelectedInterface onUrlSelectedInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onUrlSelectedInterface = (OnUrlSelectedInterface)getActivity();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.link_fragment, container, false);
        urlEditText = (EditText)rootView.findViewById(R.id.urlEditText);
        goButton = (Button) rootView.findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString();
                openUrl(url);
                saveUrl(url);
            }
        });
        urlHistorylistView = (ListView) rootView.findViewById(R.id.urlHistoryListView);
        urlHistorylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openUrl(urlHistoryAdapter.getItem(position));
            }
        });

        Set<String> set = sharedPreferences.getStringSet(URL_KEY, new HashSet<String>());
        urlHistoryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new ArrayList<>(set));
        urlHistorylistView.setAdapter(urlHistoryAdapter);

        return rootView;
    }

    private void openUrl(String url) {
        onUrlSelectedInterface.onUrlSelected(url);
    }

    private void saveUrl(String url) {
        urlHistoryAdapter.add(url);
        Set<String> set = sharedPreferences.getStringSet(URL_KEY, new HashSet<String>());
        set.add(url);
        sharedPreferences.edit().putStringSet(URL_KEY, set).apply();
    }

    public interface OnUrlSelectedInterface {
        void onUrlSelected(String url);
    }

}
