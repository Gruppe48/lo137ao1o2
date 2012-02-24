package oblig1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NorskRoman extends Roman
{
	private String målform;
	
	public NorskRoman(String f, String t, int s, double p, String sj, String må)
	{
		super(f, t, s, p, sj);
		målform = må;
	}
	
        @Override
	public String toString()
	{
		return super.toString() + "Målform: " + målform + "\n";
	}
        @Override
        public void skrivObjektTilFil( DataOutputStream output ) {
          try {
            // Skriver datafeltenes verdier til fil. >
            output.writeUTF("Norskroman");
            super.skrivObjektTilFil(output);
            output.writeUTF(målform);
            //output.writeUTF("bok;"+tittel+";"+forfatter+";"+sideantall+";"+pris+"\n");
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        @Override
        public boolean lesObjektFraFil( DataInputStream input ) {
          try {
            super.lesObjektFraFil(input);
            målform = input.readUTF();
            return true;
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
            return false;
          }
          //< Leser verdier fra fil og lagrer dem i de tilhørende datafeltene. >
        }
}