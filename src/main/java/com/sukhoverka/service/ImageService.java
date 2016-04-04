package com.sukhoverka.service;

import com.sukhoverka.dao.ImageDao;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Path("/logo")
@Component
public class ImageService {

    @Autowired
    ImageDao imageDao;

    @GET
    @Path("{id}")
    @Produces("image/png")
    public Response getUserLogo(@PathParam("id") Integer userId) throws Exception {

        byte[] logoBytes = imageDao.getUserLogo(userId);
        if(logoBytes == null) {
            return Response.status(500)
                    .entity("user with id = " + userId + " does not exist")
                    .build();
        } else {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("tmp.jpg");
            fileOutputStream.write(logoBytes);
            return Response.ok((Object) new File("tmp.jpg")).build();
        }

    }


    @PUT
    @Path("{userId}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createUserLogo(
                               @FormDataParam("logo") InputStream uploadedInputStream,
                               @FormDataParam("logo") FormDataContentDisposition metaInfo) {
        int responseStatus;
        String responseMsg;
        if(metaInfo.getSize() > 1024 * 1024 * 10) {
            responseStatus = 500;
            responseMsg = "Uploaded file must have size < 10mb";
        } else {
            responseStatus = 200;
            responseMsg = "File Successfully uploaded";
            imageDao.saveUserLogo(1, uploadedInputStream);
        }

        return Response.status(responseStatus)
                .entity(responseMsg)
                .build();

    }


}
