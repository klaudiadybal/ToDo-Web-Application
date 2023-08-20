package com.springboot.todoWebApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="todo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

    public ToDo() {
    }

    public ToDo(String value) {
        this.value = value;
    }

    public ToDo(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
