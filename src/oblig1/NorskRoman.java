package oblig1;

public class NorskRoman extends Roman
{
	private String målform;
	
	public NorskRoman(String f, String t, int s, double p, String sj, String må)
	{
		super(f, t, s, p, sj);
		målform = må;
	}
	
	public String toString()
	{
		return super.toString() + "Målform: " + målform + "\n";
	}
}