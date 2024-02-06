package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.TareaDTO;
import com.generation.gestionapp.dto.TareaEditarDTO;
import com.generation.gestionapp.model.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> obtenerListaTareas();

    TareaDTO guardarTarea(TareaDTO tareaParaGuardar);

    void eliminarTareaPorId(Long id);

    TareaEditarDTO editarTareaPorId(TareaEditarDTO tareaParaEditar, Long id);



}
