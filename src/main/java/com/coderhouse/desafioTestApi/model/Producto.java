package com.coderhouse.desafioTestApi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "items")
public class Producto {

    @Id
    private Integer id;
    private String nombre;
    private String categoria;
    private Integer stock;

}
