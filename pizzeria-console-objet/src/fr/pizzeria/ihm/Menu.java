package fr.pizzeria.ihm;

public class Menu {
	
	private OptionMenu[] actions;

	public void afficher() {
		
		System.out.println("\n***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza ");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir\n");
	}
	
	
	public OptionMenu[] getActions() {
		return actions;
	}

	public void setActions(OptionMenu[] actions) {
		this.actions = actions;
	}
}
