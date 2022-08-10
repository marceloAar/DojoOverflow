package cl.dojooverflow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.dojooverflow.model.Answer;
import cl.dojooverflow.model.Question;
import cl.dojooverflow.model.Tag;
import cl.dojooverflow.service.ServAnswer;
import cl.dojooverflow.service.ServQuestion;
import cl.dojooverflow.service.ServTag;

@Controller
@RequestMapping("/questions")
public class ControlaTodo {
	
	private final ServQuestion servQ;
	private final ServAnswer servA;
	private final ServTag servT;
	
	public ControlaTodo(ServQuestion servQ, ServAnswer servA, ServTag servT) {
		this.servQ = servQ;
		this.servA = servA;
		this.servT = servT;
	}
	
	@GetMapping("")
	public String listQT(Model model) {
		
		model.addAttribute("questions", servQ.listQ());
		return "home";
	}
	
	@GetMapping("/new")
	public String createQ() {		
		return "create";
	}
	
	@PostMapping("/newquest")
	public String newQuest(@RequestParam String question, String tags) {
		String[] arrTags = tags.trim().split("\\s*,\\s*");
		List<Tag> tagAcum = new ArrayList<Tag>();
		for (String tag : arrTags) {
			String tagLowerCase = tag.toLowerCase();
			Tag nuevoTag = new Tag(tag);
			if (servT.tagExiste(tagLowerCase) == null) {
				servT.creaT(nuevoTag);
				tagAcum.add(nuevoTag);
			}else {
				Tag tagexistente = servT.tagExiste(tagLowerCase);
				tagAcum.add(tagexistente);
			}
			
		}
		Question nuevaQ = new Question(question,tagAcum);
		
		servQ.creaQ(nuevaQ);
		return "redirect:/questions";
	}
	
	@GetMapping("/{id}")
	public String respuestaQuestion(@PathVariable Long id, Model model) {
		
		model.addAttribute("idquestion", servQ.findQuestion(id));
		return "showQuestion";
	}
	
	@PostMapping("/answers")
	public String creaAnswer(@RequestParam (value="idquestion")Long id, String answer, Model model) {
		
		Answer nuevaAnswer = new Answer(answer,servQ.findQuestion(id));
		servA.creaA(nuevaAnswer);
		model.addAttribute("idquestion", servQ.findQuestion(id));
		return "showQuestion";
	}
}
