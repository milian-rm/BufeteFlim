package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCasoEntity extends CrudRepository<CasoEntity, Long> {
    CasoEntity findFirstByTitulo(String titulo);
    List<CasoEntity> findByEstado(String estado);
}
