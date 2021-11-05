package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	//AlunoRespository � o obj reposit�rio ou a escola onde fica a turma
	// ATRIBUTO == array (uma cole��o de alunos)
	//CONSTRUTOR 1 == inicializar turma. Construtor padr�o. 
	//CONSTRUTOR 2 == quantidade de alunos na turma.Tem par�metro diferente do 1
	//M�TODOS == inserir um aluno no reposit�rio. Set e Get
	
	
	//ATRIBUTO 
	private Aluno[] turma; 
	
	//CONSTRUTOR 1
	public AlunoRepository() {
		turma = new Aluno[32];
	}
	//CONSTRUTOR 2
	public AlunoRepository(int qntAluno) {
		turma = new Aluno[32];
	}
		
	//M�TODOS set e get
	public void gravar(Aluno aluno, int posicao) {
		turma[posicao]=aluno;	
	}
	public Aluno listarAluno(int posicao){
		return turma[posicao];
	}
	public Aluno[] listarTodos(){
		return turma;
		
	}
	
	
}
