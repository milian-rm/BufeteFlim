package org.flim.bufeteflim.persistence.crud;

import org.flim.bufeteflim.persistence.entity.DocumentoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudDocumentoEntity extends CrudRepository<DocumentoEntity, Long> {
    DocumentoEntity findFirstByNombre(String nombre);
}
