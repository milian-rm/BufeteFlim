package org.flim.bufeteflim.persistence.mapper;

import org.mapstruct.Named;
import org.flim.bufeteflim.dominio.CaseType;


public class CaseTypeMapper {

    @Named("generarCaseType")
    public static CaseType generarCaseType(String caseTypeString) {
        if (caseTypeString == null) return null;

        return switch (caseTypeString.toUpperCase()) {
            case "CIVIL" -> CaseType.CIVIL;
            case "PENAL" -> CaseType.PENAL;
            case "LABORAL" -> CaseType.LABOR;
            case "MERCANTIL" -> CaseType.MERCANTILE;
            case "ADMINISTRATIVO" -> CaseType.ADMINISTRATIVE;
            case "CONSTITUCIONAL" -> CaseType.CONSTITUTIONAL;
            case "TRIBUTARIO" -> CaseType.TRIBUTARY;
            case "INTERNACIONAL" -> CaseType.INTERNATIONAL;
            case "AMBIENTAL" -> CaseType.ENVIRONMENTAL;
            case "PROPIEDAD_INTELECTUAL" -> CaseType.INTELLECTUAL_PROPERTY;
            case "FAMILIA" -> CaseType.FAMILY;
            case "INMOBILIARIO" -> CaseType.REAL_ESTATE;
            default -> null;
        };
    }

    @Named("generarTipoCaso")
    public static String generarTipoCaso(CaseType caseType) {
        if (caseType == null) return null;

        return switch (caseType) {
            case CIVIL -> "CIVIL";
            case PENAL -> "PENAL";
            case LABOR -> "LABORAL";
            case MERCANTILE -> "MERCANTIL";
            case ADMINISTRATIVE -> "ADMINISTRATIVO";
            case CONSTITUTIONAL -> "CONSTITUCIONAL";
            case TRIBUTARY -> "TRIBUTARIO";
            case INTERNATIONAL -> "INTERNACIONAL";
            case ENVIRONMENTAL -> "AMBIENTAL";
            case INTELLECTUAL_PROPERTY -> "PROPIEDAD_INTELECTUAL";
            case FAMILY -> "FAMILIA";
            case REAL_ESTATE -> "INMOBILIARIO";
            default -> null;
        };
    }
}

