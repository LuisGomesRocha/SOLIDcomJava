package br.com.zup.SOLIDcomJava.cursosFeitos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "nome em branco!")
	@Size(min = 3, max = 30, message = "Nome deve conter de 3 a 30 caracteres!")
	@Column (unique = true) 
	private String nome;
	@Size(min = 3, max = 30, message = "Email deve conter de 3 a 30 caracteres!")
	@NotBlank(message = "email em branco!")
	@Email(message = "email inválido")
	private String email;
	@NotNull(message = "Data em branco!")
	@Min(value = 18 , message = "Idade necessita ser maior ou igual a 18 anos")
	private Integer idade;
	private List<?> cursos;
	
	
	
	
	public Aluno(
			@NotBlank(message = "nome em branco!") @Size(min = 3, max = 30, message = "Nome deve conter de 3 a 30 caracteres!") String nome,
			@Size(min = 3, max = 30, message = "Email deve conter de 3 a 30 caracteres!") @NotBlank(message = "email em branco!") @Email(message = "email inválido") String email,
			@NotNull(message = "Data em branco!") @Min(value = 18, message = "Idade necessita ser maior ou igual a 18 anos") Integer idade,
			List<?> cursos) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.cursos = cursos;
	}
	
	
	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public Integer getIdade() {
		return idade;
	}




	public void setIdade(Integer idade) {
		this.idade = idade;
	}




	public List<?> getCursosFeitos() {
		return cursos;
	}



	public void setCursos(List<?> cursos) {
		this.cursos = cursos;
	}


}