package br.com.zup.SOLIDcomJava.cursosFeitos;

public class AnalisaIdadeAluno implements AnalisaAluno{

	@Override
	public void analisaMomentoAtual(Aluno aluno) {
		System.out.println(aluno.getIdade());
		
	}

}
