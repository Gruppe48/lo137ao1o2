package oblig1;

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
}