package br.edu.ifg.proi.modelo;

public class Endereco {
	
	private long id;
	private String logradouro;
	private String CEP;
	private String cidade;
	private String bairro;
	private String UF;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logadouro) {
		this.logradouro = logadouro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	@Override
	public String toString() {
		return getLogradouro() +", " + getBairro()+", " + getCidade() + " - " + getUF() +"CEP:" + getCEP();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
