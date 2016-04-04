
demo available at: 52.36.155.251:8080/rest-mentoring

You can test api via jersey client and also play with it via postman

api:
prefix: 52.36.155.251:8080/rest-mentoring/

UserService:

    @GET
    /rest/users

    fetches all available user and respond with array of json objects

    @GET
    /rest/users/{userId}

    fetches user by id and respond with json user representation

    @POST
    /rest/users

    put it as a body
    <user>
        <id>1</id>
        <firstName>name</firstName>
        <lastName>surname</lastName>
        <email>email@gmail.com</email>
    </user>

    and set a header
    Content-Type:application/xml

    request will update user with id = 1


    @PUT
    /rest/users

    put as a body following xml:
    <user>
        <firstName>cards</firstName>
        <lastName>house</lastName>
        <email>houseOFCards@gmail.com</email>
    </user>

    and set a header
    Content-Type:application/xml

    here you must not specify id because it will be created on the server side as it's put request
    request will create user

    @DELETE
    /rest/users/{userId}

    e.g. /rest/users/5

    request will delete user with id = 5


    demo available at: 52.36.155.251:8080/

