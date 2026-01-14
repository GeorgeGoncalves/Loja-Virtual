package com.example.loja.dto;

public class ClienteDTO {
	private Long id;
    private String nome;
    private String email;
    private String endereco;
    private String cpf;
    private String telefone;

    // Construtor vazio
    public ClienteDTO() {
    }

    // construtor
    public ClienteDTO(Long id, String nome, String email, String endereco, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
    }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}