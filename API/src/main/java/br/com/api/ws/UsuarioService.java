package br.com.api.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.api.bean.Denuncia;
import br.com.api.bean.TransactionStatus;
import br.com.api.dao.DenunciaDao;

@Path("/Denuncia")
public class UsuarioService {

	@GET
	@Path("/Insert/{id_usuario}/{titulo}/{descricao}/{img}")
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(@PathParam("id_usuario") String id_usuario, @PathParam("titulo") String titulo, 
			@PathParam("descricao") String descricao, @PathParam("img") String img) {
		TransactionStatus ts = new TransactionStatus();
		try {
			new DenunciaDao().insert(id_usuario,titulo,descricao,img);
			ts.setStatus(true);
		} catch (Exception e) {
			ts.setStatus(false);
		}
		return "ae";
	}
		
	@GET
	@Path("/ListDenuncia")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Denuncia> getListDenuncia() {
		List<Denuncia> list = new ArrayList<>();
		TransactionStatus ts = new TransactionStatus();
		try {
			list = new DenunciaDao().getList();
			ts.setStatus(true);
		} catch (Exception e) {
			ts.setStatus(false);
		}
		return list;
	}
	
	@GET
	@Path("/ListDenunciaByUsuario/{usuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Denuncia> getListDenuncia(@PathParam("usuario") String usuario) {
		List<Denuncia> list = new ArrayList<>();
		TransactionStatus ts = new TransactionStatus();
		try {
			list = new DenunciaDao().getListByUser(usuario);
			ts.setStatus(true);
		} catch (Exception e) {
			ts.setStatus(false);
		}
		return list;
	}
}