package eduv.tecazuay.tec.service;

import java.util.List;

import eduv.tecazuay.tec.entity.Usuario;

public interface IUsuarioService {
	
	Usuario guardarUsuario(Usuario usuario);
	
	List<Usuario> listarUsuario();
	
	Usuario findUsuarioById(Long id_usuario);
	
	Usuario findUsuarioByName(String nombre_usuario);
	
	void deleteUsuarioById(Long id_usuario);
	
}
