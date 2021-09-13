/*
 * Copyright (C) 2018 The Android public Source Project
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
import android.annotation.NonNull;

public class colorgiber {

    int defaultColor = 0x000000;

    private WallpaperManager wallpaperManager;
    private Drawable wallpaperDrawable;
    private Bitmap bitmap;
    private Palette p;
    private ColorScheme colorscheme;

    public colorgiber(@NonNull Context context) {
        wallpaperManager = WallpaperManager.getInstance(context);
        wallpaperDrawable = wallpaperManager.getDrawable();
        bitmap = ((BitmapDrawable)wallpaperDrawable).getBitmap();
        p = Palette.from(bitmap).generate();
        colorscheme = new ColorScheme(p.getDominantColor(defaultColor), false);
    }

    public int fuckYouKotlin(int color, int whichgayp, int whichgayc)
    {
        ColorScheme colorscheme = new ColorScheme(color, false);
        int k = colorscheme.getColor(whichgayp, whichgayc);
        return k;
    }

    public int noSysPriviledgeMoment(int whichgayp, int whichgayc, Context context){
        int k = colorscheme.getColor(whichgayp, whichgayc);
        return k;
    }

    public int noContextMoment(int whichgayp, int whichgayc){
        int k = colorscheme.getColor(whichgayp, whichgayc);
        return k;
    }
    
    public Drawable noContextWallMoment(){
        return wallpaperDrawable;
    }

    public int darkDedeBhayPlz(int color, int whichgayp, int whichgayc){
        ColorScheme colorscheme = new ColorScheme(color, false);
        int k = colorscheme.getColor(whichgayp, whichgayc);

        int a = Color.alpha(k);
        int r = Math.round(Color.red(k) * 0.3f);
        int g = Math.round(Color.green(k) * 0.3f);
        int b = Math.round(Color.blue(k) * 0.3f);
        return Color.argb(a,
                Math.min(r,255),
                Math.min(g,255),
                Math.min(b,255));
    }

}
