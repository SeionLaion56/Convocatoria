package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    
    boolean existsByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Docente d WHERE d.numeroDocumento = :numeroDocumento AND d.tipoDocumento <> :tipoDocumento")
    boolean existsByNumeroDocumentoAndTipoDocumentoNot(@Param("numeroDocumento") String numeroDocumento, @Param("tipoDocumento") String tipoDocumento);

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Docente d WHERE d.tipoDocumento = :tipoDocumento AND d.numeroDocumento <> :numeroDocumento")
    boolean existsByTipoDocumentoAndNumeroDocumentoNot(@Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumento") String numeroDocumento);
}
