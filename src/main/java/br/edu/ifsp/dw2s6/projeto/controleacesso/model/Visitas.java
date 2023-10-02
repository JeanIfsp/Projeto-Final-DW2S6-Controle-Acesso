package br.edu.ifsp.dw2s6.projeto.controleacesso.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_visitas")
public class Visitas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String nome;
	
	
	@NotNull
	@Size(max = 11)
	private String cpf;
	
	@NotNull
	@Column(name = "data_entrada")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate dataentrada;
	
	@NotNull
	@Column(name = "data_saida")
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate datasaida;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String bloco;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String apartamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "morador_id")
	private Morador morador;
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(LocalDate dataentrada) {
		this.dataentrada = dataentrada;
	}

	public LocalDate getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(LocalDate datasaida) {
		this.datasaida = datasaida;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
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
		Visitas other = (Visitas) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
