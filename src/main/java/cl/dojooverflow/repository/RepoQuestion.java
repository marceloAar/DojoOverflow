package cl.dojooverflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.dojooverflow.model.Question;

@Repository
public interface RepoQuestion extends JpaRepository<Question, Long>{

}
