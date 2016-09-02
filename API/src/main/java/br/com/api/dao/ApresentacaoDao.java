package br.com.api.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import br.com.api.bean.Apresentacao;
import br.com.api.bean.Usuario;

public class ApresentacaoDao extends BaseDao {

	public ApresentacaoDao() throws NamingException {	
	}

	public Apresentacao getList(String id) throws Exception {		
		PreparedStatement s = null;
		ResultSet result = null;
		Apresentacao apresentacao = new Apresentacao();
		try {
			String sql = "select id, titulo, descricao,imagem from apresentacao where id = ?";				
			s = prepareStatement(sql);	
			s.setString(1, id);
			result = s.executeQuery();
			while (result.next()) {
				int index = 1;							
				apresentacao.setId(result.getString(index++));
				apresentacao.setTitulo(result.getString(index++));
				apresentacao.setDescricao(result.getString(index++));
				apresentacao.setImagem(result.getString(index++));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;		
		} finally {
			close(s);
			close(result);
		}
		return apresentacao;
	}		

}
