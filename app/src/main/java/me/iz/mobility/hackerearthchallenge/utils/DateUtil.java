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
 *  @modified 3/19/16 3:36 AM
 */

package me.iz.mobility.hackerearthchallenge.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static final String TAG = "DateUtil";

    public static final String SERVER_DATE_FORMAT = "EEEE, dd MMM yyyy";
    public static final String DEVICE_DATE_FORMAT = "dd MMM yyyy";
    public static final String DEVICE_TIME_FORMAT = "HH:mm a";

    private static final int SECOND = 1000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    /**
     * @return date time in format yyyy-MM-dd HH:MM:SS.SSS
     */
    public static String getDateTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(DEVICE_DATE_FORMAT, Locale.getDefault());
        return formatter.format(c.getTime());
    }

    public static Date getCurrentDateinDateFormat() {

        Calendar c = Calendar.getInstance();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());

        return new Date(c.getTimeInMillis());
    }


    public static String getPreviousWeekDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -7);
        SimpleDateFormat formatter = new SimpleDateFormat(DEVICE_DATE_FORMAT, Locale.getDefault());
        return formatter.format(c.getTime());
    }

    /**
     * @return current time in format HH:mm:SS
     */
    public static String getCurrentTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return formatter.format(c.getTime());
    }

    public static String getDateForLog() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * get Date Time in ddMMyyyyHHmmSS format
     *
     * @return
     */
    public static String getDateddMMyyyyHHmmSS() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmSS", Locale.getDefault());
        String s = formatter.format(date);
        return s;
    }

    /**
     * This will return Date which will taken as string
     *
     * @returns Date format of given String date
     */
    public static Date convertStringIntoDate(String dateFormat, String strDate) {
        DateFormat formatter;
        Date dateToReturned = null;
        formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        try {
            dateToReturned = formatter.parse(strDate);
        } catch (ParseException e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("Converted date is " + dateToReturned);

        return dateToReturned;
    }

    /**
     * This will converts given date with required format
     *
     * @param date string which you want to convert
     * @returns converted given date as string with required format
     */
    public static String convertDateFormat(String date, String sourceFormat,
                                           String destinationFormat) throws ParseException {
        String returnDate = "";

        if (date != null && !date.equals("")) {
            SimpleDateFormat formatter = new SimpleDateFormat(sourceFormat,
                    Locale.getDefault());
            Date date1 = formatter.parse(date);


            formatter = new SimpleDateFormat(destinationFormat, Locale.getDefault());
            returnDate = formatter.format(date1);
        }

        return returnDate;
    }

    /**
     * This function returns current date with required format
     *
     * @returns current date as String with required format
     */
    public static String getCurrentRequiredFormatDate(String requiredFormat) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat(requiredFormat,
                Locale.getDefault());
        return formatter.format(date);
    }

    public static String getDateInGivenFormat(String date, String currentFormat,
                                              String inWhatFormat) {

        SimpleDateFormat fromUser = new SimpleDateFormat(currentFormat,
                Locale.getDefault());
        SimpleDateFormat myFormat = new SimpleDateFormat(inWhatFormat,
                Locale.getDefault());
        String reformattedStr = "";
        try {
            reformattedStr = myFormat.format(fromUser.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reformattedStr;
    }



    public static Date getDateFromFormattedDateString(String dateString, String format) {
        Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat
                    (format, Locale.getDefault());
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }






}
