package br.com.cwi.crescer.lavanderia.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Usuario {
	
	@Id
	@Column(name = "USERName", length = 100)
	private String userName;
	
	@Column(name = "Password", length = 32)
	@Basic(optional=false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Autorizacao> autorizacoes;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Enabled", length = 1)
	@Basic(optional=false)
	private SituacaoUsuario enabled;
	
	public static enum SituacaoUsuario{
		ATIVO, INATIVO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}
	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
	public SituacaoUsuario getEnabled() {
		return enabled;
	}
	
	public void setEnabled(SituacaoUsuario enabled) {
		this.enabled = enabled;
	}
}
