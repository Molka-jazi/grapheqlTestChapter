package ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import entities.Chapter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/chapter")
@Api
public class ChapterApi  {
	static List<Chapter> list = new ArrayList<Chapter>();
	
	public ChapterApi() {
		// TODO Auto-generated constructor stub
		this.list.add(new Chapter("ref1", "JaxRS", "Web Service",3));
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	@ApiOperation(value = "Get All Employes",produces = MediaType.APPLICATION_JSON)
	  @ApiResponses({
	    @ApiResponse(code=200, message="Success")
	  })
	public Response getAllChapter() {
		return  Response.status(200).entity(list).build();
	}
	
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addChapter")
	@ApiOperation(value = "Add Chapter")
	  @ApiResponses({
	    @ApiResponse(code=201, message="Success")
	  })
	public Response addChapter(Chapter Chapter) {	
		if( this.list.add(Chapter)) {
		return Response
				.status(201)
				.entity("Chapter added succesfully")
				.build();	 
		}else {
			return Response
					.status(404)
					.entity( "failed to add Chapter")
					.build();
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //bich tjih men aand el client kima fel ajouter bich yab3athlk el objet
	@Path("/updateChapter")

	public Response updateChapter(Chapter i) {
		int index = getIndexById1(i.getId());

		if (index != -1) {
			list.set(index, i);
			return Response.status(200).entity("update successful ").build();
		}else {
		return Response.status(500).entity("update unsuccessful").build();
		}

	}
	
	
	@DELETE 
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/deleteChapter/{id}")

	public Response deleteChapter(@PathParam(value="id") String id) {
		int index = getIndexById1(id);
		if (index != -1) {
			this.list.remove(index);
			return Response.status(200).entity("true").build();
		} else
			return Response.status(500).entity("false").build();

	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	@Path("/getbyid/{id}")

	public Response getIndexById(@PathParam(value="id") String id) { //PathParam nhot 1 elli howa id akahou fel url 	//http://localhost:8087/project.esprit.tn/api/hello/1
		//QueryParam nhot id=1 http://localhost:8087/project.esprit.tn/api/hello/id=1

		for (Chapter i : this.list) {
			if (i.getId().equals(id))
				//return this.list.indexOf(i);
				return Response.status(200).entity(list.indexOf(i)).build();;

		}
		//return -1;
		return Response.status(404).build();

	}
	
	
	public int getIndexById1(String id) {
		for (Chapter i : this.list) {
			if (i.getId().equals(id))
				return this.list.indexOf(i);
		}
		return -1;
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //houni el serveur howa elli yab3eth lel client kima return message de retour
	@Path("/getbyName/{name}")

	public Response getIndexByName(@PathParam(value="name") String name) {
		for (Chapter i : this.list) {
			if (i.getName().equals(name))
				//return this.list.indexOf(i);
				return Response.status(200).entity("found").build();;

		}
		//return -1;
		return Response.status(404).build();

	}

}
