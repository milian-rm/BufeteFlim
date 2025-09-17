package org.flim.bufeteflim.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.flim.bufeteflim.persistence.entity.*;

public interface CrudDetalleCasoEntity extends CrudRepository<DetalleCasoEntity, Long> {
    DetalleCasoEntity findFirstById(Long codeDetail);
}
