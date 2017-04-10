package fr.pizzeria.model;

public class Pizza {
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	private static int nbrPizza = 0; //enlever ?
	private static int generateId = 0; //ID unique
	
	
	public Pizza() {
		this.id = generateId++;
		nbrPizza++;
	}
	
	
	public Pizza(String code, String nom, double prix) {
		this.id = generateId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbrPizza++;
	}

	

	public static int getNbrPizza() {
		return nbrPizza;
	}


	public static void setNbrPizza(int nbrPizza) {
		Pizza.nbrPizza = nbrPizza;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
}
