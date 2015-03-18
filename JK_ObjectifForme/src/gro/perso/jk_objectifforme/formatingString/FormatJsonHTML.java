package gro.perso.jk_objectifforme.formatingString;

import gro.perso.jk_objectifforme.JsonTrainingParser.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FormatJsonHTML {

	final static String BALISE_SOULIGNE_DEBUT = "<u>";
	final static String BALISE_SOULIGNE_FIN = "</u>";
	final static String SAUT_DE_LIGNE = "<br/>";
	final static String TIRET = "-";
	final static String ESPACE = " ";

	final static String REPETITION_LIBELLE = "repetition";
	final static String MINUTES_LIBELLE = "minute";
	final static String SECONDES_LIBELLE = "seconde";

	final static String REPETITION_SYMBOLE = ".";
	final static String MINUTES_SYMBOLE = "'";
	final static String SECONDES_SYMBOLE = "''";
	final static String DEUX_POINT = " : ";

	final static int TYPE_ECHAUFFEMENT = 1;
	final static int TYPE_SERIE = 2;
	final static int TYPE_RECUPERATION = 3;

	// Initialisation de la map de conversion unite => symbole
	final static HashMap<String, String> mapSymbole = new HashMap<String, String>();
	static {
		mapSymbole.put(REPETITION_LIBELLE, REPETITION_SYMBOLE);
		mapSymbole.put(MINUTES_LIBELLE, MINUTES_SYMBOLE);
		mapSymbole.put(SECONDES_LIBELLE, SECONDES_SYMBOLE);
	}

	public FormatJsonHTML() {
		super();
	}

	public String formatTitre(String titre) {
		return BALISE_SOULIGNE_DEBUT + titre + BALISE_SOULIGNE_FIN;
	}

	public String listItem(List<Item> listItem) {
		StringBuilder result = new StringBuilder();

		List<Item> listeEchauffement = new ArrayList<Item>();
		List<Item> listeSerie = new ArrayList<Item>();
		List<Item> listeRecuperation = new ArrayList<Item>();

		for (Item i : listItem) {
			if (i.getType().equalsIgnoreCase("echauffement")) {
				listeEchauffement.add(i);
			}
			if (i.getType().equalsIgnoreCase("serie")) {
				listeSerie.add(i);
			}
			if (i.getType().equalsIgnoreCase("recuperation")) {
				listeRecuperation.add(i);
			}
		}

		result.append(formatList(TYPE_ECHAUFFEMENT, listeEchauffement));
		result.append(formatList(TYPE_SERIE, listeSerie));
		result.append(formatList(TYPE_RECUPERATION, listeRecuperation));


		return result.toString();
	}

	private String formatList(int type, List<Item> list) {
		StringBuilder result = new StringBuilder();

		// titre de la sous-catégorie
		switch (type) {
		case 1:
			result.append(formatTitre("Echauffement:"));
			result.append(SAUT_DE_LIGNE);
			break;
		case 2:
			result.append(formatTitre("Serie:"));
			result.append(SAUT_DE_LIGNE);
			break;
		case 3:
			result.append(formatTitre("Recupération:"));
			result.append(SAUT_DE_LIGNE);
			break;
		}

		for (Item i : list) {
			result.append(formatItem(i));
			result.append(SAUT_DE_LIGNE);
		}

		result.append(SAUT_DE_LIGNE);
		result.append(SAUT_DE_LIGNE);
		return result.toString();
	}
	/**
	 * Formatage d'un item
	 * 
	 * ex: - 7 pompes. - 10 abdo - Corde a sauter : 30''
	 * 
	 * @param it
	 * @return
	 */
	public String formatItem(Item it) {
		StringBuilder itemFormat = new StringBuilder();

		// selon le type de repetition
		if (it.getUnite().equalsIgnoreCase(REPETITION_LIBELLE)) {
			itemFormat.append(TIRET);
			itemFormat.append(it.getNombre());
			itemFormat.append(ESPACE);
			itemFormat.append(it.getIntitule());
			itemFormat.append(ESPACE);
			itemFormat.append(getSymboleFromUnite(it.getUnite()));
		} else {
			itemFormat.append(TIRET);
			itemFormat.append(it.getIntitule());
			itemFormat.append(DEUX_POINT);
			itemFormat.append(it.getNombre());
			itemFormat.append(ESPACE);
			itemFormat.append(getSymboleFromUnite(it.getUnite()));
		}

		return itemFormat.toString();
	}

	public String getSymboleFromUnite(String unite) {
		return mapSymbole.get(unite);
	}
}
