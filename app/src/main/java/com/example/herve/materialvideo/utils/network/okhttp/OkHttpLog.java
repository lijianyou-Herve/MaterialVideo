package com.example.herve.materialvideo.utils.network.okhttp;

import android.util.Log;

/**
 * log接口类
 */
public final class OkHttpLog {

	public static final boolean DEBUG = true;

	public static void d(String tag, String str) {
		if (DEBUG) {
			try {
				Log.d(tag, str);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public static void e(String tag, String str) {
		if (DEBUG) {
			try {
				Log.e(tag, str);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public static void i(String tag, String str) {
		if (DEBUG) {
			try {
				Log.i(tag, str);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public static void v(String tag, String str) {
		if (DEBUG) {
			try {
				Log.v(tag, str);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
