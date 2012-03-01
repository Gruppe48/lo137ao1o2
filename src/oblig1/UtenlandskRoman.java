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

public class UtenlandskRoman extends Roman
{
	private String språk;
	
	public UtenlandskRoman(String f, String t, int s, double p, String sj, String sp)
	{
		super(f, t, s, p, sj);
		språk = sp;
	}
	
        public UtenlandskRoman() {

        }
        
        @Override
	public String toString()
	{
		return super.toString() + "Språk: " + språk + "\n";
	}
        
        @Override
        public void skrivObjektTilFil( DataOutputStream output ) {
          try {
            // Skriver datafeltenes verdier til fil. >
            output.writeUTF("Utenlandskroman");
            super.skrivObjektTilFil(output);
            output.writeUTF(språk);
 
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        @Override
        public boolean lesObjektFraFil( DataInputStream input ) {
          try {
            super.lesObjektFraFil(input);
            språk = input.readUTF();
            return true;
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
            return false;
          }
          //< Leser verdier fra fil og lagrer dem i de tilhørende datafeltene. >
        }
}