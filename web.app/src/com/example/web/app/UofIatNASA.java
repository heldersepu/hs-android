package com.example.web.app;

import android.os.Bundle;
import android.webkit.WebView;
import android.app.Activity;
import android.view.Menu;

public class UofIatNASA extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uof_iat_nas);

		WebView myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.loadUrl("file:///android_asset/uofi-at-nasa.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uof_iat_na, menu);
		return true;
	}

}
