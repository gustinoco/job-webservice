package br.com.api.bean;

public class Denuncia {


    private String id;
    private String tipo;
    private String n_curtir;
    private String titulo;
    private String img;
    private String id_denunciante;
    private String endereco;
    private String descricao;
    private String data;
    private String latitude;
    private String longitude;    
    private String status;
	public String getId() {
		return id;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getN_curtir() {
		return n_curtir;
	}
	public void setN_curtir(String n_curtir) {
		this.n_curtir = n_curtir;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getId_denunciante() {
		return id_denunciante;
	}
	public void setId_denunciante(String id_denunciante) {
		this.id_denunciante = id_denunciante;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
 

}
