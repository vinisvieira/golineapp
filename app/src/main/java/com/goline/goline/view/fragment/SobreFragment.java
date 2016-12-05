package com.goline.goline.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.goline.goline.R;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class SobreFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_sobre, container, false);
        return this.mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String url = "http://10.0.3.2:8080/GoLine_1.0/quemsomosapp.html";
        WebView view1 = (WebView) mView.findViewById(R.id.webView);
        view1.getSettings().setJavaScriptEnabled(true);
        view1.loadUrl(url);
    }

}
