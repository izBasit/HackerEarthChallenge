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
 *  @modified 3/19/16 5:12 AM
 */

package me.iz.mobility.hackerearthchallenge;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.iz.mobility.hackerearthchallenge.models.Event;
import me.iz.mobility.hackerearthchallenge.models.EventsModel;
import me.iz.mobility.hackerearthchallenge.rest.RestConnection;
import me.iz.mobility.hackerearthchallenge.utils.DateUtil;
import me.iz.mobility.hackerearthchallenge.utils.Utils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link HealthifyMeWidgetConfigureActivity HealthifyMeWidgetConfigureActivity}
 */
public class HealthifyMeWidget extends AppWidgetProvider {


    private static final String ACTION_PREV_EVENT = "me.iz.mobility.hackerearthchallenge.PREV_EVENT";
    private static final String ACTION_NEXT_EVENT = "me.iz.mobility.hackerearthchallenge.NEXT_EVENT";
    private static final String ACTION_OPEN_EVENT = "me.iz.mobility.hackerearthchallenge.OPEN_EVENT";
    private static final String EVENT_URL = "me.iz.mobility.hackerearthchallenge.EVENT_URL";

    private List<Event> events = new ArrayList<>();

    private Context context;

    private int currentCount = 0;

    private CompositeSubscription subscriptions = new CompositeSubscription();

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        Timber.d("On Receive called");

        this.context = context;

        String action = intent.getAction();

        Timber.d("Action received %s",action);

        if(action.equals(ACTION_OPEN_EVENT)) {
            String url = intent.getStringExtra(EVENT_URL);
            openUrl(url);
            return;
        }

        Timber.d("Current count %s and events %s", currentCount,events.size());
        if(action.equals(ACTION_NEXT_EVENT)) {

            if(currentCount >= events.size())
                return;

            currentCount++;

            Timber.d("After increment Current count %sand events %s", currentCount,events.size());
            redrawWidgets(context);
        }

        if(action.equals(ACTION_PREV_EVENT)) {

            if(currentCount <= 0) {
                return;
            }

            currentCount--;

            Timber.d("After decrement Current count %sand events %s", currentCount,events.size());
            redrawWidgets(context);

        }

    }

//    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
//                                int appWidgetId) {
//
//        Timber.d("Update App widget called");
//
//        CharSequence widgetText = HealthifyMeWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
//        // Construct the RemoteViews object
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.healthify_me_widget);
////        views.setTextViewText(R.id.appwidget_text, widgetText);
//
//        // Instruct the widget manager to update the widget
//        appWidgetManager.updateAppWidget(appWidgetId, views);
//    }


    private void redrawWidgets(Context context) {
        Timber.d("redrawWidgets called");
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(
                new ComponentName(context, HealthifyMeWidget.class));
        for (int appWidgetId : appWidgetIds) {
            drawWidget(context, appWidgetId);
        }
    }

    private void drawWidget(Context context, int appWidgetId) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

        Timber.d("drawWidget called");

        if (events.size() <= 0) {
            Timber.d("Nothing to show");
            return;
        }

        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.healthify_me_widget);

        rv.setTextViewText(R.id.tvHeader, events.get(currentCount).getTitle());
        rv.setTextViewText(R.id.tvDescription, events.get(currentCount).getDescription());

        Picasso.with(context)
                .load(events.get(currentCount).getThumbnail())
                .into(rv, R.id.ivThumbnail, new int[]{appWidgetId});

        rv.setTextViewText(R.id.tvHeader, events.get(currentCount).getTitle());

        rv.setTextViewText(R.id.tvChallengeType, events.get(currentCount).getChallengeType());

        String totalLiveEvents = "<html><body><font size=2 color=red>" + events.size() + "</font> live events </body><html>";

        rv.setTextViewText(R.id.tvTotalChallenges, Utils.getHtmlStyledString(totalLiveEvents));
        String startDate = DateUtil.getDateInGivenFormat(events.get(currentCount).getDate(),
                DateUtil.SERVER_DATE_FORMAT, DateUtil.DEVICE_DATE_FORMAT);
        rv.setTextViewText(R.id.tvStartDate, startDate);

        rv.setTextViewText(R.id.tvEventTime, events.get(currentCount).getTime() + " - " +
                events.get(currentCount).getEndTime());

        rv.setTextViewText(R.id.tvEndDate, events.get(currentCount).getEndDate());

        rv.setTextViewText(R.id.tvCheckEvent, Utils.getHtmlStyledString("<u>Check event</u>"));


        rv.setOnClickPendingIntent(R.id.tvCheckEvent,
                PendingIntent.getBroadcast(context, 0,
                        new Intent(context, HealthifyMeWidget.class)
                                .setAction(ACTION_OPEN_EVENT).putExtra(EVENT_URL,events.get(currentCount).getUrl()),
                        PendingIntent.FLAG_UPDATE_CURRENT));

        rv.setOnClickPendingIntent(R.id.ivLeft,
                PendingIntent.getBroadcast(context, 0,
                        new Intent(context, HealthifyMeWidget.class)
                                .setAction(ACTION_PREV_EVENT),
                        PendingIntent.FLAG_UPDATE_CURRENT));


        rv.setOnClickPendingIntent(R.id.ivRight,
                PendingIntent.getBroadcast(context, 0,
                        new Intent(context, HealthifyMeWidget.class)
                                .setAction(ACTION_NEXT_EVENT),
                        PendingIntent.FLAG_UPDATE_CURRENT));

        appWidgetManager.updateAppWidget(appWidgetId, rv);


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        Timber.d("onUpdate called");
        for (int appWidgetId : appWidgetIds) {
            drawWidget(context, appWidgetId);
        }
    }


    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Timber.d("onDeleted called");
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            HealthifyMeWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

        Timber.d("onEnabled called");
        consumeEvents();
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled

        Timber.d("onDisabled called");
    }


    private void consumeEvents() {
        subscriptions.add(getEvents()
                .retry() // If call to server fails
                .concatMap(eventsModel -> Observable.from(eventsModel.getResponse())) // sending one observable at a time
                .filter(event -> (!event.getCollege()) && event.getStatus().equals("ONGOING")) // filter as per requirement
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Event>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("Completed...");
                        redrawWidgets(context);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e.getMessage());

                    }

                    @Override
                    public void onNext(Event event) {
                        Timber.d("Response %s", event);
                        events.add(event);
                    }
                }));
    }

    private Observable<EventsModel> getEvents() {
        return RestConnection.createHEService().getEvents();
    }


    private void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }
}

