package cl.dojooverflow.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//Contructores vacio y completo
//@AllArgsConstructor
@NoArgsConstructor

//Getter Setter y ToString
@Data

//Declaracion de entidad para JPA
@Entity
@Table(name ="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String question;
	@Column(updatable = false)
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToMany
	@JoinTable(name="tags_questions",
			//llave foranea de esta tabla
			joinColumns = @JoinColumn (name="question_id"),
			//llave foranea de la tabla secundaria
			inverseJoinColumns = @JoinColumn(name="tag_id")
			)
	private List<Tag> listTag;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> listAnswer;
	
	//Constructor de pregunta
	
	public Question(String question, List<Tag> listTag) {
		this.question = question;
		this.listTag = listTag;
	}
	
	
	//Cada vez que se crea un registro guarda la fecha y hora.
	@PrePersist
	private void createdAt() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	private void updatedAt() {
		this.updatedAt = LocalDateTime.now();
	}
	
}
