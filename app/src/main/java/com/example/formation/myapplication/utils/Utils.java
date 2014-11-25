package com.example.formation.myapplication.utils;

import android.os.Looper;

public class Utils {

	public static boolean isMainThread() {
		return Looper.myLooper() == Looper.getMainLooper();
	}
}
