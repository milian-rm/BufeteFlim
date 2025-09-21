package org.flim.bufeteflim.persistence;

import java.util.List;

import org.flim.bufeteflim.dominio.dto.HistorialDto;
import org.flim.bufeteflim.dominio.dto.ModHistorialDto;
import org.flim.bufeteflim.dominio.exception.DetalleCasoNoExisteException;
import org.flim.bufeteflim.dominio.repository.HistorialRepository;
import org.flim.bufeteflim.persistence.crud.CrudHistorialEntity;
import org.flim.bufeteflim.persistence.entity.HistorialEntity;
import org.flim.bufeteflim.persistence.mapper.HistorialMapper;
import org.springframework.stereotype.Repository;

@Repository
public class HistorialEntityRepository implements HistorialRepository{

    private final CrudHistorialEntity crudHistorialEntity;
    private final HistorialMapper historialMapper;

    public HistorialEntityRepository(CrudHistorialEntity crudHistorialEntity, HistorialMapper historialMapper){
        this.crudHistorialEntity = crudHistorialEntity;
        this.historialMapper = historialMapper;
    }

    @Override
    public List<HistorialDto> obtenerTodo() {
        return this.historialMapper.toDto(this.crudHistorialEntity.findAll());
    }

    @Override
    public HistorialDto buscarPorId(Long id) {
        return this.historialMapper.toDto(this.crudHistorialEntity.findById(id).orElse(null));
    }

    @Override
    public HistorialDto guardarHistorial(HistorialDto historialDto) {
        /*
         aquí iria la excepción
         */

        HistorialEntity historial = new HistorialEntity();
        historial = this.historialMapper.toEntity(historialDto);
        this.crudHistorialEntity.save(historial);
        return this.historialMapper.toDto(historial);
    }

    @Override
    public HistorialDto modificarHistorial(Long id, ModHistorialDto modHistorial) {
        HistorialEntity historial = this.crudHistorialEntity.findById(id).orElse(null);

        if (historial == null){
            throw new DetalleCasoNoExisteException(id);
        }
         this.historialMapper.modificarEntityFromDto(modHistorial, historial);

         return this.historialMapper.toDto(this.crudHistorialEntity.save(historial));
    }

    @Override
    public void eliminarHistorial(Long id) {
        HistorialEntity historial = this.crudHistorialEntity.findById(id).orElse(null);
        if (historial == null) {
            /*
             * Aquí va la excepción
            */
        }else
            this.crudHistorialEntity.deleteById(id);
    }
    
}
