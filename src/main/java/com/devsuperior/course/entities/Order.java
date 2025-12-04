package com.devsuperior.course.entities;

import com.devsuperior.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

//mapear para o JPA
@Entity
@Table(name = "tb_order")//especificar o nome da tabela
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    //informar a chave primaria do banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotação de auto-increment
    private Long id;

    //mostrar a data no formato ISO 8601
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    //enum
    private Integer orderStatus;

    //muitos para um
    @ManyToOne
    @JoinColumn(name = "client_id")//indicar a chave estrangeira da entidade User
    private User client;//associação

    //construtor vazio
    public Order () {
    }

    //construtor com todos os atributos
    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
