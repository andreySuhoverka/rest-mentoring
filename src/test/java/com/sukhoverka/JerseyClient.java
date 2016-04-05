package com.sukhoverka;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import com.sukhoverka.model.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.util.List;

public class JerseyClient {

    public static void main(String[] args) {
        try {

            ClientConfig cfg = new DefaultClientConfig(GensonJsonConverter.class);
            Client client = Client.create(cfg);

            WebResource webResource = client
                    .resource("http://localhost:8081/rest-app/rest/users");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request failed : HTTP error code : "
                        + response.getStatus());
            }

            List<User> output = response.getEntity(List.class);

            System.out.println("Server respond with the following users ... \n");
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
