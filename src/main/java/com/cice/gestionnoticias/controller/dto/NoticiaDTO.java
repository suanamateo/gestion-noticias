package com.cice.gestionnoticias.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
//Poojo
public class NoticiaDTO {

    private Long id;
    private String titulo;
    private String cuerpo;
    private String autor;
    private String fecha;

}
