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

package com.nezuko.support.monet;

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
import com.nezuko.support.monet.utils.Support;

public class SettingsColors {

    Support sup = new Support();
    final Context bruh = ActivityThread.currentApplication();
    boolean useMonet = Settings.System.getInt(bruh.getContentResolver(),
                Settings.System.MONET_TOGGLE, 1) == 1;

    public int mainBG(Context context){
        ColorScheme colorscheme = sup.scheme(context);
        int k = sup.isDarkM(context) ? Color.BLACK : Color.WHITE;
        if(useMonet){
            k = sup.isDarkM(context) ? colorscheme.getColor(5, 10) : colorscheme.getColor(5, 1);
        }
        return k;
    }

    public int secBG(Context context){
        ColorScheme colorscheme = sup.scheme(context);
        int k = sup.isDarkM(context) ? Color.parseColor("#161616") : Color.parseColor("#f2f2f2"); 
        if(useMonet){
            k = sup.isDarkM(context) ? colorscheme.getColor(4, 9) : colorscheme.getColor(5, 0);
        }
        return k;
    }

    public int iconCol(Context context){
        ColorScheme colorscheme = sup.scheme(context);
        int k = NezukoUtils.getThemeAccentColor(context);
        if (useMonet){
            k = sup.isDarkM(context) ? colorscheme.getColor(3, 6) : colorscheme.getColor(1, 7);
        }
        return k;
    }

    public int accentCol(Context context){
        ColorScheme colorscheme = sup.scheme(context);
        int k = NezukoUtils.getThemeAccentColor(context);
        if (useMonet){
            k =colorscheme.getColor(1, 5);
        }
        return k;
    }

    public int iconBGCol(Context context){
        ColorScheme colorscheme = sup.scheme(context);
        int k = sup.isDarkM(context) ? Color.WHITE : Color.BLACK;
        if (useMonet){
            k = sup.isDarkM(context) ? colorscheme.getColor(5, 0) : colorscheme.getColor(1, 7);
        }
        return k;
    }

}
