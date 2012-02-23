package oblig1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BokArkiv extends JFrame
{
	JTextField forfatter, tittel, sideantall, pris, fagområde, skolefag, klassetrinn, sjanger, målform, språk;
	JButton regFag, regSkole, regNRoman, regURoman, visBøker, lagre;
	JTextArea display;
	
	private Bokregister register = new Bokregister();
	
	public BokArkiv()
	{
		super("BokArkiv");
	
		forfatter 	= new JTextField(20);
		tittel  	= new JTextField(20);
		sideantall	= new JTextField(7);
		pris		= new JTextField(7);
		fagområde 	= new JTextField(20);
		skolefag	= new JTextField(20);
		klassetrinn	= new JTextField(4);
		sjanger		= new JTextField(10);
		målform		= new JTextField(2);
		språk		= new JTextField(15); 
		
		display = new JTextArea(15, 45);
		display.setEditable(false);
		JScrollPane scroll = new JScrollPane(display);
		
		regFag 		= new JButton("Registrer fagbok");
		regSkole 	= new JButton("Registrer skolebok");
		regNRoman	= new JButton("Registrer norsk roman");
		regURoman 	= new JButton("Registrer utenlandsk roman");
		visBøker 	= new JButton("Vis bokregister");
		lagre           = new JButton("SAVE THAT BITHC");
		Knappelytter lytter = new Knappelytter();
		regFag.addActionListener(lytter);
		regSkole.addActionListener(lytter);
		regNRoman.addActionListener(lytter);
		regURoman.addActionListener(lytter);
		visBøker.addActionListener(lytter);
		lagre.addActionListener(lytter);
	
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add(new JLabel("Forfatter:"));
		c.add(forfatter);
		c.add(new JLabel("Tittel:"));
		c.add(tittel);
		c.add(new JLabel("Sideantall:"));
		c.add(sideantall);
		c.add(new JLabel("Pris:"));
		c.add(pris);
		c.add(new JLabel("Fagområde:"));
		c.add(fagområde);
		c.add(new JLabel("Skolefag:"));
		c.add(skolefag);
		c.add(new JLabel("Klassetrinn:"));
		c.add(klassetrinn);
		c.add(new JLabel("Sjanger:"));
		c.add(sjanger);
		c.add(new JLabel("Målform:"));
		c.add(målform);
		c.add(new JLabel("Språk:"));
		c.add(språk);
		
		c.add(regFag);
		c.add(regSkole);
		c.add(regNRoman);
		c.add(regURoman);
		c.add(visBøker);
		c.add(lagre);
		c.add(scroll);
		
		
		setSize(550, 500);
		setVisible(true);
	}
	
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == regFag)
				registrerFagBok();
			else if(e.getSource() == regSkole)
				registrerSkoleBok();
			else if(e.getSource() == regNRoman)
				registrerNorskRoman();
			else if(e.getSource() == regURoman)
				registrerUtenlandskRoman();
			else if (e.getSource() == visBøker)
				visBøker();
                        else if (e.getSource() == lagre)
                                lagre();
		}

    private void lagre() {
      register.skrivTilfil("Kittens.txt");
    }
	}
	
	public void registrerFagBok()
	{
		String 	f 	= forfatter.getText();
		String 	t 	= tittel.getText();
		String fa	= fagområde.getText();
		
		if(f.length() == 0 || t.length() == 0 || fa.length() == 0)
		{
			melding("Fyll inn de nødvendige feltene!");
			return;
		}
		
		try
		{
			int 	s 	= Integer.parseInt(sideantall.getText());
			double 	p 	= Double.parseDouble(pris.getText());
		
			register.settInn( new Fagbok(f, t, s, p, fa) );
			melding("Fagboken er registrert.");
		}
		catch(NumberFormatException nfe)
		{
			melding("Feil talltyper!");
		}
	}
	
	public void registrerSkoleBok()
	{
		String 	f 	= forfatter.getText();
		String 	t 	= tittel.getText();
		String sk	= skolefag.getText();
		
		if(f.length() == 0 || t.length() == 0 || sk.length() == 0)
		{
			melding("Fyll inn de nødvendige feltene!");
			return;
		}
		
		try
		{
			int 	s 	= Integer.parseInt(sideantall.getText());
			int		kl	= Integer.parseInt(klassetrinn.getText());
			double 	p 	= Double.parseDouble(pris.getText());
		
			register.settInn( new Skolebok(f, t, s, p, kl, sk) );
			melding("Skoleboken er registrert.");
		}
		catch(NumberFormatException nfe)
		{
			melding("Feil talltyper!");
		}
	}
	
	public void registrerNorskRoman()
	{
		String 	f 	= forfatter.getText();
		String 	t 	= tittel.getText();
		String må	= målform.getText();
		String sj	= sjanger.getText();
		
		if(f.length() == 0 || t.length() == 0 || må.length() == 0)
		{
			melding("Fyll inn de nødvendige feltene!");
			return;
		}
		
		try
		{
			int 	s 	= Integer.parseInt(sideantall.getText());
			double 	p 	= Double.parseDouble(pris.getText());
		
			register.settInn( new NorskRoman(f, t, s, p, sj, må) );
			melding("(Norsk) Roman er nå registrert.");
		}
		catch(NumberFormatException nfe)
		{
			melding("Feil talltyper!");
		}
	}
	
	public void registrerUtenlandskRoman()
	{
		String 	f 	= forfatter.getText();
		String 	t 	= tittel.getText();
		String sp	= språk.getText();
		String sj	= sjanger.getText();
		
		if(f.length() == 0 || t.length() == 0 || sp.length() == 0)
		{
			melding("Fyll inn de nødvendige feltene!");
			return;
		}
		
		try
		{
			int 	s 	= Integer.parseInt(sideantall.getText());
			double 	p 	= Double.parseDouble(pris.getText());
		
			register.settInn( new UtenlandskRoman(f, t, s, p, sj, sp) );
			melding("(Utenlandsk) Roman er nå registrert.");
		}
		catch(NumberFormatException nfe)
		{
			melding("Feil talltyper!");
		}
	}
	
	public void visBøker()
	{
		register.skrivListe(display);
	}
	
	private void melding(String m)
	{
		JOptionPane.showMessageDialog(null, m);
	}
	
}