package cl.dojooverflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.dojooverflow.model.Answer;
import cl.dojooverflow.repository.RepoAnswer;

@Service
public class ServAnswer {
	
	private final RepoAnswer repoA;

	public ServAnswer(RepoAnswer repoA) {
		this.repoA = repoA;
	}
	
	public List<Answer> listA(){
		
		return repoA.findAll();
	}
	
	public void creaA(Answer answer) {
		
		repoA.save(answer);
	}
}
