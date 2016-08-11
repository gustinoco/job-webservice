package br.com.api.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import br.com.api.bean.Denuncia;

public class DenunciaDao extends BaseDao {

	public DenunciaDao() throws NamingException {
	
	}

	public void insert(String id_usuario,String titulo,String descricao,String img) throws Exception {
		final String sql = "insert into DENUNCIA (titulo, descricao, img, id_denunciante)"
				+ "values(?, ?, ?, ?)";

		PreparedStatement s = null;
		try {
			s = prepareStatement(sql);
			int index = 1;
			s.setString(index++, titulo);
			s.setString(index++, java.net.URLDecoder.decode(descricao, "UTF-8"));
			s.setString(index++, img);
			s.setString(index++, id_usuario);
			
			s.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			close(s);
		}
	}

	public List<Denuncia> getList() throws Exception {
		List<Denuncia> list = new ArrayList<>();
		PreparedStatement s = null;
		ResultSet result = null;
		try {
			String sql = "select d.id, d.tipo, d.n_curtir, d.titulo, d.descricao, "
					+ "d.img, d.id_denunciante, d.endereco, d.data, d.latitude, "
					+ "d.longitude, d.status, l.id_usuario, l.status from denuncia d, likes l "
					+ "where d.id = l.id_denuncia or l.id_denuncia is null";
			s = prepareStatement(sql);
			result = s.executeQuery();
			while (result.next()) {
				int index = 1;
				Denuncia denuncia = new Denuncia();			
				denuncia.setId(result.getString(index++));
				denuncia.setTipo(result.getString(index++));
				denuncia.setN_curtir(result.getString(index++));
				denuncia.setTitulo(result.getString(index++));
				denuncia.setDescricao(result.getString(index++));
				denuncia.setImg(result.getString(index++));
				denuncia.setId_denunciante(result.getString(index++));
				denuncia.setEndereco(result.getString(index++));
				denuncia.setData(result.getString(index++));
				denuncia.setLatitude(result.getString(index++));
				denuncia.setLongitude(result.getString(index++));
				denuncia.setStatus(result.getString(index++));			
				list.add(denuncia);
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
	
	public List<Denuncia> getListByUser(String usuario) throws Exception {
		List<Denuncia> list = new ArrayList<>();
		PreparedStatement s = null;
		ResultSet result = null;
		try {
			String sql = "select d.id, d.tipo, d.n_curtir, d.titulo, d.descricao, "
					+ "d.img, d.id_denunciante, d.endereco, d.data, d.latitude, "
					+ "d.longitude, d.status from denuncia d where id_denunciante = ?";
			s = prepareStatement(sql);
			s.setString(1, usuario);
			result = s.executeQuery();
			while (result.next()) {
				int index = 1;
				Denuncia denuncia = new Denuncia();
				denuncia.setId(result.getString(index++));
				denuncia.setTipo(result.getString(index++));
				denuncia.setN_curtir(result.getString(index++));
				denuncia.setTitulo(result.getString(index++));
				denuncia.setDescricao(result.getString(index++));
				denuncia.setImg(result.getString(index++));
				denuncia.setId_denunciante(result.getString(index++));
				denuncia.setEndereco(result.getString(index++));
				denuncia.setData(result.getString(index++));
				denuncia.setLatitude(result.getString(index++));
				denuncia.setLongitude(result.getString(index++));
				denuncia.setStatus(result.getString(index++));				
				list.add(denuncia);
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
