package com.devsuperior.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity//mapear para o JPA
@Table(name = "tb_order")//especifirar o nome da tabela
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//informar a chave primaria do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotação de auto-increment
    private Long id;

    //mostrar a data no formato ISO 8601
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne//muitos para um
    @JoinColumn(name = "client_id")//indicar a chave estrangeira da entidade User
    private User client;//associação

    //construtor vazio
    public Order () {
    }

    //construtor com todos os atributos
    public Order(Long id, Instant moment, User user) {
        this.id = id;
        this.moment = moment;
        this.client = user;
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

    public User getUser() {
        return client;
    }

    public void setUser(User user) {
        this.client = user;
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
