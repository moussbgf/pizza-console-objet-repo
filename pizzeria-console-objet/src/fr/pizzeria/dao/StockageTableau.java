package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	private Pizza[] tabPizza;

	public StockageTableau() {

		tabPizza = new Pizza[10];

		Pizza p0 = new Pizza("PEP", "Pépéroni", 12.5);
		Pizza p1 = new Pizza("MAR", "Margherita", 14.00);
		Pizza p2 = new Pizza("REIN", "La Reine", 11.50);
		Pizza p3 = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza p4 = new Pizza("CAN", "La cannibale", 12.50);
		Pizza p5 = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza p6 = new Pizza("ORI", "L’orientale", 13.50);
		Pizza p7 = new Pizza("IND", "L’indienne", 14.00);

		tabPizza[0] = p0;
		tabPizza[1] = p1;
		tabPizza[2] = p2;
		tabPizza[3] = p3;
		tabPizza[4] = p4;
		tabPizza[5] = p5;
		tabPizza[6] = p6;
		tabPizza[7] = p7;

	}

	@Override
	public Pizza[] findAllPizzas() {

		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		Boolean resultat = false;

		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] == null || tabPizza[i].getId() == -1) {
				pizza.setId(i);
				tabPizza[i] = pizza;
				resultat = true;
				break;
			}
		}
		
		if(resultat == false)
			throw new SavePizzaException();
	}

	@Override //code pizza non utilisé
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
	
		
		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] != null && tabPizza[i].getCode().equals(codePizza)) {
				tabPizza[i] = pizza;
				break;
			} else if (i == tabPizza.length - 1) {
				//System.out.println("Cette pizza n'existe pas");
				
				throw new UpdatePizzaException();
				
			}
		}
	}

	@Override
	public void deletePizza(String codeAmodifier) throws DeletePizzaException {

		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] != null && tabPizza[i].getCode().equals(codeAmodifier)) {
				tabPizza[i].setId(-1);
				break;
			} else if (i == tabPizza.length - 1) {
				
				throw new DeletePizzaException("erreure !!!");
				//System.out.println("Cette pizza n'existe pas");
			}
		}

		Pizza.setNbrPizza(Pizza.getNbrPizza() - 1);
	}

	@Override
	public int existPizza(String codeATester) {

		int resultat = -1;

		for (int i = 0; i < tabPizza.length; i++) {

			if (tabPizza[i] != null && tabPizza[i].getCode().equals(codeATester)) {

				resultat = i;

				break;
			}
		}
		return resultat;

	}

	public Pizza[] getTabPizza() {
		return tabPizza;
	}

	public void setTabPizza(Pizza[] tabPizza) {
		this.tabPizza = tabPizza;
	}

}
