package controllers;

import models.Moderator;
import services.ModeratorService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Stateless
@Path("moderator")
public class ModeratorController extends BaseController {
    @Inject
    ModeratorService moderatorService;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Moderator addModerator(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Moderator moderator = new Moderator();
        moderatorService.addModerator(moderator);
        return moderator;
    }

    @DELETE
    @Path("remove")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean removeKweet(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Moderator moderator = moderatorService.findByID(Long.parseLong(mappedParams.get("id")));
        if (moderator != null)
        {
            moderatorService.removeModerator(moderator);
            return true;
        }
        return false;
    }

    @GET
    @Path("find")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Moderator findByID(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return moderatorService.findByID(Long.parseLong(mappedParams.get("id")));
    }
}
