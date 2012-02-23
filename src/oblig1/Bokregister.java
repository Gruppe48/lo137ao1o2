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
}