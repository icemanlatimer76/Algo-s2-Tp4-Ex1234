import java.io.*;
import iut.algo.*;
import java.util.Scanner;
import java.text.DecimalFormat;

/** TestRegion
  * @author Philippe Le pivert
  */

public class TestRegion
{
	public static void main(String[] a)
	{
		Departement[] ensDepartements = new Departement[ 150  ];   // on prend un nombre suffisament grand
		Region     [] ensRegions      = new Region     [  30  ];   // "    "   "    "        "         "

		chargeDepartement(ensDepartements);
		chargeRegion(ensRegions,ensDepartements);


		System.out.println( afficherRegion(ensRegions) );

/* 	
		ensRegions[0]      = new Region (28,"Normandie",5);
		ensRegions[1]      = new Region (1,"Guadeloupe",1);


		ensRegions[0].ajouterDepartement ( ensDepartements[0] );
		ensRegions[0].ajouterDepartement ( ensDepartements[1] );
		ensRegions[0].ajouterDepartement ( ensDepartements[2] );
		ensRegions[0].ajouterDepartement ( ensDepartements[3] );
		ensRegions[0].ajouterDepartement ( ensDepartements[4] );
		  
		

		ensRegions[1].ajouterDepartement ( ensDepartements[5] );
		
		

		Console.println ( ensRegions[0] );
		Console.println ( ensRegions[1] );

		Console.println("Quel département voulez-vous détailler : ");
		Console.println(rechercherDept( ensDepartements ,Clavier.lireString()));
*/

	}

	private static Departement rechercherDept (Departement[] tab, String numero)
	{
		for(int i=0; i < tab.length;i++)
		{
			if (tab[i]!= null && tab[i].getNumero().equals(numero))
			{	
				return tab[i];
			} 
		}
		return null;
	}

	public static void chargeDepartement(Departement[] tab)
	{
		int i=0;
		String ligne;
		FileReader fr;
		try
		{
			fr = new FileReader( "departement.data");
			Scanner sc = new Scanner ( fr );

			while ( sc.hasNext() )
			{
				ligne = sc.nextLine();
				Decomposeur dec = new Decomposeur (ligne);
				
				tab[i] = new Departement(dec.getString(0),dec.getString(1),dec.getInt(2),dec.getInt(3));
				i++;
				
			}

			fr.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	public static String afficherDepartement(Departement[] tab)
	{
		String s;
		s="";
		for (int i=0;i<tab.length;i++)
		{
			if (tab[i] == null)
			{
				return s;
			}
			s+= tab[i].toString()+"\n";
		}
		return s;
	}

	public static void chargeRegion(Region[] tab, Departement[] tab2)
	{
		int i=0;
		String ligne;
		FileReader fr;
		try
		{
			fr = new FileReader( "region.data");
			Scanner sc = new Scanner ( fr );

			while ( sc.hasNext() )
			{
				ligne = sc.nextLine();
				Decomposeur dec = new Decomposeur (ligne);
				
				tab[i] = new Region(dec.getInt(0),dec.getString(1),dec.getInt(2));
				for (int j=3; j < dec.getInt(2)+3;j++)
				{
					tab[i].ajouterDepartement(rechercherDept(tab2,dec.getString(j)));
				}

				i++;
				
			}

			fr.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	public static String afficherRegion(Region[] tab)
	{
		String s;
		s="";
		for (int i=0;i<tab.length;i++)
		{
			if (tab[i] == null)
			{
				return s;
			}
			s+= tab[i].toString()+"\n";
		}
		return s;
	}

}
