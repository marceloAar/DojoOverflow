package cl.dojooverflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.dojooverflow.model.Tag;
import cl.dojooverflow.repository.RepoTag;

@Service
public class ServTag {
		
	private final RepoTag repoT;

	public ServTag(RepoTag repoT) {
		this.repoT = repoT;
	}
	
	public List<Tag> listT(){
		
		return repoT.findAll();
	}
	
	public void creaT(Tag tag) {
		
		repoT.save(tag);
	}
	
	public Tag tagExiste(String tag) {
		
		return repoT.tagExists(tag);
	}
	

}
