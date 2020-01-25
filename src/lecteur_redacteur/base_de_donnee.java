package lecteur_redacteur;

/**
 *
 * @author Hanane
 */
public class base_de_donnee {
  private static int lecteurs; 
  private static boolean ecriture; 
 
        public base_de_donnee ()
  {
    this.lecteurs = 0;
     this.ecriture= false;
   
  }
  synchronized void deb_lec(int i) throws InterruptedException{
   
         lecteurs+=1;
        if(ecriture==true) this.wait();
      System.out.println("Lecteur numero "+i+" a commencè de lire.");
  }
   synchronized void fin_lec(int i){
      
      System.out.println("Lecteur numero "+i+" a arrete de lire.");
      this.lecteurs--;
      if (this.lecteurs == 0)
      {
        this.notifyAll();
      }
   }

synchronized void  deb_red(int i) throws InterruptedException{
    
       while (this.lecteurs!= 0 | ecriture)
    {
      try
      {
        this.wait();
      }
      catch (InterruptedException e) {}
    }
      
       ecriture=true;
       
    System.out.println("redacteur "+i+" a commencè d'ecrire.");
    
}
synchronized void  fin_red(int i) throws InterruptedException{
     ecriture=false;
     
    System.out.println("Redacteur  "+i+" a  arretè d'ecrire.");
    this.notifyAll();
}
   

    
    public static void main(String[] args) {
        base_de_donnee bd=new base_de_donnee();
        Thread red =new Thread(new Redacteur(bd,0));
        Thread lec=new Thread(new Lecteur(bd,0));
           Thread red2 =new Thread(new Redacteur(bd,1));
        Thread lec2=new Thread(new Lecteur(bd,1));
           Thread red3 =new Thread(new Redacteur(bd,2));
        Thread lec3=new Thread(new Lecteur(bd,2));
        Thread red4 =new Thread(new Redacteur(bd,3));
        Thread lec4=new Thread(new Lecteur(bd,3));
    red.start();
        lec.start();
        red2.start();
        lec2.start();
        red3.start();
        lec3.start();
        red4.start();
        lec4.start();
       
    
        
  
    }
    
}
