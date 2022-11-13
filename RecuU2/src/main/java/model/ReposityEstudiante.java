package model;

import utils.Response;

import java.sql.SQLException;
import java.util.List;

public interface ReposityEstudiante<T> {
    List<T> findAllEstudiantes();
    Response<T> save(T object) throws SQLException;
    Response<T> update(T object);
}
