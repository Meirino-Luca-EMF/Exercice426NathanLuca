package exercice.threads;

public class NombreThread extends Thread {

    private final int max;
    private final int min;
    private volatile boolean nombreGenere;

    public NombreThread(int min, int max) {
        this.nombreGenere = false;
        this.min = min;
        this.max = max;
        setName("Je suis le générateur de nombres aléatoires (" + Integer.toHexString(System.identityHashCode(this))
                + ")");
    }

    int nombre;

    @Override
    public void run() {
        System.out.println("Le générateur de nombres aléatoires (" + Integer.toHexString(System.identityHashCode(this))
                + ") a démarré !");

        nombre = (int) (Math.random() * (max - min + 1) + min);

        dormir(1); // pour simuler que ça prend du temps...

        nombreGenere = true;

        System.out.println("Le générateur de nombres aléatoires (" + Integer.toHexString(System.identityHashCode(this))
                + ") a terminé !");
    }

    public void dormir(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public int getNombre() {
        if (!nombreGenere) {
            try {
                System.out.println(" ==> on va attendre que générateur de nombres ait terminé !");
                this.join();
                System.out.println(" ==> le générateur de nombres a fini !");
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        return nombre;
    }
}
