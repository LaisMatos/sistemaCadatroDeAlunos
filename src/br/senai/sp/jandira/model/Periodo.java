package br.senai.sp.jandira.model;

public enum Periodo {
	
	MANHA ("Manh�"), 
	TARDE ("Tarde"),
	NOITE ("Noite");
	
	private Periodo (String descricao) {
		this.descricao=descricao;
	}
	
	private String descricao;
		
	public String getDescricao() {
		return descricao;
	}


	
	
	
	
	
	
	
}
