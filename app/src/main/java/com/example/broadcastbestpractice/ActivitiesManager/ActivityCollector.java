package com.example.broadcastbestpractice.ActivitiesManager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static List<Activity> activitiesList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activitiesList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activitiesList.remove(activity);
    }

    public static void finishAllActivities() {
        for (Activity activity : activitiesList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activitiesList.clear();
    }
}
