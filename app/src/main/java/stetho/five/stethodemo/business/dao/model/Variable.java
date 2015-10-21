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

    @Column
    private int randomValue;

    public Variable() {
    }

    public Variable(long id, String name, int value, int randomValue) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.randomValue = randomValue;
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

    public int getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }
}
