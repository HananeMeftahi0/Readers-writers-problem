
package lecteur_redacteur;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanane
 */
public class Lecteur implements Runnable {

      base_de_donnee bd;
      int num;
    Lecteur (base_de_donnee bd,int num){
        this.bd=bd;
        this.num=num;
        
    }

    @Override
    public void run() {
   
         try {
             bd.deb_lec(num);
         } catch (InterruptedException ex) {
             Logger.getLogger(Lecteur.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             Thread.sleep(500);
         } catch (InterruptedException ex) {
             Logger.getLogger(Lecteur.class.getName()).log(Level.SEVERE, null, ex);
         }
         bd.fin_lec(num);
     
     
    }
    
    
}
