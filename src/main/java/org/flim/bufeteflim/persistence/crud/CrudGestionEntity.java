package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudGestionEntity extends CrudRepository<GestionEntity, Long> {
    GestionEntity findFirstByEstado(String estado);
}
