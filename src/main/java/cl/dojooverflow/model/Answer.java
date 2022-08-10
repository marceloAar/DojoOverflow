package cl.dojooverflow.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String answer;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToOne
	private Question question;
	
	
	public Answer(String answer, Question question) {
		this.answer = answer;
		this.question = question;
	}
	
	@PrePersist
	private void createdAt() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	private void updatedAt() {
		this.updatedAt = LocalDateTime.now();
	}

}
