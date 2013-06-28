package com.phunware.analytics.sample;

import org.apache.http.message.BasicNameValuePair;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.phunware.analytics.PwAnalyticsModule;
import com.phunware.core.PwCoreSession;

public class AnalyticsSample extends ListActivity {
	private static final String TAG = "AnalyticsSample";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.planets));
		setListAdapter(adapter);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		PwCoreSession.getInstance().activityStartSession(this);
		//start timing how long the user is on this activity. Do this here so that
		//the time doesn't account for the time the screen is off.
		PwAnalyticsModule.startTimedEvent(this,TAG);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String text = ((TextView)v.findViewById(android.R.id.text1)).getText().toString();
		Intent i = new Intent(this, DetailsActivity.class);
		i.putExtra(DetailsActivity.ARG_TITLE, text);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.analytics_sample, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.action_settings)
		{
			//Send an event that the user clicked on the menu item for settings.
			BasicNameValuePair[] params = new BasicNameValuePair[1];
			params[0] = new BasicNameValuePair("Menu Item", "Settings");
			PwAnalyticsModule.addEventWithParameters(this, "Clicked Menu", params);
			Toast.makeText(this, "No implementation, however I've seen you want to see settings :)", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		PwCoreSession.getInstance().activityStopSession(this);
		//Stop timing the event for how long the user is on this activity.
		//Send the parameter for the current orientation.
		PwAnalyticsModule.endTimedEventWithParameters(this, TAG,
				new BasicNameValuePair[]{Utils.getOrientationParam(getResources())});
	}
}
