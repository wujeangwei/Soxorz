package com.android.soxorz;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
public class WebViewActivity extends ActionBarActivity {
	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webView = (WebView) findViewById(R.id.webView1);
		webView.loadUrl("http://third-contact.com/soxorz/user/login.php");
		
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				//Toast.makeText(WebViewActivity.this, "页面加载完成", Toast.LENGTH_SHORT).show();
			}
		});

		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_about) {
			//return true;
            Uri  uri = Uri.parse("http://third-contact.com/soxorz/");
            Intent  intent = new  Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
