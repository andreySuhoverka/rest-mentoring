package com.sukhoverka.service;

import com.sukhoverka.dao.UserDao;
import com.sukhoverka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void createUser(User user){
        userDao.createUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{userId}")
    public User getUser(@PathParam("userId") Integer id) {
        return userDao.getUser(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        userDao.deleteUser(id);
        return Response.status(200)
                .entity("user with id = " + id + " successfully deleted!")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

}
