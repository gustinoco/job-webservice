package br.com.api.bean;


	public class TransactionStatus {
		    private boolean status = false;	
		    private String descricao;
		    
		    
		    public TransactionStatus() {
		    }
		
		    
		    public String getDescricao() {
				return descricao;
			}


			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}


			public boolean isStatus() {
		        return status;
		    }

		    public void setStatus(boolean status) {
		        this.status = status;
		    }

		
		}
	


