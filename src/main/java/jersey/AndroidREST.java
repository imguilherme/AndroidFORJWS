package jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("ContaBancaria")
public class AndroidREST {

	
	
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "Hey, This is Jersey JAX-RS !";
	}

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ContaBancaria> listar() {
		if(ContaBancariaRepositorio.getLista() == null){
			System.out.println("Lista ta vindo null");
		}

		return ContaBancariaRepositorio.getLista();
	}
	
	@POST
	@Path("/inserir")
	@Consumes("application/x-www-form-urlencoded")
	public Response inserir(
			  @FormParam("nome") String nome,
	            @FormParam("agencia") int agencia,
	            @FormParam("conta") int conta,
	            @FormParam("tipo") String tipo
			){
		
		ContaBancaria contaBancaria = new ContaBancaria();
		contaBancaria.setId(++ContaBancariaRepositorio.LAST_ID);
		contaBancaria.setNome(nome);
		contaBancaria.setAgencia(agencia);
		contaBancaria.setConta(conta);
		contaBancaria.setTipo(tipo);
		
		ContaBancariaRepositorio.getLista().add(contaBancaria);
		
		String resultado =  "Conta salva " + contaBancaria.getNome();
		return Response.status(201).entity(resultado).build();		
	}
	
	
	

}