package br.edu.ifsp.dw2s6.projeto.controleacesso.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Cargo cargo;
	
	@NotNull
	private Boolean ativo;
	
	@NotNull
	@Size(max = 11)
	private String cpf;
	
	@NotNull
	@Email
	private String email;
	
	
	@NotNull
	@Size(min = 6, max = 8)
	private String password;
	
	
	
	@NotNull
	@Column(name = "data_contratacao")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataContratacao;



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



	public Cargo getCargo() {
		return cargo;
	}



	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public Boolean isAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public LocalDate getDataContratacao() {
		return dataContratacao;
	}



	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
