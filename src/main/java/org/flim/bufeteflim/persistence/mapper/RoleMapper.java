package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.Role;
import org.mapstruct.Named;

public class RoleMapper {
    @Named("generarRole")
    public static Role generarRole(String genero){
        if (genero == null) return null;

        return switch (genero.toUpperCase()){
            case "CLIENTE" -> Role.ATTORNEY;
            case "CONTRAPARTE" -> Role.COUNTERPARTY;
            default -> null;
        };
    }

    @Named("generarRol")
    public static String generarRol(Role genre){
        if (genre==null) return null;

        return switch (genre){
            case Role.ATTORNEY -> "Cliente";
            case Role.COUNTERPARTY -> "Contraparte";
            default -> null;
        };
    }
}
