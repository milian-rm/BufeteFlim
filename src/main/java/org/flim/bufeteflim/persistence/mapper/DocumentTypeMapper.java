package org.flim.bufeteflim.persistence.mapper;

import org.flim.bufeteflim.dominio.DocumentType;
import org.mapstruct.Named;

public class DocumentTypeMapper {
    @Named("generarDocumentType")
    public static DocumentType generarDocumentType(String tipoDocumento){
        if (tipoDocumento == null) return null;

        return switch (tipoDocumento.toUpperCase()){
            case "JUDICIAL" -> DocumentType.JUDICIAL;
            case "CONTRACTUAL" -> DocumentType.CONTRACTUAL;
            case "ADMINISTRATIVO" -> DocumentType.ADMINISTRATIVE;
            default -> null;
        };
    }

    @Named("generarTipoDocumento")
    public static String generarTipoDocumento(DocumentType documentType){
        if (documentType == null) return null;

        return switch(documentType){
            case DocumentType.JUDICIAL -> "JUDICIAL";
            case DocumentType.CONTRACTUAL -> "CONTRACTUAL";
            case DocumentType.ADMINISTRATIVE -> "ADMINISTRATIVO";
            default -> null;
        };
    }
}
