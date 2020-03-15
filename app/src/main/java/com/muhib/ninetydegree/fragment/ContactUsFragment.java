package com.muhib.ninetydegree.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

    WebView webView;
    TextView title;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Contact Us");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_arrow));

        }
        title = view.findViewById(R.id.title);
        webView = view.findViewById(R.id.webview);
        webView.setBackgroundColor(Color.TRANSPARENT);

        title.setText(getResources().getString(R.string.contact_us));
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
  //      webView.loadUrl("file:///android_asset/aboutUs.html");
   // webView.loadData("file:///android_asset/aboutUs.html", "text/html", "UTF-8");

        String st = getString(R.string.contact_us_text);
        String content = String.valueOf(Html
                .fromHtml("<![CDATA[<body style=\"text-align:justify; \">"
                        + st
                        + "</body>]]>"));
        webView.loadDataWithBaseURL(null, "<style>figure{height: auto;width: 100% !important; padding:0px !important;margin:0px !important;} img{height: auto;width: 100% !important;} iframe{display: inline;height: auto;max-width: 100%;}</style>" + content, "text/html", "UTF-8", null);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }


//    Contact us-
//    For any kind of information, suggestion and help-
//    contact us at contact@shompurok.com
//    or find us on-
//    Official Website:
//    http://www.90degreeeducation.com/
//            &
//    http://shompurok.com/
//    facebook:
//    https://www.facebook.com/90.degree.education/
//    Twitter:
//    https://twitter.com/90_education
//    Instagram:
//    https://www.instagram.com/90.degree.education/
}
