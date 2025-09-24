package org.flim.bufeteflim.web.controller;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.flim.bufeteflim.persistence.crud.CrudAbogadoEntity;
import org.flim.bufeteflim.persistence.entity.AbogadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
@ViewScoped
@Data
public class VistaAuthController implements Serializable {

    private String correo;
    private String password;

    @Autowired
    private CrudAbogadoEntity crudAbogadoEntity;

    public String verificarCredenciales() {
        if (correo == null || correo.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor, ingrese correo y contraseña."));
            return null;
        }

        AbogadoEntity abogado = crudAbogadoEntity.findByCorreoAndPassword(correo, password);

        if (abogado != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Inicio de sesión exitoso."));
            return "/index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales inválidas."));
            return null;
        }
    }
}