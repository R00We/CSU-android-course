package csu.lecture_3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by R00We on 23/03/17.
 */

public class WebFragment extends Fragment {
    private WebView webView;
    public static String URL = "url";
    private static String DEFAULT_URL = "http://iit.csu.ru";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.web_fragment, container, false);
        webView = (WebView) rootView.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            webView.loadUrl(arguments.getString(URL, DEFAULT_URL));
        } else {
            webView.loadUrl(DEFAULT_URL);
        }
        return rootView;
    }

    public void loadUrl(String url) {
        webView.loadUrl(url);
    }
}
