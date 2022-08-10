package cl.dojooverflow.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;


//Getter Setter y ToString
@Data

//Declaracion entidad a JPA
@Entity
@Table(name="tags")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	@Column(updatable = false)
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToMany(mappedBy = "listTag")
	private List<Question> listQuestion;
	
	
	public Tag(String subject) {
		this.subject = subject;
	}
	
	public Tag() {
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
