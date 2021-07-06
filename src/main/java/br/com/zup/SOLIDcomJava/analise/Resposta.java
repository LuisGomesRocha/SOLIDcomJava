package br.com.zup.SOLIDcomJava.analise;

public class Resposta {
	
	private String turma;
	private String inicioFim;
	private String respostas;
	
	
	public Resposta(String turma, String inicioFim, String respostas) {
		this.turma = turma;
		this.inicioFim = inicioFim;
		this.respostas = respostas;
	}


	public String getTurma() {
		return turma;
	}


	public void setTurma(String turma) {
		this.turma = turma;
	}


	public String getInicioFim() {
		return inicioFim;
	}


	public void setInicioFim(String inicioFim) {
		this.inicioFim = inicioFim;
	}


	public String getRespostas() {
		return respostas;
	}


	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}
	
	
	

}
