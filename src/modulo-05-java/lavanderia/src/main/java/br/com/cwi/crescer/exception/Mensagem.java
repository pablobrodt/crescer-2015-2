package br.com.cwi.crescer.exception;

public class Mensagem {
	
	private String texto;
	private TipoMensagem tipo;
	
	public Mensagem(String texto, TipoMensagem tipo){
		this.texto = texto;
		this.tipo = tipo;
	}
	
	public Mensagem() {
		// TODO Auto-generated constructor stub
	}

	public static enum TipoMensagem {
        SUCCESS, WARNING, ERROR
    }
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}
	
	public String getTexto(){
		return texto;
	}
	
	public TipoMensagem getTipo() {
		return tipo;
	}
}
