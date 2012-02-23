package oblig1;

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
}