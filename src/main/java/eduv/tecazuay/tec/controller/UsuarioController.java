package eduv.tecazuay.tec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eduv.tecazuay.tec.entity.Usuario;
import eduv.tecazuay.tec.service.IUsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usSer;
	
	@GetMapping("/lista-usuarios")
	public List<Usuario> listarUsuarios(){
		return usSer.listarUsuario();
	}
	
	@GetMapping("/find-usuario-id/{id}")
	public Usuario findUsuarioById(@PathVariable("id") Long id_usuario) {
		return usSer.findUsuarioById(id_usuario);
	}
	
	@GetMapping("/find-usuario-name/{nombre_usuario}")
	public Usuario findUsuarioByName(@PathVariable("nombre_usuario") String nombre_usuario) {
		return usSer.findUsuarioByName(nombre_usuario);
	}
	
	@PostMapping("/save-usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return usSer.guardarUsuario(usuario);
	}
	
	@PutMapping("/update-usuario/{id}")
	public Usuario updateUsuario(@RequestBody Usuario usuario,@PathVariable("id") Long id_usuario) {
		Usuario usDB = usSer.findUsuarioById(id_usuario);

		usDB.setNombre_usuario(usuario.getNombre_usuario());
		
		usDB.setClave_usuario(usuario.getClave_usuario());
		
		usDB.setEmail_usuario(usuario.getEmail_usuario());
		
		usDB.setEstado_usuario(usuario.getEstado_usuario());
		
		return usSer.guardarUsuario(usDB);
	}
	
	@DeleteMapping("/delete-usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUsuario(@PathVariable("id") Long id_usuario) {
		usSer.deleteUsuarioById(id_usuario);
	}
}
