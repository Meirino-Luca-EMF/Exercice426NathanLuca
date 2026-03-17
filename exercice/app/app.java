package exercice.app;

import exercice.app.threads.NombreThread;

public class app {
    public static void main(String[] args) {
        
        try {
            // Créer 3 générateurs de nombres aléatoires (entre 1 et 7)
            NombreThread a1 = new NombreThread(1, 7);

            // Démarrer les générateurs
            a1.start();

            // Attendre qu'ils aient fini
            a1.join();

            int test = a1.getNombre();

            System.out.println(test);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
