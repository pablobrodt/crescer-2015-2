package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Autorizacao {
	
	@Id
	private String authority;
	
	@MapsId
	@ManyToOne
	@JoinColumn(name = "username")
	private Usuario user;
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
}
