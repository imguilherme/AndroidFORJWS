package jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Tarefa")
public class AndroidREST {

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Tarefa> listar() {
		return TarefaRepositorio.getLista();
	}
	
	@POST
	@Path("/inserir")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Tarefa tarefa){
		tarefa.setId(++TarefaRepositorio.LAST_ID);
		TarefaRepositorio.getLista().add(tarefa);
		String resultado =  "{\"status\":\"sucesso\"}";
        return Response.ok(resultado, MediaType.APPLICATION_JSON).build();
	}
	
	

}