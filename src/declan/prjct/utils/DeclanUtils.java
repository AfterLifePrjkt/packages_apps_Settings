/*
 * Copyright (C) 2023 The AfterLife Project
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

package declan.prjct.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.content.res.Resources;
import androidx.annotation.ColorInt;
import java.util.Random;

public class DeclanUtils {
	
	public static int dpToPx(float dp) {
		return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
		Resources.getSystem().getDisplayMetrics()));
	}
	
	@ColorInt
	public static int getColorAttr(Context context, int attr) {
		TypedArray ta = context.obtainStyledAttributes(new int[] {attr});
		@ColorInt int color = ta.getColor(0, 0);
		ta.recycle();
		return color;
	}
	
	public static int getLightDarkColor(Context context, int lightColor, int darkColor) {
        Resources res = context.getResources();
        return !isThemeDark(context) ? res.getColor(lightColor) : res.getColor(darkColor);
    }
    private static Boolean isThemeDark(Context context) {
        switch (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_NO:
                return false;
            default:
                return false;
        }
    }
}