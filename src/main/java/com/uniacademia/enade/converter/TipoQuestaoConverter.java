package com.uniacademia.enade.converter;

import com.uniacademia.enade.model.TipoQuestao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter("tipoquestaoConverter")
@Named
public class TipoQuestaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TipoQuestao) {
            TipoQuestao obj = (TipoQuestao) value;
            uic.getAttributes().put(obj.getId().toString(), obj);
            return obj.getId().toString();
        }
        return "";
    }

}
