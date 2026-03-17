package exercice.app.threads;

public class NombreB extends Thread {
    
    private int nombre;
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
        System.out.println("Le deuxième générateur de nombre aléatoire a démarré !");

        nombre = min + (int)(Math.random() * ((max - min) + 1));
        dormir(1); // pour simuler que ça prend du temps...

        travailRealise = true;

        System.out.println("Le deuxième générateur de nombre aléatoire a terminé !");
    }

    public void dormir(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public int getNombres() {

        if (!travailRealise) {
            // forcer à attendre que le thread ait fini :-)
            try {
                System.out.println(" ==> on va attendre que générateur de nombres aléatoires ait terminé !");
                this.join();
                System.out.println(" ==> le générateur de nombres aléatoires a fini !");
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

        return nombre;
    }
}

