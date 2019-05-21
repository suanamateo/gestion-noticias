package com.cice.gestionnoticias.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) // Nos permite Concatenar métodos SET.-
@Entity
@Table(name = "noticias")
public class NoticiaEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String cuerpo;
    private String autor;
    private String fecha;

}
