package model.estudiante;

import model.ReposityEstudiante;
import model.docente.DaoDocente;
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

public class DaoEstudiante implements ReposityEstudiante<BeanEstudiante> {

    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();
    //@Override
    @Override
    public List<BeanEstudiante> findAllEstudiantes() {
        List<BeanEstudiante> estudiantes = new ArrayList<>();
        BeanEstudiante estudiante = null;
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM estudiante;");
            rs = pstm.executeQuery();
            while (rs.next()){
                estudiante = new BeanEstudiante();
                estudiante.setId(rs.getLong("idestudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setFechaN(rs.getString("fechaN"));
                estudiante.setCurp(rs.getString("curp"));
                estudiante.setMatricula(rs.getString("matricula"));
                estudiantes.add(estudiante);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return estudiantes;
    }

    @Override
    public Response<BeanEstudiante> save(BeanEstudiante estudiante) throws SQLException {
        try{
            connection =client.getConnection();
            String query="INSERT INTO docente ( `nombre`, `apellidos`, `fechaN`, `curp`, `numeroEmp`) VALUES (?,?.?,?,?);";
            pstm=connection.prepareStatement(query);
            pstm.setString(1,estudiante.getNombre());
            pstm.setString(2,estudiante.getApellidos());
            pstm.setString(3,estudiante.getFechaN());
            pstm.setString(4,estudiante.getCurp());
            pstm.setString(5,estudiante.getMatricula());



            if (pstm.executeUpdate()==1){
                return  new Response<BeanEstudiante>(200,"Regitrado correctamente",estudiante,false);
            }else{
                return  new Response<>(200,"Error al regitrar",estudiante,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName())
                    .log(Level.SEVERE, "Error -> findAll" + e.getMessage());
            return new Response<>(400,"Error con el Servidor",null,true);
        }finally {
            client.close(connection,pstm,rs);
        }
    }

    @Override
    public Response<BeanEstudiante> update(BeanEstudiante estudiante) {
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE `estudiante` SET `nombre` = ?, `apellidos` = ?, `fechaN` = ?, `curp` = ?, `matricula` = ? WHERE (`idestudiante` = ?);");
            pstm.setString(1,estudiante.getNombre());
            pstm.setString(2,estudiante.getApellidos());
            pstm.setString(3,estudiante.getFechaN());
            pstm.setString(4,estudiante.getCurp());
            pstm.setString(5,estudiante.getMatricula());
            pstm.setLong(6, estudiante.getId());
            if (pstm.executeUpdate() == 1) {
                return new Response<BeanEstudiante>(200, "Actualizado exitoso", estudiante, false);
            } else {
                return new Response<BeanEstudiante>(200, "Error de actualizado. Intente nuevamente", estudiante, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
            return new Response<BeanEstudiante>(200,"Error con el servidor",estudiante,true);
        }
    }


}
