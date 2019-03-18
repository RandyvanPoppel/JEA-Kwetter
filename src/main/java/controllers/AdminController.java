package controllers;

import models.Admin;
import services.AdminService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Stateless
@Path("admin")
public class AdminController extends BaseController {
    @Inject
    AdminService adminService;

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Admin addAdmin(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Admin admin = new Admin();
        adminService.addAdmin(admin);
        return admin;
    }

    @DELETE
    @Path("remove")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean removeKweet(String params) {
        HashMap<String, String> mappedParams = mapParams(params);
        Admin admin = adminService.findByID(Long.parseLong(mappedParams.get("id")));
        if (admin != null)
        {
            adminService.removeAdmin(admin);
            return true;
        }
        return false;
    }
}
