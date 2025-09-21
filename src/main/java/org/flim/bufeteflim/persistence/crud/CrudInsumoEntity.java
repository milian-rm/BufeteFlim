package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.InsumoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudInsumoEntity extends CrudRepository<InsumoEntity, Long> {
    InsumoEntity findFirstByCodigo(Long codeSupply);
}
