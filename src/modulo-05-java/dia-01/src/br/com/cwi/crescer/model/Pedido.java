package br.com.cwi.crescer.model;


public class Pedido {

    private Cliente cliente;
    private Long idPedido;
    private String dsPedido;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdCliente() {
        return this.cliente.getIdCliente();
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDsPedido() {
        return dsPedido;
    }

    public void setDsPedido(String dsPedido) {
        this.dsPedido = dsPedido;
    }

}
