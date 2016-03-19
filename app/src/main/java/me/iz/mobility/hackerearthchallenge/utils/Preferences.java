/*
 * Copyright 2016 Basit Parkar.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 *  @date 3/19/16 5:13 AM
 *  @modified 3/17/16 5:18 PM
 */

package me.iz.mobility.hackerearthchallenge.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static SharedPreferences mPreferences;

    public static void init(Context context) {
        mPreferences = context.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCES.name(), Context.MODE_PRIVATE);
    }

    public static boolean getBoolean(String key) {
        return mPreferences.getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    public static void saveBoolean(String key, boolean bool) {
        mPreferences.edit().putBoolean(key, bool).apply();
    }

    public static void saveString(String key, String s) {
        mPreferences.edit().putString(key, s).apply();
    }

    public static void saveInteger(String key, Integer integer) {
        mPreferences.edit().putInt(key, integer).apply();
    }

    public static void saveFloat(String key, Float value) {
        mPreferences.edit().putFloat(key,value).apply();
    }

    public static float getFloat(String key) {
        return mPreferences.getFloat(key,0.0f);
    }

    public static void saveLong(String key, Long value) {
        mPreferences.edit().putLong(key,value).apply();
    }

    public static long getLong(String key) {
        return mPreferences.getLong(key,0l);
    }

    public static void clear() {
        mPreferences.edit().clear().apply();
    }

    public static void remove(String key) {
        mPreferences.edit().remove(key).apply();
    }

    public static String getString(String key) {
        return mPreferences.getString(key, "");
    }
    public static String getString(String key, String defVal) {
        return mPreferences.getString(key, defVal);
    }

    public static int getInteger(String key) {
        return mPreferences.getInt(key, 0);
    }

}