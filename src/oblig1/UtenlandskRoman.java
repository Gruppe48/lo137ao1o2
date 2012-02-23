public class UtenlandskRoman extends Roman
{
	private String språk;
	
	public UtenlandskRoman(String f, String t, int s, double p, String sj, String sp)
	{
		super(f, t, s, p, sj);
		språk = sp;
	}
	
	public String toString()
	{
		return super.toString() + "Språk: " + språk + "\n";
	}
}