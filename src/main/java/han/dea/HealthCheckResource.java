package han.dea;

import han.dea.services.ItemService;
import han.dea.services.dto.ItemDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/health")
public class HealthCheckResource {
    private ItemService itemService = new ItemService();

    @GET
    public String healthy() {
        return "Up & Running";
    }

    @GET
    @Path("/items")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getItemsAsText() {
        return Response.ok("bread, butter").build();
    }

//    @Path("/items")
//    public class ItemResource {
//        private ItemService itemService;
//
//        public ItemResource() {
//            this.itemService = new ItemService();
//        }
//        private ItemResource itemResource;
//
//        @GET
//        @Path("/items")
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response getItemsAsJSON() {
//            return Response.accepted(itemService.getAll()).build();
//        }

    @GET
    @Path("/items2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsAsListInJSON() {
        List<ItemDTO> itemList = itemService.getAll();
        return Response.ok(itemList).build();
    }
    @GET
    @Path("/items/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemByID(@PathParam("itemId")Integer itemId) {
        return Response.ok(itemService.getItem(itemId)).build();
    }
    @POST
    @Path("/items")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(ItemDTO item){
        itemService.addItem(item);
        return Response.status(Response.Status.CREATED).build();
    }
}
// }
