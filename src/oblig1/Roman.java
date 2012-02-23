package oblig1;

public abstract class Roman extends Bok 
{
	protected String sjanger;
	
	protected Roman(String f, String t, int s, double p, String sj)
	{
		super(f, t, s, p);
		sjanger = sj;
	}
	
        @Override
	public String toString()
	{
		return super.toString() + "Sjanger: " + sjanger + "\n";
	}
}