package model.docente;

import model.Repository;
import model.estudiante.BeanEstudiante;
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

public class DaoDocente  implements Repository<BeanDocente> {

    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();



    @Override
    public List<BeanDocente> findAllDocentes() {
        List<BeanDocente> docentes = new ArrayList<>();
        BeanDocente maestro = null;
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM docente;");
            rs = pstm.executeQuery();
            while (rs.next()){
                maestro = new BeanDocente();
                maestro.setId(rs.getLong("iddocente"));
                System.out.println(rs.getLong("iddocente"));
                maestro.setNombre(rs.getString("nombre"));
                maestro.setApellidos(rs.getString("apellidos"));
                maestro.setFechaN(rs.getString("fechaN"));
                maestro.setCurp(rs.getString("curp"));
                maestro.setNumeroEmp(rs.getLong("numeroEmp"));
                docentes.add(maestro);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return docentes;
    }

    @Override
    public Response<BeanDocente> save(BeanDocente docente) throws SQLException {
        try{
            connection =client.getConnection();
            String query="INSERT INTO docente ( `nombre`, `apellidos`, `fechaN`, `curp`, `numeroEmp`) VALUES (?,?.?,?,?);";
            pstm=connection.prepareStatement(query);
            pstm.setString(1,docente.getNombre());
            pstm.setString(2,docente.getApellidos());
            pstm.setString(3,docente.getFechaN());
            pstm.setString(4,docente.getCurp());
            pstm.setLong(5,docente.getNumeroEmp());



            if (pstm.executeUpdate()==1){
                return  new Response<BeanDocente>(200,"Regitrado correctamente",docente,false);
            }else{
                return  new Response<>(200,"Error al regitrar",docente,true);
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
    public Response<BeanDocente> update(BeanDocente docente) {
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE docente SET nombre = ?, apellidos = ?, fechaN = ?, curp = ?, numeroEmp = ?,  where iddocente = ?;");
            pstm.setString(1,docente.getNombre());
            pstm.setString(2,docente.getApellidos());
            pstm.setString(3,docente.getFechaN());
            pstm.setString(4,docente.getCurp());
            pstm.setLong(5,docente.getNumeroEmp());
            pstm.setLong(6, docente.getId());
            if (pstm.executeUpdate() == 1) {
                return new Response<BeanDocente>(200, "Actualizado exitoso", docente, false);
            } else {
                return new Response<BeanDocente>(200, "Error de actualizado. Intente nuevamente", docente, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
            return new Response<BeanDocente>(200,"Error con el servidor",docente,true);
        }
    }

}
