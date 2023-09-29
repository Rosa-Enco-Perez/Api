package com.tarea.generation.services;

import com.tarea.generation.models.Usuario;
import com.tarea.generation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicelmpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listaUsuarios() {
        return null;
    }

    @Override
    public Usuario guardarUsuarios(){
        return (Usuario) usuarioRepository.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {
        return usuarioRepository.save(usuarioNuevo);
    }

    @Override
    public ResponseEntity<?> borrarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario borrado");
        }else {
            return ResponseEntity.ok("El usuario no existe");
        }
    }

    @Override
    public ResponseEntity<?> editarUsuarioPorId(Usuario usuario, Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuarioEditado = usuarioOptional.get();
            usuarioEditado.setNombreUsuario(usuario.getNombreUsuario());
            usuarioEditado.setEmail(usuario.getEmail());
            usuarioRepository.save(usuarioEditado);
            return ResponseEntity.ok(usuarioEditado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario " + id + " no existe");
        }
    }
}
