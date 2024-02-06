package com.generation.gestionapp.controller;

import com.generation.gestionapp.dto.DepartamentoDTO;
import com.generation.gestionapp.dto.DepartamentoEditarDTO;
import com.generation.gestionapp.dto.EmpleadoDTO;
import com.generation.gestionapp.dto.EmpleadoEditarDTO;
import com.generation.gestionapp.model.Departamento;
import com.generation.gestionapp.service.DepartamentoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departamentos")
public class DepartamentoRestController {


    private final DepartamentoServiceImpl departamentoService;


    @PostMapping("/nuevo")
    public ResponseEntity<DepartamentoDTO> guardarNuevoDepartamento(@RequestBody DepartamentoDTO departamentoParaGuardar) {
        DepartamentoDTO departamentoNuevo = departamentoService.guardarDepartamento(departamentoParaGuardar);
        return new ResponseEntity<>(departamentoNuevo, HttpStatus.CREATED);
    }


    @GetMapping("/lista")
    public ResponseEntity<List<Departamento>> buscarListaDepartamentos() {
        List<Departamento> listaDepartamentos = departamentoService.listarDepartamentos();
        return new ResponseEntity<>(listaDepartamentos, HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<DepartamentoEditarDTO> editarEmpleadoPorId(@RequestBody DepartamentoEditarDTO departamentoParaEditar,
                                                                     @RequestParam Long id) {

        DepartamentoEditarDTO departamentoEditado = departamentoService.editarDepartamentoPorId(departamentoParaEditar, id);

        return new ResponseEntity<>(departamentoEditado, HttpStatus.OK);
    }

}
