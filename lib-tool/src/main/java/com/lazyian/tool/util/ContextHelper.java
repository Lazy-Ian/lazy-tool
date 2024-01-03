package com.lazyian.tool.util;

import android.app.Application;

public class ContextHelper {
    private static Application application;

    public static Application getApplication() {

        if (application == null) {
            try {
                application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null, (Object[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return application;
    }

    public static void setApplication(Application app) {
        application = app;
    }

}
