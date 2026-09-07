package de.andreas.weltuhr;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WorldClockWidget extends AppWidgetProvider {

    private static final String[] ZONES = {
            "Europe/Berlin",
            "Europe/London",
            "America/Toronto",
            "America/New_York",
            "Asia/Tokyo"
    };

    private static final int[] CLOCK_IDS = {
            R.id.widgetBerlin,
            R.id.widgetLondon,
            R.id.widgetToronto,
            R.id.widgetNewYork,
            R.id.widgetTokyo
    };

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private static void updateWidget(Context context, AppWidgetManager manager, int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.world_clock_widget);

        for (int i = 0; i < CLOCK_IDS.length; i++) {
            views.setString(CLOCK_IDS[i], "setTimeZone", ZONES[i]);
            views.setCharSequence(CLOCK_IDS[i], "setFormat24Hour", "HH:mm");
        }

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        views.setOnClickPendingIntent(R.id.widgetRoot, pendingIntent);

        manager.updateAppWidget(appWidgetId, views);
    }
}
