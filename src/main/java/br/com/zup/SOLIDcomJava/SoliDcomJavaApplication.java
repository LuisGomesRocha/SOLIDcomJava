package br.com.zup.SOLIDcomJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.SOLIDcomJava.cursosFeitos.Aluno;
import br.com.zup.SOLIDcomJava.cursosFeitos.AnalisaAluno;
import br.com.zup.SOLIDcomJava.cursosFeitos.AnalisaAlunoCursos;
import br.com.zup.SOLIDcomJava.cursosFeitos.AnalisaIdadeAluno;

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
