package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.GestionDto;
import org.flim.bufeteflim.dominio.dto.ModGestionDto;
import org.flim.bufeteflim.dominio.exception.GestionNoExisteException;
import org.flim.bufeteflim.dominio.exception.GestionYaExisteException;
import org.flim.bufeteflim.dominio.repository.GestionRepository;
import org.flim.bufeteflim.persistence.crud.CrudGestionEntity;
import org.flim.bufeteflim.persistence.entity.GestionEntity;
import org.flim.bufeteflim.persistence.mapper.GestionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GestionEntityRepository implements GestionRepository {
    private final CrudGestionEntity crudGestionEntity;
    private final GestionMapper gestionMapper;

    public GestionEntityRepository(CrudGestionEntity crudGestionEntity, GestionMapper gestionMapper) {
        this.crudGestionEntity = crudGestionEntity;
        this.gestionMapper = gestionMapper;
    }

    @Override
    public List<GestionDto> obtenerTodo() {
        return this.gestionMapper.toDto(this.crudGestionEntity.findAll());
    }

    @Override
    public GestionDto buscarPorId(Long id) {
        return this.gestionMapper.toDto(this.crudGestionEntity.findById(id).orElse(null));
    }

    @Override
    public GestionDto buscarPorEstado(String estado) {
        return this.gestionMapper.toDto(this.crudGestionEntity.findFirstByEstado(estado));
    }

    @Override
    public GestionDto guardarGestion(GestionDto gestionDto) {
        if (this.crudGestionEntity.findById(gestionDto.idManagement()) != null){
            throw new GestionYaExisteException(gestionDto.idManagement());
        }

        GestionEntity gestion = new GestionEntity();
        gestion = this.gestionMapper.toEntity(gestionDto);
        this.crudGestionEntity.save(gestion);
        return this.gestionMapper.toDto(gestion);
    }

    @Override
    public GestionDto modificarGestion(Long id, ModGestionDto modGestionDto) {
        GestionEntity gestion = this.crudGestionEntity.findById(id).orElse(null);

        if (gestion == null){
            throw new GestionNoExisteException(id);
        }

        this.gestionMapper.modificarEntityFromDto(modGestionDto, gestion);

        return this.gestionMapper.toDto(this.crudGestionEntity.save(gestion));
    }

    @Override
    public void eliminarGestion(Long id) {
        GestionEntity gestion = this.crudGestionEntity.findById(id).orElse(null);

        if (gestion == null){
            throw new GestionNoExisteException(id);
        } else
            this.crudGestionEntity.deleteById(id);
    }
}
