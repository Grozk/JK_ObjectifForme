package gro.perso.jk_objectifforme;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity1Commentdebuter extends Activity {

	private ListView listView;
	private final String PST_BIENETRE = "Prestation \"bien-être\"";
	private final String PST_PERF = "Prestation \"Performance\"";
	private final String PST_ENTREPRISE = "Coatch en entreprise";

	private Spanned detailPrestaBienEtre;
	private Spanned detailPrestaPerf;
	private Spanned detailPrestaEnEntreprise;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1_commentdebuter);

		listView = (ListView) findViewById(R.id.activityCommentDebuter_listViewPrestations);

		// Defined Array values to show in ListView
		String[] values = new String[] { PST_BIENETRE, PST_PERF, PST_ENTREPRISE };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		//chargement detail prestation
		chargementDetailPresta();
		
		// Assign adapter to ListView
		listView.setAdapter(adapter);

		// ListView Item Click Listener
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// ListView Clicked item index
				int itemPosition = position;

				// ListView Clicked item value
				String itemValue = (String) listView
						.getItemAtPosition(position);

				if (itemValue.equalsIgnoreCase(PST_BIENETRE)) {
					exectAlertDialogAppel(getTitre(1),detailPrestaBienEtre);
				}
				if (itemValue.equalsIgnoreCase(PST_PERF)) {
					exectAlertDialogAppel(getTitre(2), detailPrestaPerf);
				}
				if (itemValue.equalsIgnoreCase(PST_ENTREPRISE)) {
					exectAlertDialogAppel(getTitre(3), detailPrestaEnEntreprise);
				}

			}

		});
	}

	/**
	 * Fonction de pop up da description de la prestation
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
	private Spanned getTitre(int typePrestation) {
		Spanned titre = null;
		switch (typePrestation) {
		case 1:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite1_titrePrestationBienEtre));
			break;
		case 2:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite1_titrePrestationPerformance));
			break;
		case 3:
			titre = Html.fromHtml(getResources().getString(
					R.string.activite1_titrePrestationEntreprise));
			break;
		}
		return titre;
	}

	private void chargementDetailPresta() {
		detailPrestaBienEtre = Html.fromHtml(getResources().getString(
				R.string.activite1_detailPrestationBienEtre));
		detailPrestaPerf = Html.fromHtml(getResources().getString(
				R.string.activite1_detailPrestationPerformance));
		detailPrestaEnEntreprise = Html.fromHtml(getResources().getString(
				R.string.activite1_detailPrestationEntreprise));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity1_commentdebuter, menu);
		return true;
	}

}
