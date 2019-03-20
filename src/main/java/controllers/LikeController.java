package controllers;

import models.Like;
import services.KweetService;
import services.KweeterService;
import services.LikeService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Stateless
@Path("like")
public class LikeController extends BaseController {
    @Inject
    LikeService likeService;

    @Inject
    KweetService kweetService;

    @Inject
    KweeterService kweeterService;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Like addLike(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        // TODO: Add auth to specify Kweeter
        Like like = new Like(kweetService.findByID(Long.parseLong(mappedParams.get("kweetID"))), kweeterService.findByUserName(mappedParams.get("username")));
        likeService.addLike(like);
        return like;
    }

    @DELETE
    @Path("remove")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean removeLike(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Like like = likeService.findByID(Long.parseLong(mappedParams.get("id")));
        if (like != null)
        {
            likeService.removeLike(like);
            return true;
        }
        return false;
    }

    @GET
    @Path("find")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Like findByID(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return likeService.findByID(Long.parseLong(mappedParams.get("id")));
    }

    @GET
    @Path("find_by_kweet")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Like> findByKweet(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return likeService.findByKweet(kweetService.findByID(Long.parseLong(mappedParams.get("kweetID"))));
    }

    @GET
    @Path("find_by_kweeter")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Like> findByKweeter(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return likeService.findByKweeter(kweeterService.findByUserName(mappedParams.get("username")));
    }
}
