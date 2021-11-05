package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class App {

	public static void main(String[] args) {
    		
		AlunoRepository turmaDs1t = new AlunoRepository(8);
		
				
		Aluno lais = new Aluno();
		lais.setNome("Laís Machado");
		lais.setMatricula("01");		
		lais.setPeriodo(Periodo.TARDE);
    
		Aluno marcus = new Aluno();
		marcus.setNome("Macus do bololo");
		marcus.setMatricula("02");
		marcus.setPeriodo(Periodo.TARDE);
    
		//set para gravar vetor na sua posição
		turmaDs1t.gravar(lais, 0);
		turmaDs1t.gravar(marcus, 1);
		
		//teste de funcionalidade
	    //turmaDs1t [1] == é o aluno marcus
		System.out.println(turmaDs1t.listarAluno(0).getNome());
		System.out.println(turmaDs1t.listarAluno(0).getMatricula());
		System.out.println(turmaDs1t.listarAluno(0).getPeriodo());
    
		//teste listarAluno
		for(int i=0; i<turmaDs1t.listarTodos().length; i++) {
			System.out.println(turmaDs1t.listarAluno(i).getNome());
		}
    
		// turmaDs1t.listarTodos().length == AlunoRepository(8) == 8
	    // (i < turmaDs1t.listarTodos().length) == (i<8)
	}

}
