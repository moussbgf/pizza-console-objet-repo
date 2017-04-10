package fr.pizzeria.ihm;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.StockageTableau;
import fr.pizzeria.model.Pizza;


public class ListerPizzaOptionMenu extends OptionMenu {
	
	public ListerPizzaOptionMenu(Stockage stockage) {
		super(stockage);
		this.titre = "Liste des pizzas";
	}

	@Override
	public void execute() {
		
		
		System.out.println("Il y a " + Pizza.getNbrPizza() + " Pizza stocké.");
		
		Pizza[] tabPizza = stockage.findAllPizzas();
		
		if(stockage == null){
		}else {
			
			for (int i = 0; i < tabPizza.length; i++) {
				if (tabPizza[i] != null && tabPizza[i].getId() != -1) {
					System.out.println(tabPizza[i].getCode() + " " + tabPizza[i].getNom() + " " + tabPizza[i].getPrix());
				}
			}
		}
	}

}
