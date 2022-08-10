package cl.dojooverflow.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.dojooverflow.model.Tag;

@Repository
public interface RepoTag extends JpaRepository<Tag, Long>{
	
	@Query(value="SELECT * FROM tags WHERE subject = ?1", nativeQuery = true)
	//devuelve objeto tipo Tag , nombre del metodo, (parametro entregado a la Query)
	Tag tagExists (String tag);
}
