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
 *  @modified 3/18/16 10:57 PM
 */

package me.iz.mobility.hackerearthchallenge.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Hashtable;

/* This class should be used to get {@linkTypeface} object.
 *	
 *	Creating a Typeface from the assets is a heavy operation,
 *  and we'll probably be using these fonts in ListViews or maybe for every view containing text on screen.
 *  If we don't cache the typefaces, the performance of the ListView will degrade horribly.
 *  This way, we only create the Typeface once, and recall it from the cache when needed.
 */
public class TypefaceCache {

    public static final String OPEN_SANS_LIGHT_TTF = "fonts/OpenSans-Light.ttf";

    private static final Hashtable<String, Typeface> CACHE = new Hashtable<String, Typeface>();

    /**
     * @param manager
     * @param typefaceCode indicating which font to use.
     *                     generally specified in xml.
     * @return TypeFace
     * returns object of {@link Typeface} specified.
     * If typeface is not cached, function create new one, caches it and returns.
     */
    public static Typeface getTypeFace(AssetManager manager, int typefaceCode) {
        synchronized (CACHE) {
            String typefaceName = getTypefaceName(typefaceCode);
            if (!CACHE.containsKey(typefaceName)) {
                Typeface typeface = Typeface.createFromAsset(manager, typefaceName);
                CACHE.put(typefaceName, typeface);
            }
            return CACHE.get(typefaceName);
        }
    }


    /**
     * @param manager
     * @param typeface constant:
     *                 values: {@link #OPEN_SANS_LIGHT_TTF}
     * @return TypeFace
     * returns object of {@link Typeface} specified.
     * If typeface is not cached, function create new one, caches it and returns.
     */
    public static Typeface getTypeFace(AssetManager manager, String typeface) {
        String typefaceName = typeface;
        if (!CACHE.containsKey(typefaceName)) {
            Typeface typeface1 = Typeface.createFromAsset(manager, typeface);
            CACHE.put(typefaceName, typeface1);
        }
        return CACHE.get(typeface);
    }

    /**
     * @param typefaceCode
     * @return name
     * returns typeface name from {@link TypefaceCache#OPEN_SANS_LIGHT_TTF*}
     */
    private static String getTypefaceName(int typefaceCode) {
        switch (typefaceCode) {
            case 0:
                return OPEN_SANS_LIGHT_TTF;
            default:
                return OPEN_SANS_LIGHT_TTF;
        }
    }

}