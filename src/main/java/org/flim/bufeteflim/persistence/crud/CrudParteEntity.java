package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.ParteEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudParteEntity extends CrudRepository<ParteEntity, Long> {
    ParteEntity findFirstByDpi(String dpi);
}
