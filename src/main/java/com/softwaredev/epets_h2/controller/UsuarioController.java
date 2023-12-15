package com.softwaredev.epets_h2.controller;

import com.softwaredev.epets_h2.model.Usuario;
import com.softwaredev.epets_h2.ropository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable UUID id){
            return usuarioRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

@   PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        Usuario salvarUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvarUsuario);
}

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario ){
    return usuarioRepository.findById(id).map(recordFound -> {recordFound.setNome(usuario.getNome());
        Usuario updated = usuarioRepository.save(recordFound);
                return ResponseEntity.ok().body(updated);
            }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> apagarConta(@PathVariable UUID id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado.");
        }
        usuarioRepository.delete(usuario.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado com sucesso.");
    }


}