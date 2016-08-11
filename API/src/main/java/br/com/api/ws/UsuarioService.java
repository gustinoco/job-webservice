package br.com.api.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.api.bean.TransactionStatus;
import br.com.api.bean.Usuario;
import br.com.api.bean.UsuarioResult;
import br.com.api.dao.UsuarioDao;

@Path("/Usuario")
public class UsuarioService {
	@POST
	@Path("/Insert")
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TransactionStatus insert(Usuario usuario) {
		TransactionStatus ts = new TransactionStatus();
		try {
			new UsuarioDao().insert(usuario);
			ts.setStatus(true);
			ts.setDescricao("Sucesso na insercao");
		} catch (Exception e) {
			ts.setStatus(false);
			ts.setDescricao("Deu problema : "+e.getMessage());
		}
		return ts;
	}
		
	@GET
	@Path("/ListUsuario")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UsuarioResult getListUsuarios() {		
		UsuarioResult result = new UsuarioResult();
		TransactionStatus ts = new TransactionStatus();
		try {
			result.setUsuarios(new UsuarioDao().getList());			
			ts.setStatus(true);
			ts.setDescricao("Listagem OK!");
		} catch (Exception e) {
			ts.setStatus(false);
			ts.setDescricao("Listagem deu problema! "+e.getMessage());
		}
		result.setStatus(ts);
		return result;
	}	
}