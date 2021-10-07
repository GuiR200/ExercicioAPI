package br.com.guilherme.model;


public class Personagens {
	
	private String nome;
    private String poderes;
    private String niveu;
    
    public Personagens(String nome,  String poderes, String niveu) {
    	this.nome = nome;
    	this.poderes = poderes;
    	this.niveu = niveu;
    }
	public String getNome() {
		return nome;
	}
	
	public String getPoderes() {
		return poderes;
	}

	public String getNiveu() {
		return niveu;
	}

	public void setNiveis(String niveu) {
		this.niveu = niveu;
	}

	}
    
    
