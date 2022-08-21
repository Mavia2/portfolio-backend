package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

    // @Query("SELECT e FROM Educacion e WHERE e.id_user=?1")
    // List<Educacion> findAllbyIdUser(Long idUser);
}
