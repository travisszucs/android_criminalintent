package com.bignerdranch.android.criminalintent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Travis on 2/7/2016.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public String getFormatedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMM d, yyyy");
        return sdf.format(mDate);
    }

    public String getFormatedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(mDate);
    }

    public String getFormatedDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMM d HH:mm yyyy");
        return sdf.format(mDate);
    }

    public void setDate(Date date) {
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(date);
        int year = newCalendar.get(Calendar.YEAR);
        int month = newCalendar.get(Calendar.MONTH);
        int day = newCalendar.get(Calendar.DAY_OF_MONTH);

        // Don't want to overwrite hours and minutes
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        calendar.set(year, month, day);
        mDate = calendar.getTime();
    }

    public void setTime(Date time) {
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(time);
        int hour = newCalendar.get(Calendar.HOUR_OF_DAY);
        int min = newCalendar.get(Calendar.MINUTE);

        // Don't want to overwrite year, month, and day
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        mDate = calendar.getTime();
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }
}
