package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.DetalleCasoDto;
import org.flim.bufeteflim.dominio.dto.ModDetalleCasoDto;
import org.flim.bufeteflim.dominio.exception.DetalleCasoNoExisteException;
import org.flim.bufeteflim.dominio.exception.DetalleCasoYaExisteException;
import org.flim.bufeteflim.dominio.repository.DetalleCasoRepository;
import org.flim.bufeteflim.persistence.crud.CrudDetalleCasoEntity;
import org.flim.bufeteflim.persistence.entity.DetalleCasoEntity;
import org.flim.bufeteflim.persistence.mapper.DetalleCasoMapper;

import java.util.List;

public class DetalleCasoEntityRepository implements DetalleCasoRepository {

    private final CrudDetalleCasoEntity crudDetalleCasoEntity;
    private final DetalleCasoMapper detalleCasoMapper;

    public DetalleCasoEntityRepository
            (CrudDetalleCasoEntity crudDetalleCasoEntity, DetalleCasoMapper detalleCasoMapper){
        this.crudDetalleCasoEntity = crudDetalleCasoEntity;
        this.detalleCasoMapper = detalleCasoMapper;
    }

    @Override
    public List<DetalleCasoDto> obtenertodo() {
        return this.detalleCasoMapper.toDto(this.crudDetalleCasoEntity.findAll());
    }

    @Override
    public DetalleCasoDto buscarPorCodigo(Long codeDetail) {
        return this.detalleCasoMapper.toDto(this.crudDetalleCasoEntity.findById(codeDetail).orElse(null));
    }

    @Override
    public DetalleCasoDto guardarDetalleCaso(DetalleCasoDto detalleCasoDto) {
        if (this.crudDetalleCasoEntity.findFirstByCodigo(detalleCasoDto.codeDetail()) != null){
            throw new DetalleCasoYaExisteException(detalleCasoDto.codeDetail());
        }
        DetalleCasoEntity detalleCaso = new DetalleCasoEntity();

        detalleCaso = this.detalleCasoMapper.toEntity(detalleCasoDto);

        this.crudDetalleCasoEntity.save(detalleCaso);

        return  this.detalleCasoMapper.toDto(detalleCaso);
    }

    @Override
    public DetalleCasoDto modificarDetalleCaso(Long codeDetail, ModDetalleCasoDto modDetalleCasoDto) {
        DetalleCasoEntity detallecaso = this.crudDetalleCasoEntity.findById(codeDetail).orElse(null);

        if (detallecaso == null){
            throw new DetalleCasoNoExisteException(codeDetail);
        }
        this.detalleCasoMapper.modificarEntityFromDto(modDetalleCasoDto, detallecaso);

        return this.detalleCasoMapper.toDto(this.crudDetalleCasoEntity.save(detallecaso));
    }

    @Override
    public void eliminarDetalleCaso(Long codeDetail) {
        DetalleCasoEntity detalleCaso = this.crudDetalleCasoEntity.findById(codeDetail).orElse(null);

        if (detalleCaso == null) {
            throw new DetalleCasoNoExisteException(codeDetail);
        }else{
            this.crudDetalleCasoEntity.deleteById(codeDetail);
        }
    }
}
