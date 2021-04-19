/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniacademia.enade.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.uniacademia.enade.resources.UsuarioResource;

/**
 *
 * @author Isaias
 */
public class UsuarioTest {
    
    UsuarioResource usuarioResource = mock(UsuarioResource.class);
    List<Usuario> usuarioList = new ArrayList<>();
    Usuario usuario = mock(Usuario.class);
    
    public UsuarioTest() {
    }
    
    @Test
    public void testtodosUsuarios() {
        usuarioList.add(usuario);
        when(usuarioResource.todosUsuarios()).thenReturn(usuarioList);
        assertEquals(usuarioList, usuarioResource.todosUsuarios());
    }

    @Test
    public void testgetUsuario() {
        when(usuarioResource.getUsuario(usuario.getId())).thenReturn(usuario);
        assertEquals(usuario, usuarioResource.getUsuario(usuario.getId()));
    }

    @Test
    public void testAlterar() {
        String ts = usuario.toString();
        when(usuarioResource.alterar(usuario)).thenReturn(ts);
        assertEquals(usuario.toString(), usuarioResource.alterar(usuario));
    }

    @Test
    public void testexcluirTodos() {
        when(usuarioResource.excluirTodos()).thenReturn("Todos registros excluidos!");
        assertEquals("Todos registros excluidos!", usuarioResource.excluirTodos());
    }

    @Test
    public void testRemove() {
        when(usuarioResource.excluir(usuario.getId())).thenReturn("Registro excluído com sucesso!");
        assertEquals("Registro excluído com sucesso!", usuarioResource.excluir(usuario.getId()));
    }


}
