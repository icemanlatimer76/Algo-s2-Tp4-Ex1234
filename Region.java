public class Region
{
	private int 	numero;
	private String 	nom;
	private int 	nbDeptTotal; 
	private int 	nbDept;
	private Departement[] tabDepartement;

	public Region(int numero, String nom, int nbDeptTotal )
	{
		this.numero 		= numero;
		this.nom 			= nom;
		this.nbDeptTotal	= nbDeptTotal;
		this.tabDepartement = new Departement[nbDeptTotal];
		this.nbDept 		= 0;

	}

	public boolean ajouterDepartement(Departement dep)
	{
		if (nbDept >= nbDeptTotal)
		{
			return false;
		}
		this.tabDepartement[nbDept]	= dep;
		this.nbDept++;
		return true;

	}

	public int getNumero()
	{
		return this.numero;
	}

	public String getNom()
	{
		return this.nom;
	}
	public int getNbDept()
	{
		return this.nbDept;
	}
	public int getNbDeptTotal()
	{
		return this.nbDeptTotal;
	}
	public Departement getDept(int indice)
	{
		return this.tabDepartement[indice];
	}
	public int getSuperficie()
	{
		int superficie;

		superficie = 0;
		
		for (int i=0;i<nbDept;i++)
		{
			superficie += this.tabDepartement[i].getSuperficie();
		}
		
		return superficie;
	}
	public int getPopulation()
	{
		int population;

		population = 0;
		
		for (int i=0;i<nbDept;i++)
		{
			population += this.tabDepartement[i].getPopulation();
		}
		
		return population;

	}
	public double densite()
	{
		if (getPopulation() == 0 && getSuperficie() == 0 )
		{
			return 0;
		}
		return (getPopulation()/getSuperficie());

	}
	public String toString()
	{
		String s;
		s=" 	Region		\n";
		s+="Nom :\t\t\t"+ getNom() + "\n";
		s+="Numero :\t\t" + getNumero() + "\n";
		s+="Nombre Departement:\t"+ getNbDept()+ "\n"; 
		s+="Liste Departement :\t";

		for (int i=0;i<nbDept;i++)
		{
			s+="\n\t\t";
			s+=this.tabDepartement[i].getNumero()+" "+this.tabDepartement[i].getNom();
			
		}
		s+="\n";
		return s;
	}


}
