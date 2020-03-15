package mathieu.pglp_4_2;

/**
 * Hello world!
 */
public final class App {
	/**
	 * constructeur de la classe App.
	 */
	private App() {
	}
	/**
	 * début du programme.
	 * @param args arguments donnés au démarrage de l'application
	 * @throws Exception erreur durant le calcul
	 */
    public static void main(final String[] args) throws Exception {
        SaisieRPN saisie = new SaisieRPN();
        saisie.calcul();
    }
}
