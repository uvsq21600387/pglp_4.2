package mathieu.pglp_4_2;

import java.util.Scanner;
import java.util.Stack;

import mathieu.pglp_4_2.command.generic.Undo;

/**
 * Saisie dans le terminal pour la calculatrice.
 */
public class SaisieRPN {
	/**
	 * moteur de la saisie pour les calculs.
	 */
	private MoteurRPN moteur;
	/**
	 * interpreteur de la saisie pour quit et undo.
	 */
	private Interpreteur interprete;
	/**
	 * pile contenant les operandes.
	 */
	private Stack<Double> pile;
	/**
	 * scanner pour les entrées utilisateurs.
	 */
	private Scanner s;
	/**
	 * constructeur de la classe.
	 */
	public SaisieRPN() {
		pile = new Stack<Double>();
		Undo u = new Undo(pile);
		u.alertChange();
		moteur = MoteurRPN.init(pile, u);
		interprete = Interpreteur.init(u);
	}
	/**
	 * Saisie morceau par morceau des éléments de calcul.
	 * s'arrete lorsque l'utilisateur entre "quit"
	 * @return double correspondant au résultat du calcul
	 * @throws Exception si le résultat est invalide
	 */
	public double calcul() throws Exception {
		s = new Scanner(System.in);
		double d;
		boolean continuer = true;
		String line = "";
		System.out.print("Commandes autorisées : \n"
		+ "- un nombre dont la décimal est séparée d'une virgule\n"
		+ "- une opération parmis {+,-,*,/}\n"
		+ "- \"undo\" pour revenir en arrière d'une étape\n"
		+ "- \"quit\" pour terminer\n>");
		while (continuer) {
			try { //récupérer un nombre
				d = s.nextDouble();
				moteur.addOperande(d);
			} catch (java.util.InputMismatchException e) {
				line = s.nextLine();
				try { //récupérer une commande d'opération
					moteur.executeCommand(line);
				} catch (Exception m) {
					try {
						//récupérer commande interprete
						interprete.executeCommand(line);
					} catch (Exception i) {
						System.err.println(
						"Commande non autorisée/"
						+ "reconnue");
					}
				}
			}
			if (line.equalsIgnoreCase("quit")) {
				continuer = false;
			} else {
				System.out.print(
				"\nExpression : " + pile + "\n>");
				//affichage de l'expression
			}
		}
		s.close();
		/*
		 * si on a pas un seul opérande,
		 * alors on ne peut pas déterminer
		 * le résultat.
		 */
		if (pile.size() != 1) {
			System.err.println(
			"L'expression doit contenir 1 seul nombre");
			throw new Exception();
		}
		//retourne le résultat
		System.out.println("resultat : " + pile);
		return pile.pop();
	}
}
