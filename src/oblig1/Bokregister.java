package oblig1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Bokregister
{
  private Bok første;

  //registrerer et bokobjekt
  public void settInn( Bok ny )
  {
	if (ny == null)
		return;
	else if (første == null)
	{
		første = ny;
		return;
	}
	
	Bok hjelpebok = første;
	
	while(hjelpebok.neste != null)
	{
		hjelpebok = hjelpebok.neste;
	}
	
	hjelpebok.neste = ny;
    
  }

  //utskrift av innhold i bokliste
  public void skrivListe( JTextArea bøker )
  {
    //Gjennomløper lista av Bok-objekter og tilføyer i tekstområdet
    //bøker informasjonen som er lagret om hver enkelt bok.
	if(første == null)
	{
		bøker.setText("Tom bokliste!"); 
		return;
	}
	
	bøker.setText("");
	
	Bok hjelpebok = første;
	
	while(hjelpebok != null)
	{
		bøker.append(hjelpebok.toString() + "\n");
		hjelpebok = hjelpebok.neste;
	}
	
  }
  
  public void skrivTilfil( String filnavn ) {
    try {
      /*< Åpne riktig filtype.
      Gjennomløp lista og skriv objekt for objekt til fil
      vha skrivObjektTilFil-metoden i Bok-klassen >*/
      DataOutputStream dout = new DataOutputStream(new FileOutputStream(filnavn));
      Bok hjelpebok = første;
      
      while (hjelpebok != null) {
        hjelpebok.skrivObjektTilFil(dout);
        hjelpebok = hjelpebok.neste;
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Bokregister.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void lesFraFil( String filnavn ) throws IOException {
    /*< Åpne riktig filtype.
    For alle objektene som det finns data til på filen:
      Opprett riktig type Bok-objekt ut fra informasjonen på filen.
      Fyll objektet med data fra filen vha lesObjektFraFil-metoden
      i Bok-klassen.
      Sett Bok-objektet inn i lista. >*/
    
    try {
      DataInputStream din = new DataInputStream(new FileInputStream(filnavn));
      while (true) {
        String type = din.readUTF();
      
        if (type.equals("Fagbok")) {
          Fagbok fagbok = new Fagbok("Ingen","Ingen",0,0.00,"Ingen");
          if (fagbok.lesObjektFraFil(din)) {
            settInn(fagbok);
          }
        }
        else if (type.equals("Skolebok")) {
          Skolebok skolebok = new Skolebok("Ingen","Ingen",0,0.00,0, "Ingen");
          if (skolebok.lesObjektFraFil(din)) {
            settInn(skolebok);
          }
        }
        else if (type.equals("Norskroman")) {
          NorskRoman roman = new NorskRoman("Ingen","Ingen",0,0.00,"Ingen", "Ingen");
          if (roman.lesObjektFraFil(din)) {
            settInn(roman);
          }
        } 
        else if (type.equals("Utenlandskroman")) {
          UtenlandskRoman ulroman = new UtenlandskRoman("Ingen","Ingen",0,0.00,"Ingen", "Ingen");
          if (ulroman.lesObjektFraFil(din)) {
            settInn(ulroman);
          }
        }   
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Bokregister.class.getName()).log(Level.SEVERE, null, ex);
    } catch (EOFException ex) {
      System.out.println("Ferdig lastet.");
    }
  }
}