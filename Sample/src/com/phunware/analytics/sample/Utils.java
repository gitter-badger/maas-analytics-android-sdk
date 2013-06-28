package com.phunware.analytics.sample;

import org.apache.http.message.BasicNameValuePair;

import android.content.res.Resources;

public class Utils {
	
	/**
	 * Get a {@link BasicNameValuePair} object with a parameter for Orientation
	 * @param r app resources object
	 * @return
	 */
	public static BasicNameValuePair getOrientationParam(Resources r)
	{
		String orientation = "portrait";
		if(r.getConfiguration().orientation == r.getConfiguration().ORIENTATION_LANDSCAPE)
			orientation = "landscape";
		return new BasicNameValuePair("Orientation", orientation);
	}

}
