package ru.rinastachel.mappy;

import android.app.Application;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.InspectorModulesProvider;
import com.facebook.stetho.Stetho;

import androidx.annotation.NonNull;

public class StethoUtils {
    static void init(@NonNull Application app) {
        InspectorModulesProvider modules = Stetho.defaultInspectorModulesProvider(app);
        DumperPluginsProvider plugins = Stetho.defaultDumperPluginsProvider(app);
        Stetho.initialize(Stetho.newInitializerBuilder(app).enableWebKitInspector(modules)
                .enableDumpapp(plugins)
                .build()
        );
    }
}
