package com.phunware.analytics.sample;

import android.app.Application;

import com.phunware.analytics.PwAnalyticsModule;
import com.phunware.core.PwCoreSession;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		String appId = ;
		String accessKey = ; 
		String signatureKey = ;
		String encryptionKey = "";
		
		PwCoreSession.getInstance().installModules(PwAnalyticsModule.getInstance());
		
		PwCoreSession.getInstance().registerKeys(this, appId, accessKey, signatureKey, encryptionKey);
	}
}
