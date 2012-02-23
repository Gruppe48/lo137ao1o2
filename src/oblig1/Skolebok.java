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
	
	public String toString()
	{
		return super.toString() + "Klassetrinn: " + klassetrinn + "\nSkolefag: " + skolefag + "\n";
	}
}