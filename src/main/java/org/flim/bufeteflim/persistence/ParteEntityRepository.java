package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.ModParteDto;
import org.flim.bufeteflim.dominio.dto.ParteDto;
import org.flim.bufeteflim.dominio.exception.ParteNoExisteException;
import org.flim.bufeteflim.dominio.exception.ParteYaExisteException;
import org.flim.bufeteflim.dominio.repository.ParteRepository;
import org.flim.bufeteflim.persistence.crud.CrudParteEntity;
import org.flim.bufeteflim.persistence.entity.ParteEntity;
import org.flim.bufeteflim.persistence.mapper.ParteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParteEntityRepository implements ParteRepository {
    private final CrudParteEntity crudParteEntity;
    private  final ParteMapper parteMapper;

    public ParteEntityRepository(CrudParteEntity crudParteEntity, ParteMapper parteMapper) {
        this.crudParteEntity = crudParteEntity;
        this.parteMapper = parteMapper;
    }


    @Override
    public List<ParteDto> obtenerTodo() {
        return this.parteMapper.toDto(this.crudParteEntity.findAll());
    }

    @Override
    public ParteDto buscarPorCodigo(Long codigo) {
        return this.parteMapper.toDto(this.crudParteEntity.findById(codigo).orElse(null));
    }

    @Override
    public ParteDto guardarParte(ParteDto parteDto) {
        if(this.crudParteEntity.findFirstByNombre(parteDto.name()) != null){
            throw new ParteYaExisteException(parteDto.name());
        }

        //Creamos un objeto ParteEntity
        ParteEntity parte = new ParteEntity();
        //Convertimos a ParteEntity el objeto ParteDto
        parte = this.parteMapper.toEntity(parteDto);
        //guardarlo en la base de datos con JPA
        this.crudParteEntity.save(parte);
        //retornarlo como ParteDto
        return this.parteMapper.toDto(parte);
    }

    @Override
    public ParteDto modificarParte(Long codigo, ModParteDto modParte){
        ParteEntity parte = this.crudParteEntity.findById(codigo).orElse(null);
        //Excepciones
        if(parte == null){
            throw new ParteNoExisteException(codigo);
        }
        this.parteMapper.modificarEntityFromDto(modParte, parte);

        return this.parteMapper.toDto(this.crudParteEntity.save(parte));
    }

    @Override
    public void eliminarParte (Long codigo){
        ParteEntity parte = this.crudParteEntity.findById(codigo).orElse(null);

        if(parte == null){
            throw new ParteNoExisteException(codigo);
        }else{
            //this.crudParteEntity.delete(parte);
            this.crudParteEntity.deleteById(codigo);
        }
    }
}
