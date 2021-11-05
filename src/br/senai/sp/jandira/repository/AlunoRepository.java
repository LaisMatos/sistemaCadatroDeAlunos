package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	//AlunoRespository é o obj repositório ou a escola onde fica a turma
	// ATRIBUTO == array (uma coleção de alunos)
	//CONSTRUTOR 1 == inicializar turma. Construtor padrão. 
	//CONSTRUTOR 2 == quantidade de alunos na turma.Tem parâmetro diferente do 1
	//MÉTODOS == inserir um aluno no repositório. Set e Get
	
	
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
		
	//MÉTODOS set e get
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
