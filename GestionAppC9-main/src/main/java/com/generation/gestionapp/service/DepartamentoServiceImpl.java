package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.DepartamentoDTO;
import com.generation.gestionapp.dto.DepartamentoEditarDTO;
import com.generation.gestionapp.model.Departamento;
import com.generation.gestionapp.model.Departamento ;
import com.generation.gestionapp.repository.DepartamentoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public DepartamentoDTO guardarDepartamento(DepartamentoDTO departamentoParaGuardar) {


        //Boolean departamentoExiste = departamentoRepository.existsById(departamentoParaGuardar.getDepartamentoId());

        if (departamentoParaGuardar.getNombreDepartamento() != null) {
            Departamento departamentoNuevo = new Departamento();
            departamentoNuevo.setNombreDepartamento(departamentoParaGuardar.getNombreDepartamento());
            departamentoRepository.save(departamentoNuevo);
            return departamentoParaGuardar;
        } else  {
            return null;
        }

    }

    @Override
    public void eliminarDepartamentoPorId(Long id) {
        departamentoRepository.deleteById(id);
    }

    @Override
    public DepartamentoEditarDTO editarDepartamentoPorId(DepartamentoEditarDTO  departamentoParaEditar, Long id) {

        Boolean departamentoExiste = departamentoRepository.existsById(id);
        Departamento departamentoSeleccionado = departamentoRepository.findById(id).get();

        if (departamentoExiste && departamentoParaEditar != null) {
            departamentoSeleccionado.setNombreDepartamento(departamentoParaEditar.getNombreDepartamento());
            departamentoRepository.save(departamentoSeleccionado);
            return departamentoParaEditar;
        }
        else {
            return null;
        }
    }
}
