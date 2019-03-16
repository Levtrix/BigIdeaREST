package BigIdeaREST.restservices;
import BigIdeaREST.response.Reply;
import BigIdeaREST.response.Status;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/support")
public class UserService {

    @GET
    @Path("/login")
    public Response login() {
        Reply reply = new Reply(Status.OK, "test");

        return Response.status(reply.getStatus().getCode()).entity(reply.getMessage()).build();
    }
}
