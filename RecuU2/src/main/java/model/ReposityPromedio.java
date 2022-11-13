package model;

import utils.Response;

import java.sql.SQLException;
import java.util.List;

public interface ReposityPromedio <T> {
    List<T> findAll();
}
