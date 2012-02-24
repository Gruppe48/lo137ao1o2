package oblig1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fagbok extends Bok
{
	private String fagområde;
	
	public Fagbok(String f, String t, int s, double p, String fa)
	{
		super(f, t, s, p);
		fagområde = fa;
	}
	
        @Override
	public String toString()
	{
		return super.toString() + "Fagområde: " + fagområde + "\n";
	}
        @Override
        public void skrivObjektTilFil( DataOutputStream output ) {
          try {
            // Skriver datafeltenes verdier til fil. >
            output.writeUTF("Fagbok");
            super.skrivObjektTilFil(output);
            output.writeUTF(fagområde);
            //output.writeUTF("bok;"+tittel+";"+forfatter+";"+sideantall+";"+pris+"\n");
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        @Override
        public boolean lesObjektFraFil( DataInputStream input ) {
          try {
            super.lesObjektFraFil(input);
            fagområde = input.readUTF();
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
          //< Leser verdier fra fil og lagrer dem i de tilhørende datafeltene. >
          return false;
        }
}