package stetho.five.stethodemo.business.dao.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import stetho.five.stethodemo.business.dao.DemoDatabase;

@Table(databaseName = DemoDatabase.NAME)
public final class Variable extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    private long id;

    @Column
    private String name;

    @Column
    private int value;

    public Variable() {
    }

    public Variable(long id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
