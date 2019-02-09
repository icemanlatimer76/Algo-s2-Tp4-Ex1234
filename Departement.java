public class Departement
{
	private String 	numero;
	private String 	nom;
	private int 	population; 
	private int 	superficie;

	public Departement(String numero, String nom, int population , int superficie)
	{
		this.numero 	= numero;
		this.nom 		= nom;
		this.population = population;
		this.superficie = superficie;

	}

	public String getNumero()
	{
		return this.numero;
	}

	public String getNom()
	{
		return this.nom;
	}
	
	public int getPopulation()
	{
		return this.population;
	}

	public int getSuperficie()
	{
		return this.superficie;
	}
	
	public double densite()
	{
		return (int)((((double)this.population)/this.superficie)*100)/100.0;
	}
	public String toString()
	{
		String s;
		s= getNom() +"\t"+ getPopulation() +" hab\t"+ getSuperficie() +"km² \t"+ densite()+" hab/km²";   
		return s;
	}

}