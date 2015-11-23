package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade")
public class Cidade {
	
	@Id
	@Column(name = "IDCidade")
	private Long idCidade;
	
	@Column(name = "Nome", length = 50)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "UF", length = 2)
	@Basic(optional = false)
	private String uf;
	
	public Long getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public boolean equals(Object obj){
		Cidade cidadeComparada = (Cidade)obj;
		
		boolean mesmoId = this.idCidade == cidadeComparada.getIdCidade();
		boolean mesmoNome = this.nome == cidadeComparada.getNome();
		boolean mesmaUF = this.uf == cidadeComparada.getUf();
		
		return (mesmoId && mesmoNome && mesmaUF);
	}
	
}
