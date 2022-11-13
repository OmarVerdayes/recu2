package model.evaluacion;

import model.ReposityPromedio;
import model.docente.DaoDocente;
import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPromedio  implements ReposityPromedio<BeanPromedio> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanPromedio> findAll() {
        List<BeanPromedio> promedioF = new ArrayList<>();
        BeanPromedio promedio = null;
        promedio.setCalificaion(0);
        promedio.setRegistros(0);
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM evaluacion;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Long cal = rs.getLong("calficaion");
                promedio.setCalificaion(promedio.getCalificaion() + cal);
                promedio.setRegistros(promedio.getRegistros() + 1);

            }
            promedio.setCalificaion(promedio.getCalificaion() /promedio.getRegistros() );
            promedioF.add(promedio);
        } catch (SQLException e) {
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }

        return promedioF;
    }
}
