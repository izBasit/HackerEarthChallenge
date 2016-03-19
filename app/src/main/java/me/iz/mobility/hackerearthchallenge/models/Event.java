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
 *  @modified 3/19/16 1:34 AM
 */

package me.iz.mobility.hackerearthchallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("challenge_type")
    @Expose
    private String challengeType;
    @SerializedName("start_timestamp")
    @Expose
    private String startTimestamp;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("is_hackerearth")
    @Expose
    private Boolean isHackerearth;
    @SerializedName("end_tz")
    @Expose
    private String endTz;
    @SerializedName("end_utc_tz")
    @Expose
    private String endUtcTz;
    @SerializedName("subscribe")
    @Expose
    private String subscribe;
    @SerializedName("college")
    @Expose
    private Boolean college;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("start_utc_tz")
    @Expose
    private String startUtcTz;
    @SerializedName("start_tz")
    @Expose
    private String startTz;
    @SerializedName("end_timestamp")
    @Expose
    private String endTimestamp;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("cover_image")
    @Expose
    private String coverImage;

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The challengeType
     */
    public String getChallengeType() {
        return challengeType;
    }

    /**
     * @param challengeType The challenge_type
     */
    public void setChallengeType(String challengeType) {
        this.challengeType = challengeType;
    }

    /**
     * @return The startTimestamp
     */
    public String getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * @param startTimestamp The start_timestamp
     */
    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate The end_date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The isHackerearth
     */
    public Boolean getIsHackerearth() {
        return isHackerearth;
    }

    /**
     * @param isHackerearth The is_hackerearth
     */
    public void setIsHackerearth(Boolean isHackerearth) {
        this.isHackerearth = isHackerearth;
    }

    /**
     * @return The endTz
     */
    public String getEndTz() {
        return endTz;
    }

    /**
     * @param endTz The end_tz
     */
    public void setEndTz(String endTz) {
        this.endTz = endTz;
    }

    /**
     * @return The endUtcTz
     */
    public String getEndUtcTz() {
        return endUtcTz;
    }

    /**
     * @param endUtcTz The end_utc_tz
     */
    public void setEndUtcTz(String endUtcTz) {
        this.endUtcTz = endUtcTz;
    }

    /**
     * @return The subscribe
     */
    public String getSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe The subscribe
     */
    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * @return The college
     */
    public Boolean getCollege() {
        return college;
    }

    /**
     * @param college The college
     */
    public void setCollege(Boolean college) {
        this.college = college;
    }

    /**
     * @return The endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime The end_time
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The startUtcTz
     */
    public String getStartUtcTz() {
        return startUtcTz;
    }

    /**
     * @param startUtcTz The start_utc_tz
     */
    public void setStartUtcTz(String startUtcTz) {
        this.startUtcTz = startUtcTz;
    }

    /**
     * @return The startTz
     */
    public String getStartTz() {
        return startTz;
    }

    /**
     * @param startTz The start_tz
     */
    public void setStartTz(String startTz) {
        this.startTz = startTz;
    }

    /**
     * @return The endTimestamp
     */
    public String getEndTimestamp() {
        return endTimestamp;
    }

    /**
     * @param endTimestamp The end_timestamp
     */
    public void setEndTimestamp(String endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    /**
     * @return The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return The coverImage
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * @param coverImage The cover_image
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Override
    public String toString() {
        return "Event{" +
                "status='" + status + '\'' +
                ", challengeType='" + challengeType + '\'' +
                ", startTimestamp='" + startTimestamp + '\'' +
                ", description='" + description + '\'' +
                ", endDate='" + endDate + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", isHackerearth=" + isHackerearth +
                ", endTz='" + endTz + '\'' +
                ", endUtcTz='" + endUtcTz + '\'' +
                ", subscribe='" + subscribe + '\'' +
                ", college=" + college +
                ", endTime='" + endTime + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", startUtcTz='" + startUtcTz + '\'' +
                ", startTz='" + startTz + '\'' +
                ", endTimestamp='" + endTimestamp + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", coverImage='" + coverImage + '\'' +
                '}';
    }
}