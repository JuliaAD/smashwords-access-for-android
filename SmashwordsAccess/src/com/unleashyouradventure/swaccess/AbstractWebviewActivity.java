package com.unleashyouradventure.swaccess;

import android.os.Bundle;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockActivity;
import com.unleashyouradventure.swaccess.util.StringUtils;
import com.unleashyouradventure.swapi.util.StringTrimmer;

public abstract class AbstractWebviewActivity extends SherlockActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        setContentView(webview);
        String name = getName();
        String html = StringUtils.readAssetFileToString(this, "html/" + name + ".html");
        html = modifyHtml(html);
        webview.loadDataWithBaseURL("file:///android_asset/html/", html, "text/html", "UTF-8", null);
    }

    protected String modifyHtml(String html) {
        // default: do nothing
        return html;
    }

    protected String getName() {
        String name = new StringTrimmer(this.getClass().getSimpleName()).getBeforeNext("Activity").toString();
        name = name.toLowerCase();
        return name;
    }
}
