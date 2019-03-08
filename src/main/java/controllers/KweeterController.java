package controllers;


import models.Kweeter;
import services.KweeterService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
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
    public Kweeter addKweeter(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Kweeter kweeter = new Kweeter(mappedParams.get("username"));
        kweeterService.addKweeter(kweeter);
        return kweeter;
    }

    @DELETE
    @Path("remove")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean removeKweeter(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Kweeter kweeter = kweeterService.findByUserName(mappedParams.get("username"));
        if (kweeter != null)
        {
            kweeterService.removeKweeter(kweeter);
            return true;
        }
        return false;
    }

    @GET
    @Path("find")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Kweeter findByUserName(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return kweeterService.findByUserName(mappedParams.get("username"));
    }

    @GET
    @Path("all")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Kweeter> getKweeters() {
        return kweeterService.getKweeters();
    }
}
