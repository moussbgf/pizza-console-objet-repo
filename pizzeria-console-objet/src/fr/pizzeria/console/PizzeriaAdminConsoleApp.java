package fr.pizzeria.console;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.StockageList;
import fr.pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner question = new Scanner(System.in);
		question.useLocale(Locale.US);

		Menu menu = new Menu();

		Stockage StockageList = new StockageList();

		OptionMenu lister = new ListerPizzaOptionMenu(StockageList);
		OptionMenu ajouter = new AjouterPizzaOptionMenu(StockageList, question);
		OptionMenu mettreAJour = new ModifierPizzaOptionMenu(StockageList, question);
		OptionMenu supprimer = new SupprimerPizzaOptionMenu(StockageList, question);
		
		Map<Integer,OptionMenu> actions;
		
		Map<Integer,OptionMenu> mapActions = new HashMap<Integer,OptionMenu>();
		
		
		mapActions.put(0, lister);
		mapActions.put(1, ajouter);
		mapActions.put(2, mettreAJour);
		mapActions.put(3, supprimer);

		menu.setActions(mapActions);

		int choixMenu = 0;
		while (choixMenu != 99) {

			// Affichage du menu
			menu.afficher();

			// Poser une question
			choixMenu = question.nextInt();

			// Analyse de la r�ponse � la question
			switch (choixMenu) {
			case 1: // lister

				mapActions.get(0).execute();

				break;
			case 2: // ajouter
				
				mapActions.get(0).execute();
					
				mapActions.get(1).execute();
				break;
			case 3: // modifier

				mapActions.get(0).execute();

				mapActions.get(2).execute();
					
				break;
			case 4: // supprimer

				mapActions.get(0).execute();

				mapActions.get(3).execute();
				break;
			default:
				break;
			}
		}
		
		question.close();

	}

}
