package com.goldpalm.emergencyinquiry.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gp-0168 on 2018/3/27.
 */

public class ActivityUtil {

    static WeakReference<Activity> sTopActivityWeakRef;
    static List<Activity> sOpenActivitesList = new LinkedList<>();

    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!sOpenActivitesList.contains(activity)) {
                sOpenActivitesList.add(activity);
            }
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

            if (sOpenActivitesList.contains(activity)) {
                sOpenActivitesList.remove(activity);
            }


        }
    };

    private ActivityUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(@NonNull final Application app) {
        app.registerActivityLifecycleCallbacks(mCallbacks);
    }


    private static void setTopActivityWeakRef(Activity activity) {
        if (sTopActivityWeakRef == null || !activity.equals(sTopActivityWeakRef.get())) {
            sTopActivityWeakRef = new WeakReference<>(activity);
        }
    }

    public static WeakReference<Activity> getTopActivityWeakRef() {
        return sTopActivityWeakRef;
    }

    // 关闭每一个list内的activity
    public static void exit() {
        try {
            for (Activity activity : sOpenActivitesList) {
                if (null != activity && !activity.isFinishing())
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    /**
     * finish 所有activity 除了exclude
     *
     * @param exclude
     */
    public static void finishAllExcludeActivities(Class exclude) {
        try {
            for (Activity activity : sOpenActivitesList) {
                if (null != activity && !activity.isFinishing() && !activity.getClass().getSimpleName().equals(exclude.getSimpleName())) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
