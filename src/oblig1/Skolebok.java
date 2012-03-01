/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 * @studnr 180212

 * @author Even Augdal <even.augdal@gmail.com>
 * @studnr 181091
 * 
 * @author Tommy Nyrud <s180487@stud.hioa.no>
 * @studnr 180487
 * 
 * @date Feb 20, 2012
 */

package oblig1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Skolebok extends Bok
{
	private int klassetrinn;
	private String skolefag;
	
	public Skolebok(String f, String t, int s, double p, int kl, String sk)
	{
		super(f, t, s, p);
		klassetrinn = kl;
		skolefag = sk;
	}
	
        public Skolebok() {

        }
        @Override
	public String toString()
	{
		return super.toString() + "Klassetrinn: " + klassetrinn + "\nSkolefag: " + skolefag + "\n";
	}
        
        @Override
        public void skrivObjektTilFil( DataOutputStream output ) {
          try {
            // Skriver datafeltenes verdier til fil. >
            output.writeUTF("Skolebok");
            super.skrivObjektTilFil(output);
            output.writeInt(klassetrinn);
            output.writeUTF(skolefag);
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        @Override
        public boolean lesObjektFraFil( DataInputStream input ) {
          try {
            super.lesObjektFraFil(input);
            klassetrinn = input.readInt();
            skolefag = input.readUTF();
            return true;
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
            return false;
          }
          //< Leser verdier fra fil og lagrer dem i de tilhørende datafeltene. >
        }
}