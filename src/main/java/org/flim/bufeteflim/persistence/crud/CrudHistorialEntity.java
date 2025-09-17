package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudHistorialEntity extends CrudRepository<HistorialEntity, Long> {
    
}
