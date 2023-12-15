package com.softwaredev.epets_h2.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPedido;
    private String nomeCliente;
    private LocalDateTime dataCompra;
    private String formaPagamento;
    private int quantidadeDoProduto;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<Produto> carrinho;


    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public UUID getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQuantidadeDoProduto() {
        return quantidadeDoProduto;
    }

    public void setQuantidadeDoProduto(int quantidadeDoProduto) {
        this.quantidadeDoProduto = quantidadeDoProduto;
    }
}
