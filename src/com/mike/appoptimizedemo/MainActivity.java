package com.mike.appoptimizedemo;

import android.os.Bundle;
import android.os.Debug;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	/*
	 * author: @MikeWang
	 * 
	 * there
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//1,strict mode startStrictMode()
		startStrictMode();
		
		super.onCreate(savedInstanceState);
		
		//2 traceview  createTraceProblems()
		Debug.startMethodTracing("calc");
		setContentView(R.layout.activity_main);
		createTraceProblems();
		// stop tracing
		Debug.stopMethodTracing();
	}
	

	//create strict mode init code, if there is someting not ok, the logcat will output the key infos
	private void startStrictMode() {
		if (true) {
	         StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
	                 .detectDiskReads()
	                 .detectDiskWrites()
	                 .detectNetwork()   // or .detectAll() for all detectable problems
	                 .penaltyLog()
	                 .build());
	         StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
	                 .detectLeakedSqlLiteObjects()
	                 .detectLeakedClosableObjects()
	                 .penaltyLog()
	                 .penaltyDeath()
	                 .build());
	     }
	}
	
	/*
	 * create time-consuming event, make the trace chart is apprent
	 */
	private void createTraceProblems() {
		int temp = 0;
		for (int i = 0; i < Integer.MAX_VALUE - 10000; i++ ) {
			temp ++ ;
		}
		Log.d("tt", "init finished");
	}

}
