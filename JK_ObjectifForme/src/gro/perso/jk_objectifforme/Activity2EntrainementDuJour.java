package gro.perso.jk_objectifforme;

import gro.perso.jk_objectifforme.JsonTrainingParser.Entrainement;
import gro.perso.jk_objectifforme.formatingString.FormatJsonHTML;
import gro.perso.jk_objectifforme.request.HttpClient;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity2EntrainementDuJour extends Activity implements
		OnClickListener {

	private final String TYPE_DEBUTANT = "DEBUTANT";
	private final String TYPE_REGULIER = "REGULIER";
	private final String TYPE_CONFIRME = "CONFIRME";
	private final String TYPE_ULTRA = "ULTRA";

	private Button boutonEntrainementDebutant;
	private Button boutonEntrainementRegulier;
	private Button boutonEntrainementConfirme;
	private Button boutonEntrainementUltra;

	private String entrainementDebutant;
	private String entrainementRegulier;
	private String entrainementConfirme;
	private String entrainementUltra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2_entrainement_du_jour);

		boutonEntrainementDebutant = (Button) findViewById(R.id.activityEntrainementDuJour_ButtonDebutant);
		boutonEntrainementDebutant.setOnClickListener(this);
		boutonEntrainementRegulier = (Button) findViewById(R.id.activityEntrainementDuJour_ButtonRegulier);
		boutonEntrainementRegulier.setOnClickListener(this);
		boutonEntrainementConfirme = (Button) findViewById(R.id.activityEntrainementDuJour_ButtonConfirme);
		boutonEntrainementConfirme.setOnClickListener(this);
		boutonEntrainementUltra = (Button) findViewById(R.id.activityEntrainementDuJour_ButtonUltra);
		boutonEntrainementUltra.setOnClickListener(this);

		// pré-chargement des entrainements
		entrainementDebutant = chargementEntrainement(TYPE_DEBUTANT);
		entrainementRegulier = chargementEntrainement(TYPE_REGULIER);
		entrainementConfirme = chargementEntrainement(TYPE_CONFIRME);
		entrainementUltra = chargementEntrainement(TYPE_ULTRA);

	}

	private String chargementEntrainement(String type) {
		HttpClient rqtAjax = new HttpClient();
		String result = null;
		AsyncTask<String, Void, String> s = rqtAjax.execute(type);
		try {
			result = s.get().toString();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void onClick(View v) {
		ParseTrainingJson trObj = new ParseTrainingJson();
		FormatJsonHTML formatJsonHtml = new FormatJsonHTML();
		Entrainement training = new Entrainement();

		switch (v.getId()) {
		case R.id.activityEntrainementDuJour_ButtonDebutant:
			// Parse Json de l'entrainement
			training = trObj.getTraining(entrainementDebutant);
			// Formatage du JSON
			String desc = formatJsonHtml.listItem(training.getItems());

			// AlertDialog pour afficher l'entrainement
			exectAlertDialogAppel(getTitre(1), Html.fromHtml(desc));
			break;
		case R.id.activityEntrainementDuJour_ButtonRegulier:
			// pop up scrollview avec un entrainement recupéré a quel endroit ?
			exectAlertDialogAppel(getTitre(2), Html.fromHtml(getDescription(2)));
			break;
		case R.id.activityEntrainementDuJour_ButtonConfirme:
			// pop up scrollview avec un entrainement recupéré a quel endroit ?
			exectAlertDialogAppel(getTitre(3), Html.fromHtml(getDescription(3)));
			break;
		case R.id.activityEntrainementDuJour_ButtonUltra:
			// pop up scrollview avec un entrainement recupéré a quel endroit ?
			exectAlertDialogAppel(getTitre(4), Html.fromHtml(getDescription(4)));
			break;
		}

	}

	/**
	 * Fonction de pop up de l'entrainement
	 */
	private void exectAlertDialogAppel(Spanned titre, Spanned description) {
		AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);

		// Setting Dialog Title
		alertDialog2.setTitle(titre);

		// Setting Dialog Message
		alertDialog2.setMessage(description);

		// textView avec la description du type d'entrainement

		// Showing Alert Dialog
		alertDialog2.show();
	}

	/**
	 * Recuperation du titre selon l'entrainement en parametre
	 * 
	 * @param typeEntrainement
	 */
	private Spanned getTitre(int typeEntrainement) {
		Spanned titre = null;
		switch (typeEntrainement) {
		case 1:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite2_titreDebutant));
			break;
		case 2:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite2_titreRegulier));
			break;
		case 3:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite2_titreConfirme));
			break;
		case 4:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite2_titreUltra));
			break;
		}
		return titre;
	}

	/**
	 * Recuperation de la description du type d'entrainement en parametre
	 * 
	 * @param typeEntrainement
	 */
	private String getDescription(int typeEntrainement) {
		String titre = null;
		switch (typeEntrainement) {
		case 1:
			titre = "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant"
					+ "description entrainement debutant";
			break;
		case 2:
			titre = "description entrainement régulier";
			break;
		case 3:
			titre = "description entrainement confirmé";
			break;
		case 4:
			titre = "description entrainement ultra";
			break;
		}
		return titre;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity2_entrainement_du_jour, menu);
		return true;
	}

}
