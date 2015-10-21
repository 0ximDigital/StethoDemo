package stetho.five.stethodemo.application.dumpapp;

import android.content.Context;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.util.ArrayList;
import java.util.List;

import stetho.five.stethodemo.application.Injector;

public final class DemoDumperPluginsProvider implements DumperPluginsProvider {

    private final Context context;

    public DemoDumperPluginsProvider(Context context) {
        this.context = context;
    }

    @Override
    public Iterable<DumperPlugin> get() {
        List<DumperPlugin> dumperPluginList = new ArrayList<>();
        dumperPluginList.add(new DemoDumperPlugin(Injector.getInstance(context)));

        for(DumperPlugin defaultPlugin : Stetho.defaultDumperPluginsProvider(context).get()){
            dumperPluginList.add(defaultPlugin);
        }
        return dumperPluginList;
    }
}
