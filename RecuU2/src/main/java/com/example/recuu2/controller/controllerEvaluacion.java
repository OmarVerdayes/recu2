package com.example.recuu2.controller;

import model.docente.BeanDocente;
import model.docente.DaoDocente;
import model.evaluacion.BeanEvaluacion;
import model.evaluacion.BeanPromedio;
import model.evaluacion.DaoEvaluacion;
import model.evaluacion.DaoPromedio;
import utils.Response;

import javax.ws.rs.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/evaluacion")
public class controllerEvaluacion {
    Map<String,Object> Response = new HashMap<>();
    @POST
    @Path("/") @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanEvaluacion evaluacion) throws SQLException {
        utils.Response<BeanEvaluacion> result = new DaoEvaluacion().save(evaluacion);
        Response.put("result",result);
        return Response;
    }

    @GET
    @Path("/") @Produces(value = {"application/json"})
    public List<BeanPromedio> getAllDocentes(){
        return new DaoPromedio().findAll();
    }


}
