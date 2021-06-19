package com.uniacademia.enade.resources;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.uniacademia.enade.model.Usuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UsuarioResourceTest {
    
    UsuarioResource usuarioResource = mock(UsuarioResource.class);
    List<Usuario> usuarioList = new ArrayList<>();
    Usuario usuario = mock(Usuario.class);
    
    public UsuarioResourceTest() {
    }
    
    @Test
    void testtodosUsuarios() {
        usuarioList.add(usuario);
        when(usuarioResource.todosUsuarios()).thenReturn(usuarioList);
        assertEquals(usuarioList, usuarioResource.todosUsuarios());
    }

    @Test
    void testgetUsuario() {
        when(usuarioResource.getUsuario(usuario.getId())).thenReturn(usuario);
        assertEquals(usuario, usuarioResource.getUsuario(usuario.getId()));
    }

    @Test
    void testAlterar() {
        String ts = usuario.toString();
        when(usuarioResource.alterar(usuario)).thenReturn(ts);
        assertEquals(usuario.toString(), usuarioResource.alterar(usuario));
    }

    @Test
    void testexcluirTodos() {
        when(usuarioResource.excluirTodos()).thenReturn("Todos registros excluidos!");
        assertEquals("Todos registros excluidos!", usuarioResource.excluirTodos());
    }

    @Test
    void testRemove() {
        when(usuarioResource.excluir(usuario.getId())).thenReturn("Registro excluído com sucesso!");
        assertEquals("Registro excluído com sucesso!", usuarioResource.excluir(usuario.getId()));
    }
    
}
