package com.example.herve.materialvideo.utils.sp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Herve on 2016/7/30.
 */
public class SharedPreferencesUtil {

    /**
     * 文件名
     */
    private static final String sh_data_name = "herve_data";
    private volatile static SharedPreferencesUtil uniqueInstance;
    private static SharedPreferences saveInfo;
    private static SharedPreferences.Editor saveEditor;

    private static final String themeStyle = "themeStyle";

    private int themeStyles;

    private SharedPreferencesUtil() {

    }

    public static SharedPreferencesUtil getInstance(Context context) {
        if (uniqueInstance == null) {
            synchronized (SharedPreferencesUtil.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SharedPreferencesUtil();
                    saveInfo = context.getSharedPreferences(sh_data_name, Context.MODE_PRIVATE);
                    saveEditor = saveInfo.edit();
                }
            }
        }
        return uniqueInstance;
    }

    public int getthemeStyles() {
        return saveInfo.getInt(themeStyle, 0);
    }

    public boolean putthemeStyles(int themeStyles) {
        saveEditor.putInt(themeStyle, themeStyles);
        return saveEditor.commit();
    }
}
