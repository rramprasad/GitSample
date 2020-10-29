package com.rramprasad.gitsample

import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity

class BaseActivity : AppCompatActivity() {

    /**
     * Set Localization for extended sub Activity
     */
    fun setLocale(){
        // Commented for the version 1.0, as we used default as English language

        Resources resources = getResources()
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();

        String currentSelectedLanguageCode = getCurrentSelectedLanguageCode(this);
        String[] codes = currentSelectedLanguageCode.split("-");
        String languageCode = codes[0];
        String countryCode = codes[1];

        if(countryCode.equalsIgnoreCase("CHT")){
            configuration.setLocale(Locale.TRADITIONAL_CHINESE);
        }
        else if(countryCode.equalsIgnoreCase("CHS")){
            configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
        }
        else{
            configuration.setLocale(new Locale(languageCode,countryCode));
        }
        resources.updateConfiguration(configuration,displayMetrics);
    }

    public static String getCurrentSelectedLanguageCode(Context context) {
        return AndroidAppUtils.getAppSharedPreference(context).getString(
            PREF_KEY_CURRENT_SELECTED_LANGUAGE_CODE, "en-US");
    }

}