package com.cice.gestionnoticias.controller;

import com.cice.gestionnoticias.controller.dto.NoticiaDTO;
import com.cice.gestionnoticias.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase resource de Noticias.
 * Vamos a definir todos los métodos de un CRUD (CRUD = 4 métodos de manipulación de
 * una base de datos - funcionalidad básica de cualquier aplicación = crear recursos,
 * leer recursos, actualizar recursos o eliminar recursos.-
 */
@RestController
public class NoticiasResource {

    //@Autowired - beans - contrato con la INTERFAZ
    @Autowired
    NoticiasService noticiasService;

    /**
     * Este método sirve para crear un recurso nuevo
     * Dado un modelo noticia, persistiremos en la DB(BBDD) y devolveremos como
     * respuesta el mismo objeto creado junto a su identificador único.
     *
     * @param noticia DTO con la información de la noticia para dar de alta en el
     *                sitema
     * @return ResponseEntity<NoticiaDTO>
     */

    @RequestMapping(path = "/noticias", method = RequestMethod.POST)
    public ResponseEntity<NoticiaDTO> crearNoticias(@RequestBody NoticiaDTO noticia){
        ResponseEntity<NoticiaDTO> response = null;
        if(validateNoticia(noticia)){
            // La noticia es valida
            NoticiaDTO noticiaDTO = noticiasService.crearNoticia(noticia);
            response = ResponseEntity.ok(noticiaDTO);
        } else {
            response = ResponseEntity.badRequest().body(noticia);
        }
        return response;
    }

    /**
     * Método para recuperar un recurso en base a el Id solicitado
     *
     * @return id
     * return
     */
    //{id} - es un place holder.
    @RequestMapping(path = "/noticias/{id}", method = RequestMethod.GET)
    public ResponseEntity<NoticiaDTO> getNoticiasById(@PathVariable(name = "id") Long id){
        ResponseEntity<NoticiaDTO> response = null;

        NoticiaDTO noticiaDTO = noticiasService.buscarNoticiaById(id);
        if(noticiaDTO != null) {
            response = ResponseEntity.ok(noticiaDTO);
        } else {
            response = ResponseEntity.notFound().build();
        }

        return response;
    }

    @RequestMapping(path = "/noticias", method = RequestMethod.GET)
    public ResponseEntity<List<NoticiaDTO>> getAllNoticias(){
        ResponseEntity<List<NoticiaDTO>> response = null;

        List<NoticiaDTO> allNoticias = noticiasService.getAllNoticias();
        response = ResponseEntity.ok(allNoticias);

        return response;
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(path = "/noticias/{id}", method = RequestMethod.DELETE)
    public ResponseEntity eliminarNoticiaById(@PathVariable(name = "id") Long id){
        noticiasService.eliminarNoticiaById(id);
        return ResponseEntity.accepted().build();
    }

    /**
     * Método que actualizara datos de una noticia dado su Id
     *
     * @param id
     * @param noticiaDTO
     * @return
     */
    @RequestMapping(path = "/noticias/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<NoticiaDTO> actualizarNoticiaById(@PathVariable(name = "id") Long id, @RequestBody NoticiaDTO noticiaDTO){
        ResponseEntity<NoticiaDTO> responseDTO = null;

        NoticiaDTO noticiaActualizada = noticiasService.actualizeNoticeById(id, noticiaDTO);
        responseDTO = ResponseEntity.ok(noticiaActualizada);

        return responseDTO;
    }

    @RequestMapping(path = "/noticias", method = RequestMethod.PUT)
    public ResponseEntity<NoticiaDTO> actualizarNoticia(@RequestBody NoticiaDTO noticia){
        ResponseEntity<NoticiaDTO> responseDTO = null;
        NoticiaDTO noticiaDTO = noticiasService.actualizarNoticia(noticia);
        if(noticiaDTO != null){
            responseDTO = ResponseEntity.ok(noticiaDTO);
        } else {
            responseDTO = ResponseEntity.badRequest().build();
        }
        return responseDTO;
    }

    // Método validador de noticias - 2 cosas:

    private boolean validateNoticia (NoticiaDTO noticia) {

        // Condicional Ternario

        // | = (o) OR de un campo o parte del condicional
        // || = (o) OR de los 2 campos del condicional
        // (con q se cumpla la 1ª opción valdría)
        // pero comprobará la 2ª opción y sería la forma de comprobar más válida
        // && = (y) Ampersand, para q las 2 opciones se cumplan (ambas opciones)

        return (noticia.getTitulo().isEmpty() || noticia.getCuerpo().isEmpty()) ? false : true;

        }
    }

