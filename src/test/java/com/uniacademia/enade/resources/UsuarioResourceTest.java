/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniacademia.enade.resources;

import com.uniacademia.enade.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Isaias
 */
public class UsuarioResourceTest {
    
    UsuarioResource usuarioResource = mock(UsuarioResource.class);
    List<Usuario> usuarioList = new ArrayList<>();
    Usuario usuario = mock(Usuario.class);
    
    public UsuarioResourceTest() {
    }

    @Test
    public void testTodosUsuarios() {
        System.out.println("todosUsuarios");
        UsuarioResource instance = new UsuarioResource();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.todosUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Integer id = null;
        UsuarioResource instance = new UsuarioResource();
        Usuario expResult = null;
        Usuario result = instance.getUsuario(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Integer idUsuario = null;
        UsuarioResource instance = new UsuarioResource();
        String expResult = "";
        String result = instance.excluir(idUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testExcluirTodos() {
        System.out.println("excluirTodos");
        UsuarioResource instance = new UsuarioResource();
        String expResult = "";
        String result = instance.excluirTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        Usuario usuario = null;
        UsuarioResource instance = new UsuarioResource();
        String expResult = "";
        String result = instance.cadastrar(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Usuario usuario = null;
        UsuarioResource instance = new UsuarioResource();
        String expResult = "";
        String result = instance.alterar(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    public void testAlterar2() {
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
