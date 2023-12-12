package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Docente;
import com.example.repositories.DocenteRepository;

@Service
public class DocenteServices {

    @Autowired
    private DocenteRepository docenteRepository;

    public ArrayList<Docente> getAll() {
        return (ArrayList<Docente>) docenteRepository.findAll();
    }

    public Docente save(Docente docente) {
        if (docenteRepository.existsByTipoDocumentoAndNumeroDocumento(docente.getTipoDocumento(), docente.getNumeroDocumento())) {
            throw new RuntimeException("Ya existe un docente con el mismo tipo y número de documento.");
        }

        if (docenteRepository.existsByNumeroDocumentoAndTipoDocumentoNot(docente.getNumeroDocumento(), docente.getTipoDocumento())) {
            throw new RuntimeException("Ya existe un docente con el mismo número de documento pero diferente tipo de documento.");
        }

        return docenteRepository.save(docente);
    }

    public Docente update(Docente docente) {
        if (docenteRepository.existsById(docente.getId())) {
            return docenteRepository.save(docente);
        } else {
            throw new RuntimeException("El docente con el ID proporcionado no existe.");
        }
    }

    public void deleteById(Long id) {
        if (docenteRepository.existsById(id)) {
            docenteRepository.deleteById(id);
        } else {
            throw new RuntimeException("El docente con el ID proporcionado no existe.");
        }
    }
}

