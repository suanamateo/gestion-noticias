package com.cice.gestionnoticias.service;

import com.cice.gestionnoticias.controller.dto.NoticiaDTO;

import java.util.List;

/**
 * Interfaz que contendrá los métodos de la lógica de negocio para el
 * resoure Noticias
 */
public interface NoticiasService {
    /**
     * Método que crea una nueva noticia en base a los datos recibidos
     * desde el resource
     *
     * @param noticia para almacenar en base de datos
     * @return NoticiaDTO con el ID único
     */
    NoticiaDTO crearNoticia (NoticiaDTO noticia);

    /**
     * Método que devolverá un objeto NoticiaDTO siempre que se encuentre el Id en
     * la DB(BBDD)
     *
     * @param id de la noticia
     * @return NoticiaDTO
     */

    NoticiaDTO buscarNoticiaById(Long id);

/**
 * Método que devuelve una lista oon todas las noticias disponibles en DB (BBDD)
 * @return List<NoticiaDTO>
 */

    List<NoticiaDTO> getAllNoticias();

    /**
     * Método que elimina una noticia del recurso en base a un Id
     * @param id
     * @return
     */
    void eliminarNoticiaById (Long id);

    /**
     * Método para actualizar una noticia en base a los datos reicibidos en base
     * a un Id de identificación
     * @param id
     * @param noticiaDTO
     * @return
     */

    NoticiaDTO actualizarNoticiaById(Long id, NoticiaDTO noticiaDTO);

    /**
     * Metodo que actualizara una noticia de manera independiente en DB
     * @param noticiaDTO
     * @return
     */
    NoticiaDTO actualizeNoticeById(Long id, NoticiaDTO noticiaDTO);

    /**
     * Metodo que actualizara una noticia de manera independiente en DB
     * @param noticiaDTO
     * @return
     */
    NoticiaDTO actualizarNoticia(NoticiaDTO noticiaDTO);
}