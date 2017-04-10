package fr.pizzeria.ihm;

import java.util.Scanner;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.StockageTableau;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu(StockageTableau stockageTableau) {
		super(stockageTableau);
		this.titre = "Mettre à jour une pizza";
	}

	public ModifierPizzaOptionMenu(Stockage daoImpl, Scanner question) {
		super(daoImpl, question);
		this.titre = "Mettre à jour une pizza";
	}

	@Override
	public void execute() {
		int testPizza = -1;

		System.out.println("Veuillez choisir la pizza à modifier: ");
		String codeAModifier = question.next();

		// si testPizza = -1 alors pas de pizza
		testPizza = stockage.existPizza(codeAModifier);

		if (testPizza != -1) {

			question.nextLine();
			System.out.println("Veuillez saisir un code:");
			String code = question.next();
			System.out.println("Veuillez saisir un libell�:");
			String libelle = question.next();
			System.out.println("Veuillez saisir un prix:");
			question.nextLine();
			double prix = question.nextDouble();

			Pizza p = new Pizza(code, libelle, prix);

			try {
				stockage.updatePizza(codeAModifier, p);
			} catch (StockageException e) {
				System.out.println("Cette pizza n'existe pas");
				
				//e.printStackTrace();
			}

		} else {
			System.out.println("Cette pizza n'existe pas");
		}

	}
}
