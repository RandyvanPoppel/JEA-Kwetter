package controllers;

import models.Comment;
import services.CommentService;
import services.KweetService;
import services.KweeterService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Stateless
@Path("comment")
public class CommentController extends BaseController {

    @Inject
    CommentService commentService;

    @Inject
    KweetService kweetService;

    @Inject
    KweeterService kweeterService;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Comment addComment(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        // TODO: Add auth to specify Kweeter
        Comment comment = new Comment(kweeterService.findByUserName(mappedParams.get("username")), kweetService.findByID(Long.parseLong(mappedParams.get("kweet_id"))), mappedParams.get("message"));
        commentService.addComment(comment);
        return comment;
    }

    @DELETE
    @Path("remove")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean removeKweet(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Comment comment = commentService.findByID(Long.parseLong(mappedParams.get("id")));
        if (comment != null)
        {
            commentService.removeComment(comment);
            return true;
        }
        return false;
    }

    @GET
    @Path("find")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Comment findByID(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return commentService.findByID(Long.parseLong(mappedParams.get("id")));
    }

    @GET
    @Path("find_by_message")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Comment> findByMessage(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        return commentService.findByMessage(mappedParams.get("message"));
    }

    @GET
    @Path("all")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Comment> getComments()
    {
        return commentService.getComments();
    }
}
