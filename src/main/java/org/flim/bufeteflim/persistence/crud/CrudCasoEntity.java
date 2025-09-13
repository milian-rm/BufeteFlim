package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudCasoEntity extends CrudRepository<CasoEntity, Long> {
    CasoEntity findFirstByTitulo(String titulo);
}
