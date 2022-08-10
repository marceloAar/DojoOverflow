package cl.dojooverflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.dojooverflow.model.Answer;

@Repository
public interface RepoAnswer extends JpaRepository<Answer, Long> {

}