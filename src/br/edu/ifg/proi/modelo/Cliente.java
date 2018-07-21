package br.edu.ifg.proi.modelo;

public class Cliente {
	
	private Long id;
	private String cpf;
	private String nome;
	private String contato;
	private String email;
	private String usuario;
	private String senha;
	//private List<Comprovante>
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String email, String contato, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cpf " + getCpf()
				+ "Nome " + getNome() + "Contato " + getContato()
				+ "Email " + getEmail() + "Usuario "
				+ getUsuario() + "Senha " + getSenha();
	}
	
	
	
	
	
	
}
