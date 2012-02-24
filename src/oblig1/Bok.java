package oblig1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Bok
{
	private String forfatter;
	private String tittel;
	private int sideantall;
	private double pris;
	Bok neste;
	
	public Bok(String f, String t, int s, double p)
	{
		forfatter 	= f;
		tittel 		= t;
		sideantall	= s;
		pris		= p; 
		neste		= null;
	}
	
	public String toString()
	{
		return "Tittel: " + tittel + "\nForfatter: " + forfatter + "\nsideantall: " + sideantall + "\npris: " + pris + ",-\n";
	}
        
        public void skrivObjektTilFil( DataOutputStream output ) {
          try {
            // Skriver datafeltenes verdier til fil. >
            output.writeUTF(forfatter);
            output.writeUTF(tittel);
            output.writeInt(sideantall);
            output.writeDouble(pris);
            //output.writeUTF("bok;"+tittel+";"+forfatter+";"+sideantall+";"+pris+"\n");
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
        }

        public boolean lesObjektFraFil( DataInputStream input ) {
          try {
            forfatter = input.readUTF();
            tittel = input.readUTF();
            sideantall = input.readInt();
            pris = input.readDouble();
          } catch (IOException ex) {
            Logger.getLogger(Bok.class.getName()).log(Level.SEVERE, null, ex);
          }
          //< Leser verdier fra fil og lagrer dem i de tilhørende datafeltene. >
          return false;
        }
}