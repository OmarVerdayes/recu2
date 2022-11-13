package model;

import model.docente.BeanDocente;
import utils.Response;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    List<T> findAllDocentes();
    Response<T> save(T object) throws SQLException;
    Response<T> update(T object);

}
