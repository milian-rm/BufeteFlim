package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.AbogadoDto;
import org.flim.bufeteflim.dominio.dto.ModAbogadoDto;
import org.flim.bufeteflim.dominio.exception.AbogadoNoExisteException;
import org.flim.bufeteflim.dominio.exception.AbogadoYaExisteException;
import org.flim.bufeteflim.dominio.repository.AbogadoRepository;
import org.flim.bufeteflim.persistence.crud.CrudAbogadoEntity;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.flim.bufeteflim.persistence.mapper.AbogadoMapper;

import java.util.List;

public class AbogadoEntityRepository implements AbogadoRepository {
    private final CrudAbogadoEntity crudAbogadoEntity;
    private final AbogadoMapper abogadoMapper;

    public AbogadoEntityRepository(CrudAbogadoEntity crudAbogadoEntity, AbogadoMapper abogadoMapper){
        this.crudAbogadoEntity = crudAbogadoEntity;
        this.abogadoMapper = abogadoMapper;
    }


    @Override
    public List<AbogadoDto> obtenerTodo() {
        return this.abogadoMapper.toDto(this.crudAbogadoEntity.findAll());
    }

    @Override
    public AbogadoDto buscarPorId(Long id) {
        return this.abogadoMapper.toDto(this.crudAbogadoEntity.findById(id).orElse(null));
    }

    //Falta AbogadoYaExisteExeption
    @Override
    public AbogadoDto guardarAbogado(AbogadoDto abogadoDto) {
        if (this.crudAbogadoEntity.findFirstByNombre(abogadoDto.name()) != null){
            throw new AbogadoYaExisteException(abogadoDto.name());
        }

        //Creamos un objeto AbogadoEntity
        AbogadoEntity abogado = new AbogadoEntity();
        //Convertimos a AbogadoEntity el objeto AbogadoDto
        abogado = this.abogadoMapper.toEntity(abogadoDto);
        //Guardarlo en la base de datos con JPA
        this.crudAbogadoEntity.save(abogado);
        //Retornamos como AbogadoDto
        return this.abogadoMapper.toDto(abogado);
    }

    //Falta AbogadoNoExisteExeption
    @Override
    public AbogadoDto modificarAbogado(Long id, ModAbogadoDto modAbogado) {
        AbogadoEntity abogado = this.crudAbogadoEntity.findById(id).orElse(null);

        //Exepciones
        if (abogado == null){
            throw new AbogadoNoExisteException(id);
        }
        this.abogadoMapper.modificarEntityFromDto(modAbogado, abogado);

        return this.abogadoMapper.toDto(this.crudAbogadoEntity.save(abogado));
    }

    //Falta AbogadoNoExisteExeption
    @Override
    public void eliminarAbogado(Long id) {
        AbogadoEntity abogado = this.crudAbogadoEntity.findById(id).orElse(null);

        if (abogado == null){
            throw new AbogadoNoExisteException(id);
        }else {
            this.crudAbogadoEntity.deleteById(id);
        }
    }
}
