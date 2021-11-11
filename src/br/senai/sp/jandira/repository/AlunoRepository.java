package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	
	//AlunoRespository � o obj reposit�rio ou a escola onde fica a turma
	//ATRIBUTO == tamb�m array (uma cole��o de alunos)
	//CONSTRUTOR 1 == inicializar turma. Construtor padr�o, default. 
	//CONSTRUTOR 2 == quantidade de alunos na turma.Tem par�metro diferente do 1
	//M�TODOS == inserir um aluno no reposit�rio. 
	//contrutor? o m�todo tem o mesmo nome da classe, � retorna nada e � publico
	
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
		
	//M�TODOS (set e get)?
	public void gravar(Aluno aluno, int posicao) { //grava aluno em uma posi��o
		turma[posicao]=aluno;	
	}
	public Aluno listarAluno(int posicao){ //retorna posi��o do aluno
		return turma[posicao];
	}
	public Aluno[] listarTodos(){ //retorna a lista dos objetos
		return turma;
		
	}
	
	
}
