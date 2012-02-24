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
            //output.writeUTF("bok;"+tittel+";"+forfatter+";"+sideantall+";"+pris+"\n");
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