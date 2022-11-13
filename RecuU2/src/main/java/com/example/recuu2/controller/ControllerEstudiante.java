package com.example.recuu2.controller;
import model.estudiante.DaoEstudiante;
import model.estudiante.BeanEstudiante;
import model.estudiante.DaoEstudiante;
import utils.Response;

import javax.ws.rs.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/estudiante")
public class ControllerEstudiante {
    Map<String,Object> Response = new HashMap<>();

    @GET @Path("/") @Produces(value = {"application/json"})
    public List<BeanEstudiante> getAllEstudante(){
        return new DaoEstudiante().findAllEstudiantes();
    }

    @POST
    @Path("/") @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanEstudiante estudiante) throws SQLException {
        System.out.println(estudiante.getNombre());
        utils.Response<BeanEstudiante> result = new DaoEstudiante().save(estudiante);
        Response.put("result",result);
        return Response;
    }

    @PUT
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> update(BeanEstudiante estudiante){
        System.out.println(estudiante.getId());
        System.out.println(estudiante.getNombre());
        Response<BeanEstudiante> result = new DaoEstudiante().update(estudiante);
        Response.put("result",result);
        return Response;
    }
    
    
}
