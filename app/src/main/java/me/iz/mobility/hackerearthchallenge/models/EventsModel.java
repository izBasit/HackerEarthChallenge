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

import java.util.ArrayList;
import java.util.List;

public class EventsModel {

@SerializedName("response")
@Expose
private List<Event> response = new ArrayList<>();

/**
* 
* @return
* The response
*/
public List<Event> getResponse() {
return response;
}

/**
* 
* @param response
* The response
*/
public void setResponse(List<Event> response) {
this.response = response;
}



}