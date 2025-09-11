package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.ParteEntity;

public interface CrudParteEntity {
    ParteEntity findFirstByNombre(String nombre);
}
