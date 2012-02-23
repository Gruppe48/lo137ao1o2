/*
 */
package oblig1;

/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 */
public class oppgave2 {

  /**
   * @param args the command line arguments
   */
    public static void main( String[] args ) {
      BokArkiv vindu = new BokArkiv();
      
      vindu.addWindowListener(
        new WindowAdapter() {
          public void windowClosing( WindowEvent e ) {
            System.exit( 0 );
          }
        } 
      );
   }

}
