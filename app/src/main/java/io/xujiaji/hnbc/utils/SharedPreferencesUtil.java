package io.xujiaji.hnbc.utils;

import android.content.Context;
import android.content.SharedPreferences;

import io.xujiaji.hnbc.app.App;
import io.xujiaji.hnbc.config.C;

/**
 * Created by jiana on 16-7-25.
 */
public class SharedPreferencesUtil {
    /**
     * 欢迎页面图片位置
     */
    public static final String WELCOME_PIC = "welcome_pic";
    private SharedPreferencesUtil() {}

    public static void saveWelPicPath(String imgPath) {
        getEdit().putString(WELCOME_PIC, imgPath).commit();
    }

    public static String getWelPicPath() {
        return get().getString(WELCOME_PIC, null);
    }

    public static SharedPreferences get() {
        return App.getAppContext().getSharedPreferences(C.CFile.XML_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEdit() {
        return get().edit();
    }
}
