package stetho.five.stethodemo.business.dao;

import java.util.List;

import stetho.five.stethodemo.business.dao.model.Variable;

public interface DemoDao {

    List<Variable> getAllVariables();

    void deleteVariableWithId(long id);

}
