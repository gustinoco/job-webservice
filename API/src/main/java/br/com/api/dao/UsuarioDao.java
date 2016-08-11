package br.com.api.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import br.com.api.bean.Usuario;

public class UsuarioDao extends BaseDao {

	public UsuarioDao() throws NamingException {
	
	}

	public void insert(Usuario usuario) throws Exception {
		final String sql = "insert into usuario (usuario, nota)"
				+ "values(?, ?)";

		PreparedStatement s = null;
		try {
			s = prepareStatement(sql);
			int index = 1;
			s.setString(index++, usuario.getNome());
			s.setFloat(index++, usuario.getNota());					
			s.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			close(s);
		}
	}

	public List<Usuario> getList() throws Exception {
		List<Usuario> list = new ArrayList<>();
		PreparedStatement s = null;
		ResultSet result = null;
		try {
			String sql = "select id, usuario, nota from usuario";				
			s = prepareStatement(sql);
			result = s.executeQuery();
			while (result.next()) {
				int index = 1;
				Usuario usuario = new Usuario();			
				usuario.setId(result.getString(index++));
				usuario.setNome(result.getString(index++));
				usuario.setNota(result.getFloat(index++));						
				list.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(s);
			close(result);
		}
		return list;
	}		

}
