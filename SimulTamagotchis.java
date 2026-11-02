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
    private static String lireNom(Scanner sc, String message) {
    while (true) {
        System.out.print(message);
        String nom = sc.nextLine().trim();
        if (!nom.isEmpty()) {
            return nom;
        }
        System.out.println("Le nom ne peut pas être vide.");
    }
}
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = lireEntier(sc, "Combien de tamagotchis ? ", 1, 20);
        Tamagotchi[] colonie = new Tamagotchi[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            colonie[i] = new Tamagotchi(lireNom(sc, "Quel nom pour le nouveau tamagotchi : "));
        }

        int restants = n;       // tamagotchis encore en jeu
        boolean perdu = false;
        int cycle = 1;

        while (restants > 0 && !perdu) {
            System.out.println("-------Cycle no " + cycle + " -------");

            // 1) Chaque tamagotchi encore en jeu vit un cycle
            for (int i = 0; i < colonie.length && !perdu; i++) {
                if (colonie[i] == null) {
                    continue;
                }
                if (!colonie[i].vivre()) {
                    perdu = true;                 // mort de faim
                } else if (colonie[i].ageLimite()) {
                    colonie[i] = null;            // a gagné : il sort du jeu
                    restants--;
                }
            }

            // 2) L'utilisateur nourrit un tamagotchi
            if (!perdu && restants > 0) {
                for (int i = 0; i < colonie.length; i++) {
                    if (colonie[i] != null) {
                        System.out.print("(" + i + ") " + colonie[i].getNom() + " ");
                    }
                }
                System.out.println();

                int choix;
                do {
                    choix = lireEntier(sc, "Nourrir quel tamagotchi ? ", 0, n - 1);
                    if (colonie[choix] == null) {
                        System.out.println("Ce tamagotchi n'est plus en jeu.");
                    }
                } while (colonie[choix] == null);

                colonie[choix].manger();
            }
            cycle++;
        }

        System.out.println(perdu ? "PERDU !!" : "GAGNÉ !!");
        sc.close();
    }
}