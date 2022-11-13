package model;

import utils.Response;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryEvaluacion<T> {
    Response<T> save(T object) throws SQLException;
}
