package com.tarea.generation.controllers;

import com.tarea.generation.models.Usuario;
import com.tarea.generation.services.UsuarioServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRESTController {

    @Autowired //
    UsuarioServicelmpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> ListaDeUsuario() {
        return usuarioService.listaUsuarios();
    }

    @PostMapping("/registrar")
    public Usuario crearUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.guardarUsuario(nuevoUsuario);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> borrarUsuarioPorId(@RequestParam Long id) {
        usuarioService.borrarUsuarioPorId(id);
        return ResponseEntity.ok("Se ha borrado el usuario con id: " + id); //.ok es cuando la solicitud se realizó con éxito

    }

    @PutMapping("/editar/{id}") //Otra forma de recibir parámetros
    public ResponseEntity<?> editarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.editarUsuarioPorId(usuario, id);

    }


}
