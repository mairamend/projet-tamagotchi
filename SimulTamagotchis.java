import java.util.Scanner;
public class SimulTamagotchis{
    // Lit un entier compris entre min et max, et redemande tant que la saisie est invalide
    private static int lireEntier(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String ligne = sc.nextLine().trim();
            try {
                int valeur = Integer.parseInt(ligne);
                if (valeur >= min && valeur <= max) {
                    return valeur;
                }
            } catch (NumberFormatException e) {
                // ce n'est pas un nombre : on retombe sur le message ci-dessous
            }
            System.out.println("Saisie invalide, recommencez.");
        }
    }
}