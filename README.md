# SOLIDcomJava


<h1 align="center">
    <a href="https://cursos.alura.com.br/course/orientacao-a-objetos-avancada-e-principios-solid">🔗 SOLID com Java: Orientação a Objetos com Java </a>
</h1>
<p align="center">🚀 Formulário de proposta de solução - SOLID com Java: Orientação a Objetos com Java 🚀 </p>



<h2 align="center"> <img src="https://64.media.tumblr.com/f8820c68f8ce957f16bec960da046159/22cb9850dfb09a9d-6d/s500x750/0ba465302b14164dc05196f4d07f225fb378a8e3.gifv" width="380" height="200" /> </h2>

### Primeiro Cenário

<p align="justify"> :robot: Atualmente existe uma classe em um sistema dentro do Orange Talents com um método chamado analisaDadosResposta que recebe como argumento objeto cujo tipo é uma classe criada no próprio sistema para se conectar com formulários do google forms. Só que agora esse método precisa analisar dados que também podem vir do Microsoft Forms. No futuro, também pode ser necessário analisar dados que vão vir via TypeForms. Qual seria solução/alteração para que o método analisaDadosResposta não precisasse ser modificado em função das novas fontes de dados do futuro? :robot: </p>

<p align="justify"> :exclamation: Em Java, uma interface é um tipo abstrato que contém uma coleção de métodos e variáveis e constantes. É um dos principais conceitos em Java e é usado para obter abstração, polimorfismo e várias heranças. Desta forma vou implementar uma interface chamada Forms criando as classes GoogleFormsImpl, MicrosoftFormsImpl e TypeFormsImpl, sendo todas essas implementando a interface Forms. Desta maneira não é necessário que o método seja alterado a cada novo formato de dados. Desta forma atendemos um princípio denominado aberto/fechado estabelece que "entidades de software (classes, módulos, funções, etc.) devem ser abertas para extensão, mas fechadas para modificação"; isto é, a entidade pode permitir que o seu comportamento seja estendido sem modificar seu código-fonte.:exclamation: </p>

#### Forms

```
package br.com.zup.SOLIDcomJava.analise;

public interface Forms {
	
	void analisaDadosResposta();
		
}

```

#### GoogleFormsImpl

```

public class GoogleFormsImpl implements Forms {

	@Override
	public void analisaDadosResposta() {
		// TODO Auto-generated method stub
		
	}
}

```

#### MicrosoftFormsImpl

```

public class MicrosoftFormsImpl implements Forms{

	@Override
	public void analisaDadosResposta() {
		// TODO Auto-generated method stub
		
	}
}

```

#### TypeFormsImpl

```

public class TypeFormsImpl implements Forms{

	@Override
	public void analisaDadosResposta() {
		// TODO Auto-generated method stub
		
	}
}

```

<h2 align="center"> <img src="https://64.media.tumblr.com/81c455e9a8443e0e7773e23cbb8034a7/22cb9850dfb09a9d-d8/s500x750/7854114c951bad4bd9415cda0a34eae86f6ad31e.gifv" width="330" height="200" /> </h2>

### Segundo Cenário
  
<p align="justify"> :robot: Existe um outro método aqui nos sistemas da Orange Talent, analisaMomentoAtual, que recebe como argumento um objeto do tipo Aluno. Dentro deste método, o único método chamado a partir de um objeto do tipo Aluno, é o getCursosFeitos(). Neste momento, qualquer alteração na classe Aluno pode influenciar no comportamento do método analisaMomentoAtual. Como você faria para que o método analisaMomentoAtual possa continuar a receber um Aluno, mas através de uma interface mais estável? Só para deixar claro, a ideia é que o ponto do código onde temos algo como analisaMomentoAtual(aluno) continue do mesmo jeito. A invocação do método em si não precisa ser alterada. Isso é bem desafiador. :robot: </p>

<p align="justify"> :exclamation: Para o segundo senário foi implementado uma interface chamada AnalisaAluno com o método analisaMomentoAtual que recebe uma classe do tipo Aluno, visando manter a estabilidade; em seguinte implementaremos classes especificas para verificação de cada característica das classes p.ex.: AnalisaAlunoCursos ou AnalisaIdadeAluno, onde cada classe implementa a interface AnalisaAluno e qualquer outro método que for necessário. Essa solução é inspirada pelo princípio da segregação pela interface.  :exclamation: </p>


#### Main

```

//@SpringBootApplication
public class SoliDcomJavaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SoliDcomJavaApplication.class, args);
		
		
		List <String> listaDeCursos = new ArrayList();
		listaDeCursos = Arrays.asList("Filosofia", "Coluniaritius", "Chupada 1", "TomaToba 3", "Queimada");
		Aluno aluno2 = new Aluno("Jose Chico", "luis@gmail.com", 12, listaDeCursos);
		
		AnalisaAluno  analisaAluno = new AnalisaIdadeAluno();
		AnalisaAluno  analisaAlunos = new AnalisaAlunoCursos();
		
		analisaAluno.analisaMomentoAtual(aluno2);
		analisaAlunos.analisaMomentoAtual(aluno2);
		
	}

}

```

#### Aluno

```
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


```

#### Interface AnalisaAluno

```

public interface AnalisaAluno {

	void analisaMomentoAtual(Aluno aluno);
	
}

```


#### AnalisaAlunoCursos

```

public class AnalisaAlunoCursos implements AnalisaAluno {

	@Override
	public void analisaMomentoAtual(Aluno aluno) {
		

		System.out.println(aluno.getCursosFeitos());
		
	}
	
}

```

#### AnalisaIdadeAluno

```

public class AnalisaIdadeAluno implements AnalisaAluno{

	@Override
	public void analisaMomentoAtual(Aluno aluno) {
		System.out.println(aluno.getIdade());
		
	}

}

```

<h2 align="center"> <img src="https://ib.canaltech.com.br/361132.gif" width="330" height="200" /> </h2>



