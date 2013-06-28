package com.phunware.analytics.sample;

import android.app.Application;

import com.phunware.analytics.PwAnalyticsModule;
import com.phunware.core.PwCoreSession;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
//		PROD -- Prod Test (Android)
		String appId = "15";
		String accessKey = "d04397f4c0b491f7c6d0f6bcf5c339ab58927cc0"; 
		String signatureKey = "23fc11a456de9a0d9202ca381463baab23283c4c";
		
//		PROD -- ProdTest 06/17/13
//		String appId = "39";
//		String accessKey = "77dd297ccfdee5f944953552776a4d0ac9cf192d"; 
//		String signatureKey = "ba718b3b7295c240711c70c6a42dfddbcc2e1c97";
		
//		STAGE -- QA Test App
//		String appId = "8";
//		String accessKey = "71014513f265c91a2d4ad0b083e09b0db561741d"; 
//		String signatureKey = "ffa238529d95875bee142addbc34a0f28b059ee2";
		
//		DEV -- Test App
//		String appId = "8";
//		String accessKey = "fa0757223f9eb4b66a0f1959a5d0801869c7465e"; 
//		String signatureKey = "784c57caa5b0abd2255444389a49be00ac8316e7";
		
		String encryptionKey = "zxcvbnmasdfghjklqwertyuiop123456";
		
		PwCoreSession.getInstance().installModules(PwAnalyticsModule.getInstance());
		
		PwCoreSession.getInstance().registerKeys(this, appId, accessKey, signatureKey, encryptionKey);
	}
}
