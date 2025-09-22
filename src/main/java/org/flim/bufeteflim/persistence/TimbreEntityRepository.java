package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.ModTimbreDto;
import org.flim.bufeteflim.dominio.dto.TimbreDto;
import org.flim.bufeteflim.dominio.exception.TimbreNoExisteExeption;
import org.flim.bufeteflim.dominio.exception.TimbreYaExisteException;
import org.flim.bufeteflim.dominio.repository.TimbreRepository;
import org.flim.bufeteflim.persistence.crud.CrudTimbreEntity;
import org.flim.bufeteflim.persistence.entity.TimbreEntity;
import org.flim.bufeteflim.persistence.mapper.TimbreMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimbreEntityRepository implements TimbreRepository {

    private final CrudTimbreEntity crudTimbreEntity;
    private final TimbreMapper timbreMapper;

    public TimbreEntityRepository(CrudTimbreEntity crudTimbreEntity, TimbreMapper timbreMapper){
        this.crudTimbreEntity = crudTimbreEntity;
        this.timbreMapper = timbreMapper;
    }

    @Override
    public List<TimbreDto> obtenerTodo() {
        return this.timbreMapper.toDto(this.crudTimbreEntity.findAll());
    }

    @Override
    public TimbreDto buscarPorNo(Long noTimbre) {
        return this.timbreMapper.toDto(this.crudTimbreEntity.findById(noTimbre).orElse(null));
    }

    @Override
    public TimbreDto guardarTimbre(TimbreDto timbreDto) {

        /*
        no podes validad una llave primaria auto incrementable pq siempre va a mandar en postman como nula
        if (this.crudTimbreEntity.findFirstByNoTimbre(timbreDto.noRing()) != null){
            throw new TimbreYaExisteException(timbreDto.noRing());
        }
        */
        //Creamos el objeto TimbreEntity
        TimbreEntity timbre = new TimbreEntity();
        //Convertimos a TimbreEntity el objeto TimbreDto
        timbre = this.timbreMapper.toEntity(timbreDto);
        //Guardamos en la base de datos con JPA
        this.crudTimbreEntity.save(timbre);
        //Retornamos como CasoDto
        return this.timbreMapper.toDto(timbre);
    }

    @Override
    public TimbreDto modificarTimbre(Long noTimbre, ModTimbreDto modTimbreDto) {
        TimbreEntity timbre = this.crudTimbreEntity.findById(noTimbre).orElse(null);
        //Exepciones
        if (timbre == null){
            throw new TimbreNoExisteExeption(noTimbre);
        }
        this.timbreMapper.modificarEntityFromDto(modTimbreDto, timbre);

        return this.timbreMapper.toDto(this.crudTimbreEntity.save(timbre));
    }

    @Override
    public void eliminarTimbre(Long noTimbre) {
        TimbreEntity timbre = this.crudTimbreEntity.findById(noTimbre).orElse(null);

        if (timbre == null){
            throw new TimbreNoExisteExeption(noTimbre);
        }else{
            this.crudTimbreEntity.deleteById(noTimbre);
        }
    }
}
