package com.springboot.todoWebApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    @NotEmpty(message = "Enter to-do.")
    private String value;

    public ToDo() {
    }

    public ToDo(String value) {
        this.value = value;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
