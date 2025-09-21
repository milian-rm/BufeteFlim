package org.flim.bufeteflim.persistence;

import org.flim.bufeteflim.dominio.dto.InsumoDto;
import org.flim.bufeteflim.dominio.dto.ModInsumoDto;
import org.flim.bufeteflim.dominio.exception.InsumoNoExisteException;
import org.flim.bufeteflim.dominio.exception.InsumoYaExisteException;
import org.flim.bufeteflim.dominio.repository.InsumoRepository;
import org.flim.bufeteflim.persistence.crud.CrudInsumoEntity;
import org.flim.bufeteflim.persistence.entity.InsumoEntity;
import org.flim.bufeteflim.persistence.mapper.InsumoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InsumoEntityRepository implements InsumoRepository{
    private final CrudInsumoEntity crudInsumoEntity;
    private final InsumoMapper insumoMapper;

    public InsumoEntityRepository(CrudInsumoEntity crudInsumoEntity, InsumoMapper insumoMapper) {
        this.crudInsumoEntity = crudInsumoEntity;
        this.insumoMapper = insumoMapper;
    }

    @Override
    public List<InsumoDto> obtenerTodo() {
        return this.insumoMapper.toDto(this.crudInsumoEntity.findAll());
    }

    @Override
    public InsumoDto buscarPorCodigo(Long codeSupply) {
        return this.insumoMapper.toDto(this.crudInsumoEntity.findById(codeSupply).orElse(null));
    }

    @Override
    public InsumoDto guardarInsumo(InsumoDto insumoDto) {
        if(this.crudInsumoEntity.findFirstByCodigo(insumoDto.codeSupply()) != null) {
            throw new InsumoYaExisteException(insumoDto.codeSupply());
        }

        InsumoEntity insumo = new InsumoEntity();

        insumo = this.insumoMapper.toEntity(insumoDto);

        this.crudInsumoEntity.save(insumo);

        return this.insumoMapper.toDto(insumo);
    }

    @Override
    public InsumoDto modificarInsumo(Long codeSupply, ModInsumoDto modInsumoDto){
        InsumoEntity insumo = this.crudInsumoEntity.findById(codeSupply).orElse(null);

        if(insumo == null){
            throw new InsumoNoExisteException(codeSupply);
        }
        this.insumoMapper.modificarEntityFromDto(modInsumoDto, insumo);

        return this.insumoMapper.toDto(this.crudInsumoEntity.save(insumo));
    }

    @Override
    public void eliminarInsumo(Long codeSupply) {
        InsumoEntity insumo = this.crudInsumoEntity.findById(codeSupply).orElse(null);

        if(insumo == null){
            throw new InsumoNoExisteException(codeSupply);
        }else{
            this.crudInsumoEntity.deleteById(codeSupply);
        }
    }
}
