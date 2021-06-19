package com.uniacademia.enade.converter;

import com.uniacademia.enade.model.TipoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter("tipoUsuarioConverter")
@Named
public class TipoUsuarioConverter implements Converter{
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TipoUsuario) {
            TipoUsuario obj = (TipoUsuario) value;
            uic.getAttributes().put(obj.getId().toString(), obj);
            return obj.getId().toString();
        }
        return "";
    }
}
