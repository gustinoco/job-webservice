package br.com.api.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.api.bean.ApresentacaoResult;
import br.com.api.bean.TransactionStatus;
import br.com.api.dao.ApresentacaoDao;

@Path("/Apresentacao")
public class ApresentacaoService {
	
		
	@GET
	@Path("/Get/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApresentacaoResult  getListUsuarios(@PathParam("id") String id) {		
		ApresentacaoResult result = new ApresentacaoResult();
		TransactionStatus ts = new TransactionStatus();
		try {
			result.setApresentacoes(new ApresentacaoDao().getList(id));			
			ts.setStatus(true);
			ts.setDescricao("Listou a pagina!");
		} catch (Exception e) {
			ts.setStatus(false);
			ts.setDescricao("Listagem deu problema! "+e.getMessage());
		}
		result.setStatus(ts);
		return result;
	}	
}