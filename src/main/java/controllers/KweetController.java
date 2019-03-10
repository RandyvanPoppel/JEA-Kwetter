package controllers;

import models.Kweet;
import services.KweetService;
import services.KweeterService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Stateless
@Path("kweet")
public class KweetController extends BaseController {

    @Inject
    KweetService kweetService;

    @Inject
    KweeterService kweeterService;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Kweet addKweeter(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        // TODO: Add auth to specify Kweeter
        Kweet kweet = new Kweet(kweeterService.findByUserName(mappedParams.get("username")), mappedParams.get("message"));
        System.out.println(kweet.toString());
        kweetService.addKweet(kweet);
        return kweet;
    }

    @DELETE
    @Path("remove")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean removeKweet(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Kweet kweet = kweetService.findByID(Long.parseLong(mappedParams.get("id")));
        if (kweet != null)
        {
            kweetService.removeKweet(kweet);
            return true;
        }
        return false;
    }

    @GET
    @Path("find")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Kweet findByID(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return kweetService.findByID(Long.parseLong(mappedParams.get("id")));
    }

    @GET
    @Path("find_by_message")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Kweet> findByMessage(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return kweetService.findByMessage(mappedParams.get("message"));
    }

    @GET
    @Path("all")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Kweet> getKweets()
    {
        return kweetService.getKweets();
    }
}
