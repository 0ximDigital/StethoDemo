package stetho.five.stethodemo.business.dao;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = DemoDatabase.NAME, version = DemoDatabase.VERSION)
public final class DemoDatabase {

    public static final String NAME = "DemoDatabase";

    public static final int VERSION = 1;

}
