public class Fagbok extends Bok
{
	private String fagområde;
	
	public Fagbok(String f, String t, int s, double p, String fa)
	{
		super(f, t, s, p);
		fagområde = fa;
	}
	
	public String toString()
	{
		return super.toString() + "Fagområde: " + fagområde + "\n";
	}
}