package model.evaluacion;

import model.RepositoryEvaluacion;

import model.docente.DaoDocente;
import model.evaluacion.BeanEvaluacion;
import utils.MySQLConnection;
import utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEvaluacion implements RepositoryEvaluacion<BeanEvaluacion> {

    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public Response<BeanEvaluacion> save(BeanEvaluacion evaluacion) throws SQLException {
        try{
            connection =client.getConnection();
            String query="INSERT INTO evaluacion ( `nombreMateria`, `calificacion`, `alumno`, `docente`) VALUES ( ?, ?, ?, ?);";
            pstm=connection.prepareStatement(query);
            pstm.setString(1,evaluacion.getNombreMateria());
            pstm.setLong(2,evaluacion.getCalificacion());
            pstm.setLong(3,evaluacion.getEstudiante().getId());
            pstm.setLong(4,evaluacion.getDocente().getId());

            if (pstm.executeUpdate()==1){
                return  new Response<BeanEvaluacion>(200,"Regitrado correctamente",evaluacion,false);
            }else{
                return  new Response<>(200,"Error al regitrar",evaluacion,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> findAll" + e.getMessage());
            return new Response<>(400,"Error con el Servidor",null,true);
        }finally {
            client.close(connection,pstm,rs);
        }
    }
    //@Override
}
