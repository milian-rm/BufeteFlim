package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudGestionEntity extends CrudRepository<GestionEntity, Long> {
    List<GestionEntity> findByEstado(String estado);
}
