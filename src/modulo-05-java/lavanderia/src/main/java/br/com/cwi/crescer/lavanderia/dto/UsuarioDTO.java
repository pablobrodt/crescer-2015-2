package br.com.cwi.crescer.lavanderia.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.lavanderia.domain.Autorizacao;
import br.com.cwi.crescer.lavanderia.domain.Usuario.SituacaoUsuario;

public class UsuarioDTO {
	
	@NotNull
	@NotBlank
	@Length(max = 100)
	private String userName;
	
	@NotNull
	@NotBlank
	@Length(max = 30)
	private String password;
	
	@NotNull
	@NotBlank
	private List<Autorizacao> autorizacoes;
	
	@NotNull
	@NotBlank
	@Length(max = 1)
	private SituacaoUsuario enabled;
	
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
