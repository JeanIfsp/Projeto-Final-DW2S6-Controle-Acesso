package br.edu.ifsp.dw2s6.projeto.controleacesso.model;

public enum Cargo {

	PORTEIRO("Porteiro"),
	RECEPCAO("Recepção"),
	SUBSTITUTO("Substituto"),
	SINDICO("Sindico");
	
	private String tipoCargo;
	
	Cargo(String tipoCargo){
		this.tipoCargo = tipoCargo;
	}
	
	public String getTipoCargo(){
        return this.tipoCargo;
    }

}
