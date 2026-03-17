package exercice.ctrl;

import java.util.ArrayList;

import exercice.threads.NombreThread;

public class Ctrl {
    public void start(){
    try {
            // Créer 3 générateurs de nombres aléatoires (entre 1 et 7)
            NombreThread a1 = new NombreThread(1, 7);
            NombreThread a2 = new NombreThread(1, 7);
            NombreThread a3 = new NombreThread(1, 7);
            // Démarrer les générateurs
            a1.start();
            a2.start();
            a3.start();

            // Attendre qu'ils aient fini
            a1.join();
            a2.join();
            a3.join();

            ArrayList<Integer> tousLesNombres = new ArrayList<>();
            tousLesNombres.add(a1.getNombre());
            tousLesNombres.add(a2.getNombre());
            tousLesNombres.add(a3.getNombre());

            System.out.println(tousLesNombres);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}