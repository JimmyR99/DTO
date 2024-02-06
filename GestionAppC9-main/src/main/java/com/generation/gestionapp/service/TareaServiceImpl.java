package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.TareaDTO;
import com.generation.gestionapp.dto.TareaEditarDTO;
import com.generation.gestionapp.model.Tarea;
import com.generation.gestionapp.repository.TareaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TareaServiceImpl implements TareaService{

    private final TareaRepository tareaRepository;

    @Override
    public List<Tarea> obtenerListaTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public TareaDTO guardarTarea(TareaDTO tareaParaGuardar) {
        //Boolean tareaExiste = tareaRepository.existsById(tareaParaGuardar.getTareaId());

        if (tareaParaGuardar.getNombreTarea() != null) {
            Tarea tareaNueva =  new Tarea();
            tareaNueva.setNombreTarea(tareaParaGuardar.getNombreTarea());
            tareaRepository.save(tareaNueva);
            return tareaParaGuardar;
        } else {
            return null;
        }
    }

    @Override
    public void eliminarTareaPorId(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public TareaEditarDTO editarTareaPorId(TareaEditarDTO tareaParaEditar, Long id) {
        Boolean tareaExiste = tareaRepository.existsById(id);

        Tarea tareaSeleccionada = tareaRepository.findById(id).get();
        if(tareaExiste && tareaParaEditar != null){
            tareaSeleccionada.setNombreTarea(tareaParaEditar.getNombreTarea());
            tareaRepository.save(tareaSeleccionada);
            return tareaParaEditar;
        }else{
            return null;
        }
        //tareaSeleccionada.setTareaId(id);

        //return tareaRepository.save(tareaSeleccionada);
    }


}
