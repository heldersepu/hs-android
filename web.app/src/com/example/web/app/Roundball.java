package com.example.web.app;

import android.os.Bundle;
import android.webkit.WebView;
import android.app.Activity;
import android.view.Menu;

public class Roundball extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_roundball);

		WebView myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setAllowFileAccess(true);
		myWebView.getSettings().setLoadsImagesAutomatically(true);
		
		myWebView.loadUrl("file:///android_asset/roundball/roundball.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.roundball, menu);
		return true;
	}

}
