package com.example.example;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/**
 * @author {Mohammad Abbas Khan}
 * @since 06-Apr-2015
 * @version 1.0
 * 
 */
public class MainActivity extends Activity {

	private GoogleApiClient mClient;
	private String title = "test";
	private String webUrl = "test";
	private String appUrl = "android-app://com.example.example/http/storage.googleapis.com/ma-ccimages/ChefChili/sai%20ua.jpg";
	private final String APP_NAME = "recipe";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mClient = new GoogleApiClient.Builder(MainActivity.this).addApi(
				AppIndex.APP_INDEX_API).build();
	}

	@Override
	protected void onStart() {
		super.onStart();
		/** connect your google play services app index api client */
		mClient.connect();

		/** Define a Title for your current page, show in autocompletion UI */
		title = APP_NAME;

		/** Call the app indexing API view method */
		PendingResult<Status> result = AppIndex.AppIndexApi.view(mClient, this,
				Uri.parse(appUrl), title, Uri.parse(webUrl), null);
	}

	@Override
	protected void onStop() {

		super.onStop();
		final Uri APP_URI = Uri.parse(appUrl).buildUpon().appendPath(webUrl)
				.build();

		PendingResult<Status> result = AppIndex.AppIndexApi.viewEnd(mClient,
				this, APP_URI);

		mClient.disconnect();
	}
}
