package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.CasoDto;
import org.flim.bufeteflim.dominio.dto.ModCasoDto;
import org.flim.bufeteflim.dominio.repository.CasoRepository;
import org.flim.bufeteflim.persistence.crud.CrudCasoEntity;
import org.flim.bufeteflim.persistence.entity.CasoEntity;
import org.flim.bufeteflim.persistence.mapper.CasoMapper;

import java.util.List;

public class CasoEntityRepository implements CasoRepository {

    private final CrudCasoEntity crudCasoEntity;
    private final CasoMapper casoMapper;

    public CasoEntityRepository(CrudCasoEntity crudCasoEntity, CasoMapper casoMapper){
        this.crudCasoEntity = crudCasoEntity;
        this.casoMapper = casoMapper;
    }

    @Override
    public List<CasoDto> obtenerTodo() {
        return this.casoMapper.toDto(this.crudCasoEntity.findAll());
    }

    @Override
    public CasoDto buscarPorId(Long id) {
        return this.casoMapper.toDto(this.crudCasoEntity.findById(id).orElse(null));
    }

    @Override
    public CasoDto guardarCaso(CasoDto casoDto) {
        if (this.crudCasoEntity.findFirstByTitulo(casoDto.title()) != null){
            throw new CasoYaExisteExeption(casoDto.title());
        }

        //Creamos el objeto CasoEntity
        CasoEntity caso = new CasoEntity();
        //Convertimos a CasoEntity el objeto CasoDto
        caso = this.casoMapper.toEntity(casoDto);
        //Guardamos en al base de datos con JPA
        this.crudCasoEntity.save(caso);
        //Retornamos como CasoDto
        return this.casoMapper.toDto(caso);
    }

    @Override
    public CasoDto modificarCaso(Long id, ModCasoDto modCaso) {
        CasoEntity caso = this.crudCasoEntity.findById(id).orElse(null);
        //Exepciones
        if (caso == null){
            throw new CasoNoExisteExeption(id);
        }
        this.casoMapper.modificarEntityFromDto(modCaso, caso);

        return this.casoMapper.toDto(this.crudCasoEntity.save(caso));
    }

    @Override
    public void eliminarCaso(Long id) {
        CasoEntity caso = this.crudCasoEntity.findById(id).orElse(null);

        if(caso == null){
            throw new CasoNoExisteExeption(id);
        }else{
            this.crudCasoEntity.deleteById(id);
        }

    }
}
