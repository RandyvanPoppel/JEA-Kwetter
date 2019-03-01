package controllers;


import models.Kweeter;
import services.KweeterService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Stateless
@Path("kweeter")
public class KweeterController extends BaseController {

    @Inject
    KweeterService kweeterService;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String addKwetteraar(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Kweeter kweeter = new Kweeter(mappedParams.get("username"));
        kweeterService.addKwetteraar(kweeter);
        return kweeter.toString();
    }
}
