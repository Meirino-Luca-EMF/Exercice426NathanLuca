package exercice.app.threads;

import java.util.ArrayList;

public class NombreB extends Thread {
    
    private final int nombre;
    private final int min;
    private final int max;
    private volatile boolean travailRealise;

    public NombreB(int min, int max) {
        this.travailRealise = false;
        this.nombre = 0;
        this.min = min;
        this.max = max;
        setName("Je suis le générateur pour le deuxième nombre");
    }

    @Override
    public void run() {
        System.out.println("Le deuxième nombre aléatoire a démarré !");

        

        travailRealise = true;

        System.out.println("Le deuxième générateur de nombre aléatoire a terminé !");
    }
}
