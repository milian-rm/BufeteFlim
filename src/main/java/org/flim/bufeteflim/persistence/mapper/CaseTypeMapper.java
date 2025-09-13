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
            case "LABOR" -> CaseType.LABOR;
            case "MERCANTILE" -> CaseType.MERCANTILE;
            case "ADMINISTRATIVE" -> CaseType.ADMINISTRATIVE;
            case "CONSTITUTIONAL" -> CaseType.CONSTITUTIONAL;
            case "TRIBUTARY" -> CaseType.TRIBUTARY;
            case "INTERNATIONAL" -> CaseType.INTERNATIONAL;
            case "ENVIRONMENTAL" -> CaseType.ENVIRONMENTAL;
            case "INTELLECTUAL_PROPERTY" -> CaseType.INTELLECTUAL_PROPERTY;
            case "FAMILY" -> CaseType.FAMILY;
            case "REAL_ESTATE" -> CaseType.REAL_ESTATE;
            default -> null;
        };
    }

    @Named("generarTipoCaso")
    public static String generarTipoCaso(CaseType caseType) {
        if (caseType == null) return null;

        return switch (caseType) {
            case CIVIL -> "CIVIL";
            case PENAL -> "PENAL";
            case LABOR -> "LABOR";
            case MERCANTILE -> "MERCANTILE";
            case ADMINISTRATIVE -> "ADMINISTRATIVE";
            case CONSTITUTIONAL -> "CONSTITUTIONAL";
            case TRIBUTARY -> "TRIBUTARY";
            case INTERNATIONAL -> "INTERNATIONAL";
            case ENVIRONMENTAL -> "ENVIRONMENTAL";
            case INTELLECTUAL_PROPERTY -> "INTELLECTUAL_PROPERTY";
            case FAMILY -> "FAMILY";
            case REAL_ESTATE -> "REAL_ESTATE";
            default -> null;
        };
    }
}

