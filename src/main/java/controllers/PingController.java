package controllers;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("ping")
public class PingController {

    @GET
    public String ping() {
        System.out.println("REQUEST RECEIVED");
        return "Enjoy Java EE 8!";
    }

}
