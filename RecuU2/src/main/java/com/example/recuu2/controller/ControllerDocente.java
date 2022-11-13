package com.example.recuu2.controller;

import model.docente.BeanDocente;
import model.docente.DaoDocente;
import utils.Response;

import javax.ws.rs.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/docente")
public class ControllerDocente {
    Map<String,Object> Response = new HashMap<>();

    @GET @Path("/") @Produces(value = {"application/json"})
    public List<BeanDocente> getAllDocentes(){
        return new DaoDocente().findAllDocentes();
    }

    @POST
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanDocente docente) throws SQLException {
        Response<BeanDocente> result = new DaoDocente().save(docente);
        Response.put("result",result);
        return Response;
    }

    @PUT
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> update(BeanDocente docente){
        Response<BeanDocente> result = new DaoDocente().update(docente);
        Response.put("result",result);
        return Response;
    }

}
