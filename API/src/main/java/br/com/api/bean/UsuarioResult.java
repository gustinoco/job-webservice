package br.com.api.bean;

import java.util.List;

public class UsuarioResult {
			List<Usuario> usuarios;
			TransactionStatus status;
			public List<Usuario> getUsuarios() {
				return usuarios;
			}
			public void setUsuarios(List<Usuario> usuarios) {
				this.usuarios = usuarios;
			}
			public TransactionStatus getStatus() {
				return status;
			}
			public void setStatus(TransactionStatus status) {
				this.status = status;
			}
		
			
			
	}


