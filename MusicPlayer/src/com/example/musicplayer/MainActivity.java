package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.content.Intent; 
import android.net.Uri; 
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends Activity {

	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mp = MediaPlayer.create(this, R.raw.nin_ghosts);	
		WebView myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.loadUrl("file:///android_asset/index.html");
		//myWebView.getSettings()
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void stopClick(View v) {
		mp.stop();
		Log.e("Banana","stopClick!");
	}
	
	public void playClick(View v) {
		mp.start();
		Log.e("Banana","playClick!");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		mp.stop();
		Log.e("Banana","onPause!");
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	public void goClick(View v) {
		EditText mEdit   = (EditText)findViewById(R.id.editText1);
		if (mEdit.getText().toString() != "") {
			openWebPage( mEdit.getText().toString() );
			openWebPage("\"");
		}
	}
	
	public void actClick(View v) {
		Intent intent = new Intent();
		intent.setClass(this, SecondActivity.class);
		startActivity(intent);
	}	
	
	public void openWebPage( String url) { 
		// Once you have this working, change the string to another web page 
	    Intent i = new Intent(Intent.ACTION_VIEW); 
	    i.setData(Uri.parse(url)); 
	    startActivity(i); 
	} 

}
