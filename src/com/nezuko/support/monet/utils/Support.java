/*
 * Copyright (C) 2021 NezukoOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nezuko.support.monet.utils;

import com.nezuko.support.monet.ColorScheme;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.palette.graphics.Palette;
import androidx.core.graphics.ColorUtils;
import android.content.Context;
import android.app.WallpaperManager;
import com.android.internal.util.nezuko.NezukoUtils;
import android.app.ActivityThread;
import android.app.UiModeManager;
import android.os.PowerManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.graphics.Color;

public class Support {

    int defaultColor = 0x000000;
    int defaultColor2 = 0x00000000;
    int white = 0xFFFFFF;
    int white2 = 0xFFFFFFFF;
    
    final Context bruh = ActivityThread.currentApplication();
    boolean darkProfile = Settings.System.getInt(bruh.getContentResolver(),
                Settings.System.POWER_PROFILE_TYPE, 1) != 0;
    int currentScheme = Settings.System.getInt(bruh.getContentResolver(),
                Settings.System.AUTO_ACCENT_TYPE, 2);

    
    public ColorScheme scheme(Context context){
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        Bitmap bitmap = ((BitmapDrawable)wallpaperDrawable).getBitmap();
        Palette p = Palette.from(bitmap).generate();
        ColorScheme colorscheme = new ColorScheme(gibColor(p, currentScheme, bitmap), false);
        return colorscheme;
    }

    public int gibColor(Palette p, int kek, Bitmap wall){
        int colors[] = {
                p.getVibrantColor(defaultColor), p.getLightVibrantColor(defaultColor), p.getDominantColor(defaultColor), ColorUtils.blendARGB(p.getDominantColor(defaultColor), Color.WHITE, 0.5f), getAvgColor(wall)
        };

        if(colors[kek] == 0 || colors[kek] == defaultColor || p.getLightVibrantColor(defaultColor) == defaultColor2 || colors[kek] == white || colors[kek] == white2) {
            return p.getDominantColor(defaultColor);
        } else{
            return colors[kek];
        }
    }

    private int getAvgColor(Bitmap bitmap) {
        if (bitmap == null) {
            return Color.TRANSPARENT;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int size = width * height;
        int pixels[] = new int[size];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        int color;
        int r = 0;
        int g = 0;
        int b = 0;
        int a;
        int count = 0;
        for (int i = 0; i < pixels.length; i++) {
            color = pixels[i];
            a = Color.alpha(color);
            if (a > 0) {
                r += Color.red(color);
                g += Color.green(color);
                b += Color.blue(color);
                count++;
            }
        }
        r /= count;
        g /= count;
        b /= count;
        r = (r << 16) & 0x00FF0000;
        g = (g << 8) & 0x0000FF00;
        b = b & 0x000000FF;
        color = 0xFF000000 | r | g | b;
        return color;
    }

    public boolean isDarkM(Context context){
        UiModeManager mUiModeManager = context.getSystemService(UiModeManager.class);
        if (mUiModeManager.getNightMode() != UiModeManager.MODE_NIGHT_NO || isPowerSave(context)){
            // dark
            return true;
        } else{
            // light
            return false;
        }
    }

    public boolean isPowerSave(Context context){
        PowerManager mPowerManager = context.getSystemService(PowerManager.class);
        if(mPowerManager.isPowerSaveMode() && darkProfile){
            return true;
        }
        else{
            return false;
        }
    }
}
