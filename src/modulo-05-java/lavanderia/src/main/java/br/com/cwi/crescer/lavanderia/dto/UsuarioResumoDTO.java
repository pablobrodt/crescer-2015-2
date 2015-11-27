package br.com.cwi.crescer.lavanderia.dto;

import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Autorizacao;
import br.com.cwi.crescer.lavanderia.domain.Usuario.SituacaoUsuario;

public class UsuarioResumoDTO {
	
	private String userName;
	private List<Autorizacao> autorizacoes;
	private SituacaoUsuario enabled;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
