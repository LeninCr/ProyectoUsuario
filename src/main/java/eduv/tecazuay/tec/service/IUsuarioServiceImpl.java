package eduv.tecazuay.tec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eduv.tecazuay.tec.dao.IUsuarioDao;
import eduv.tecazuay.tec.entity.Usuario;

@Service
public class IUsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioDao usDao;
	
	@Override
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		return usDao.save(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> listarUsuario() {
		return (List<Usuario>) usDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findUsuarioById(Long id_usuario) {
		return usDao.findById(id_usuario).get();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findUsuarioByName(String nombre_usuario) {
		return usDao.findUsuarioByName(nombre_usuario);
	}

	@Override
	@Transactional
	public void deleteUsuarioById(Long id_usuario) {
		usDao.deleteById(id_usuario);
	}

}
