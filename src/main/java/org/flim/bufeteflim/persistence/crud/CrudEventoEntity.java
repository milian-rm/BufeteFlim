package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.EventoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudEventoEntity extends CrudRepository<EventoEntity, Long> {
    EventoEntity findFirstByCodigo(Long codeDetail);
}
