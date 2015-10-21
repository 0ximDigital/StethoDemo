package stetho.five.stethodemo.business.dao;

import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import stetho.five.stethodemo.business.dao.model.Variable;
import stetho.five.stethodemo.business.dao.model.Variable$Table;

public final class DemoDaoImpl implements DemoDao {

    @Override
    public List<Variable> getAllVariables() {
        return new Select()
                .all()
                .from(Variable.class)
                .queryList();
    }

    @Override
    public void deleteVariableWithId(long id) {
        new Delete()
                .from(Variable.class)
                .where(Condition.column(Variable$Table.ID).eq(id))
                .queryClose();
    }

}
