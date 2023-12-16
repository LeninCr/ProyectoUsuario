package eduv.tecazuay.tec.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import eduv.tecazuay.tec.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	@Query(value = "SELECT * FROM Usuario WHERE nombre_usuario LIKE %:criterio%", nativeQuery = true)
	Usuario findUsuarioByName(@Param("criterio") String criterio);
}
