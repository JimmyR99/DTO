package com.generation.gestionapp.service;

import com.generation.gestionapp.dto.DepartamentoDTO;
import com.generation.gestionapp.dto.DepartamentoEditarDTO;
import com.generation.gestionapp.model.Departamento;

import java.util.List;

public interface DepartamentoService {

    List<Departamento> listarDepartamentos();

    DepartamentoDTO guardarDepartamento(DepartamentoDTO departamentoParaGuardar);

    void eliminarDepartamentoPorId(Long id);

    DepartamentoEditarDTO editarDepartamentoPorId(DepartamentoEditarDTO departamentoParaEditar, Long id);
}
