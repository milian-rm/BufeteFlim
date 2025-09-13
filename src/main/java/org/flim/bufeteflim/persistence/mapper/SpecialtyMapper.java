package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.Specialty;
import org.mapstruct.Named;

public class SpecialtyMapper {
    
    @Named("generarSpecialty")
    public static Specialty generarSpecialty(String especialidad){
        if (especialidad == null) return null;

        return switch(especialidad.toUpperCase()){
            case "CIVIL" -> Specialty.CIVIL;
            case "PENAL" -> Specialty.PENAL;
            case "LABORAL" -> Specialty.LABOR;
            case "MERCANTIL" -> Specialty.MERCANTILE;
            case "ADMINISTRATIVO" -> Specialty.ADMINISTRATIVE;
            case "CONSTITUCIONAL" -> Specialty.CONSTITUCIONAL;
            case "TRIBUTARIO" -> Specialty.TRIBUTARY;
            case "INTERNACIONAL" -> Specialty.INTERNATIONAL;
            case "AMBIENTAL" -> Specialty.ENVIRONMENTAL;
            case "PROPIEDAD_INTELECTUAL" -> Specialty.INTELLECTUAL_PROPERTY;
            case "FAMILIA" -> Specialty.FAMILY;
            case "INMOBILIARIO" -> Specialty.REAL_ESTATE;
            default -> null;
        };
    }

    @Named("generarEspecialidad")
    public static String generarEspecialidad(Specialty specialty){
        if (specialty==null)
        return null;

        return switch(specialty){
            case Specialty.CIVIL -> "CIVIL";
            case Specialty.PENAL -> "PENAL";
            case Specialty.LABOR -> "LABORAL";
            case Specialty.MERCANTILE -> "MERCANTIL";
            case Specialty.ADMINISTRATIVE -> "ADMINISTRATIVO";
            case Specialty.CONSTITUCIONAL -> "CONSTITUCIONAL";
            case Specialty.TRIBUTARY -> "TRIBUTARIO";
            case Specialty.INTERNATIONAL -> "INTERNACIONAL";
            case Specialty.ENVIRONMENTAL -> "AMBIENTAL";
            case Specialty.INTELLECTUAL_PROPERTY -> "PROPIEDAD_INTELECTUAL";
            case Specialty.FAMILY -> "FAMILIA";
            case Specialty.REAL_ESTATE -> "INMOBILIARIO";
            default -> null;
        };
    }
}
