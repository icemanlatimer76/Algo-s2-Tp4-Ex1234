import java.io.FileReader;
import java.util.Scanner;
import iut.algo.*;

/**
 * Class Demographie
 * 
 * @author Philippe Le Pivert
 */

public class Demographie {

	public static void main(String[] a) {
		Departement[] ensDepartements = new Departement[100]; // @1
		Region[] ensRegions = new Region[18];

		// Question 4.1
		System.out.println("Etape 1");
		Demographie.chargerDept(ensDepartements);
		Demographie.afficherDept(ensDepartements);

		// Question 4.2
		System.out.println("Etape 2");
		Demographie.chargerRegion(ensRegions);
		Demographie.afficherRegion(ensRegions);

		// Question 4.3

		System.out.println("Etape 3");
		Demographie.lierRegionDept(ensRegions, ensDepartements);
		Demographie.afficherRegion(ensRegions);
		Demographie.afficherRegionAvecDept(ensRegions);

	}

	// Question 4.1
	private static void chargerDept(Departement[] tab) {
		int i = 0;
		String ligne;
		FileReader fr;
		try {
			fr = new FileReader("departement.data");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				ligne = sc.nextLine();
				Decomposeur dec = new Decomposeur(ligne);

				tab[i] = new Departement(dec.getString(0), dec.getString(1), dec.getInt(2), dec.getInt(3));
				i++;

			}

			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Question 4.2
	// Attention on ne fait pas encore les liens entre une Region et ses
	// départements
	private static void chargerRegion(Region[] tab) {
		int i = 0;
		String ligne;
		FileReader fr;
		Decomposeur dec;
		try {
			fr = new FileReader("region.data");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				ligne = sc.nextLine();
				dec = new Decomposeur(ligne);

				tab[i] = new Region(dec.getInt(0), dec.getString(1), dec.getInt(2));
				i++;

			}

			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Question 4.3

	public static void lierRegionDept(Region[] tabRegion, Departement[] tabDept) {
		int indice = 0;
		String ligne;
		FileReader fr;
		try {
			fr = new FileReader("region.data");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				ligne = sc.nextLine();
				Decomposeur dec = new Decomposeur(ligne);

				indice = rechercherRegion(tabRegion, dec.getString(1));
				if (indice >= 0) {
					for (int j = 3; j < dec.getInt(2) + 3; j++) {
						tabRegion[indice].ajouterDepartement(rechercherDept(tabDept, dec.getString(j)));
					}
				}
			}

			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Question 4.1
	private static void afficherDept(Departement[] tab) {
		String chaine = "+----+-----------------------+----------+----------+--------+\n"
				+ "|num |nom                    |population|superficie|densite |\n"
				+ "+----+-----------------------+----------+----------+--------+\n";

		for (int cpt = 0; cpt < tab.length; cpt++) {
			if (tab[cpt] != null) {

				chaine += String.format("|%4s|%23s|%10s|%10s|%8s|", tab[cpt].getNumero(), tab[cpt].getNom(),
						tab[cpt].getPopulation(), tab[cpt].getSuperficie(), tab[cpt].densite()) + "\n";

			}
		}
		chaine += "+----+-----------------------+----------+----------+--------+\n";

		System.out.println(chaine);
	}

	// Question 4.2
	// Attention à la remarque @1
	private static void afficherRegion(Region[] tab) {
		String chaine = "+----+---------------------------+----------+----------+--------+\n"
				+ "|num |nom                        |population|superficie|densite |\n"
				+ "+----+---------------------------+----------+----------+--------+\n";

		for (int cpt = 0; cpt < tab.length; cpt++) {
			if (tab[cpt] != null) {
				chaine += String.format("|%4s|%27s|%10s|%10s|%8s|", tab[cpt].getNumero(), tab[cpt].getNom(),
						tab[cpt].getPopulation(), tab[cpt].getSuperficie(), tab[cpt].densite()) + "\n";
			}
		}
		chaine += "+----+---------------------------+----------+----------+--------+\n";

		System.out.println(chaine);

	}

	// Question 4.3
	private static void afficherRegionAvecDept(Region[] tab) {
		for (int cpt = 0; cpt < tab.length; cpt++)
			System.out.println(tab[cpt]);
	}

	private static Departement rechercherDept(Departement[] tab, String numero) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null && tab[i].getNumero().equals(numero)) {
				return tab[i];
			}
		}
		return null;
	}

	private static int rechercherRegion(Region[] tab, String nom) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null && tab[i].getNom().equals(nom)) {
				return i;
			}
		}
		return -1;
	}

}

/*----*/
/* @1 */
/*-----------------------------------------------------------------*/
/*
 * Afin de vous faciliter la tâche j'affecte en dur ent
 */
/*
 * Il aurait été plus judicieux fois les deux naitre / /* le nombre précis de
 * départements et de r gions.
 */
/* Attention si la valeur 101 est bonne la valeur 27, elle ne */
/* l'est pas. Elle est en effet trop grande, mais cela ne doit pas */
/* empêcher votre programme de fonctionner, à vous d'être vigilant */
/*
 * quand vous parcourerez tabRegion de tester qu'un élément
 */
/*-----------------------------------------------------------------*/
