package mathieu.pglp_4_2;

/**
 * CalculatriceRPN pour faire des calculs.
 */
public enum CalculatriceRPN {
	/**
	 * calculatrice.
	 */
	CALCULATRICE;
	/**
	 * début du programme.
	 * @param args arguments donnés au démarrage de l'application
	 * @throws Exception erreur dans le résultat
	 */
    public static void main(final String[] args) throws Exception {
        SaisieRPN saisie = new SaisieRPN();
        saisie.calcul();
    }
}
