package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudAbogadoEntity extends CrudRepository<AbogadoEntity, Long> {

    AbogadoEntity findFirstByNombre(String nombre);
}