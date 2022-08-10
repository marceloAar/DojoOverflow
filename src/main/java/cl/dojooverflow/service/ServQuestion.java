package cl.dojooverflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.dojooverflow.model.Question;
import cl.dojooverflow.repository.RepoQuestion;

@Service
public class ServQuestion {
	
	private final RepoQuestion repoQ;

	public ServQuestion(RepoQuestion repoQ) {
		this.repoQ = repoQ;
	}
	
	//Listado de preguntas
	public List<Question> listQ(){
		
		return repoQ.findAll();
	}
	
	//Crea preguntas
	public void creaQ(Question question) {
		
		repoQ.save(question);
	}
	
	public Question findQuestion(Long id) {
		return repoQ.findById(id).get();
		
	}
}
