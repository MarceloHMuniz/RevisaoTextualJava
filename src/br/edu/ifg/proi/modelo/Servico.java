package br.edu.ifg.proi.modelo;

public class Servico {
	
	private String descricao;
	private String caracteristicas;
	private String formasCobranca;
	private float valorPg;
	private float valorLd;
	private float valorPl;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getFormasCobranca() {
		return formasCobranca;
	}
	public void setFormasCobranca(String formasCobranca) {
		this.formasCobranca = formasCobranca;
	}
	public float getValorPg() {
		return valorPg;
	}
	public void setValorPg(float valorPg) {
		this.valorPg = valorPg;
	}
	public float getValorLd() {
		return valorLd;
	}
	public void setValorLd(float valorLd) {
		this.valorLd = valorLd;
	}
	public float getValorPl() {
		return valorPl;
	}
	public void setValorPl(float valorPl) {
		this.valorPl = valorPl;
	}
	@Override
	public String toString() {
		return "Servico [getDescricao()=" + getDescricao()
				+ ", getCaracteristicas()=" + getCaracteristicas()
				+ ", getFormasCobranca()=" + getFormasCobranca()
				+ ", getValorPg()=" + getValorPg() + ", getValorLd()="
				+ getValorLd() + ", getValorPl()=" + getValorPl() + "]";
	}

	
	
	
	

}
