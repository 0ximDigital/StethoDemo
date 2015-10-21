package stetho.five.stethodemo.business.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DemoItem {
    DATABSE("Database"),
    PREFERENCES("Preferences"),
    NETWORK("Network"),
    UI("UI"),
    DUMPAPP("Dumpapp");

    private final String title;

    DemoItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static List<DemoItem> getDemoItems(){
        return new ArrayList<>(Arrays.asList(DATABSE, PREFERENCES, NETWORK, UI, DUMPAPP));
    }
}
