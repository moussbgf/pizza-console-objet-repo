package fr.pizzeria.console;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.StockageTableau;
import fr.pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner question = new Scanner(System.in);
		question.useLocale(Locale.US);

		Menu menu = new Menu();

		Stockage StockageTableau = new StockageTableau();

		OptionMenu lister = new ListerPizzaOptionMenu(StockageTableau);
		OptionMenu ajouter = new AjouterPizzaOptionMenu(StockageTableau, question);
		OptionMenu mettreAJour = new ModifierPizzaOptionMenu(StockageTableau, question);
		OptionMenu supprimer = new SupprimerPizzaOptionMenu(StockageTableau, question);

		OptionMenu[] listeActions = new OptionMenu[4];

		listeActions[0] = lister;
		listeActions[1] = ajouter;
		listeActions[2] = mettreAJour;
		listeActions[3] = supprimer;

		menu.setActions(listeActions);

		int choixMenu = 0;
		while (choixMenu != 99) {

			// Affichage du menu
			menu.afficher();

			// Poser une question
			choixMenu = question.nextInt();

			// Analyse de la r�ponse � la question
			switch (choixMenu) {
			case 1: // lister

				menu.getActions()[0].execute();

				break;
			case 2: // ajouter

				menu.getActions()[0].execute();
					

				menu.getActions()[1].execute();
				break;
			case 3: // modifier

				menu.getActions()[0].execute();

				menu.getActions()[2].execute();
					
				break;
			case 4: // supprimer

				menu.getActions()[0].execute();

				menu.getActions()[3].execute();

				break;
			default:
				break;
			}
		}
		
		question.close();

	}

}
