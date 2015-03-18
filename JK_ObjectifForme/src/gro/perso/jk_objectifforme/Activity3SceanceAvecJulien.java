package gro.perso.jk_objectifforme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class Activity3SceanceAvecJulien extends Activity implements
		OnClickListener {

	private TabHost myTabHost;
	private Button boutonAppelAuCoatch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity3_sceance_avec_julien);

		myTabHost = (TabHost) findViewById(android.R.id.tabhost);
		myTabHost.setup();

		// ajout des tab dans le tabhost
		myTabHost.addTab(myTabHost
				.newTabSpec("Solo")
				.setIndicator(
						"Solo",
						getResources().getDrawable(
								android.R.drawable.ic_menu_view))
				.setContent(R.id.activityEntrainementAvecCoatch_TableTab1));
		myTabHost.addTab(myTabHost
				.newTabSpec("Duo")
				.setIndicator(
						"Duo",
						getResources().getDrawable(
								android.R.drawable.ic_menu_view))
				.setContent(R.id.activityEntrainementAvecCoatch_TableTab2));
		myTabHost.addTab(myTabHost
				.newTabSpec("Trio")
				.setIndicator(
						"Trio",
						getResources().getDrawable(
								android.R.drawable.ic_menu_view))
				.setContent(R.id.activityEntrainementAvecCoatch_TableTab3));

		boutonAppelAuCoatch = (Button) findViewById(R.id.activityEntrainementAvecCoatch_ButtonCallCoatch);
		boutonAppelAuCoatch.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity3_sceance_avec_julien, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activityEntrainementAvecCoatch_ButtonCallCoatch:
			exectAlertDialogAppel();
			break;
		}

	}

	/**
	 * Fonction d'appel au coatch
	 */
	private void exectAlertDialogAppel() {
		AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);

		// Setting Dialog Title
		alertDialog2.setTitle("Appelez le coatch!");

		// Setting Dialog Message
		alertDialog2
				.setMessage("Etes vous sur(e) de vouloir appeler votre coatch ?");

		// Setting Positive "Yes" Btn
		alertDialog2.setPositiveButton("Oui",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Write your code here to execute after dialog
						Toast.makeText(getApplicationContext(),
								"Appel au coatch!", Toast.LENGTH_SHORT).show();
						String url = "tel:0664823274";
						Intent intent = new Intent(Intent.ACTION_CALL, Uri
								.parse(url));
						startActivity(intent);
					}
				});
		// Setting Negative "NO" Btn
		alertDialog2.setNegativeButton("Non",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// Fermeture de la boite de dialogue
						dialog.cancel();
					}
				});

		// Showing Alert Dialog
		alertDialog2.show();
	}

}
