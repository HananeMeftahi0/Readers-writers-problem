
package lecteur_redacteur;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanane
 */
public class Redacteur implements Runnable {
    base_de_donnee bd;
    int num;
    Redacteur(base_de_donnee bd,int num){
        this.bd=bd;
        this.num=num;
        
    }

    @Override
    public void run() {

            try {
                bd.deb_red(num);
            } catch (InterruptedException ex) {
                Logger.getLogger(Redacteur.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(500);
                bd.fin_red(num);
            } catch (InterruptedException ex) {
                Logger.getLogger(Redacteur.class.getName()).log(Level.SEVERE, null, ex);
            }
        
     
    }
}

