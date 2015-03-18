package gro.perso.jk_objectifforme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Launcher_activity extends Activity implements OnClickListener {

	private Button boutonDebuterEntrainement;
	private Button boutonEntrainementDuJour;
	private Button boutonSceanceAvecCoatch;
	private Button boutonGagneReductions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher_activity);

		boutonDebuterEntrainement = (Button) findViewById(R.id.launcher_buttonDebuterEntrainement);
		boutonDebuterEntrainement.setOnClickListener(this);
		boutonEntrainementDuJour = (Button) findViewById(R.id.launcher_buttonEntrainementDuJour);
		boutonEntrainementDuJour.setOnClickListener(this);
		boutonSceanceAvecCoatch = (Button) findViewById(R.id.launcher_buttonSceanceAvecJulien);
		boutonSceanceAvecCoatch.setOnClickListener(this);
		boutonGagneReductions = (Button) findViewById(R.id.launcher_buttonGagneReductions);
		boutonGagneReductions.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.launcher_buttonDebuterEntrainement:
			Intent intentCommentDebuter = new Intent(this,
					Activity1Commentdebuter.class);
			this.startActivity(intentCommentDebuter);
			break;
		case R.id.launcher_buttonEntrainementDuJour:
			Intent intentEntrainementDuJour = new Intent(this,
					Activity2EntrainementDuJour.class);
			this.startActivity(intentEntrainementDuJour);
			break;
		case R.id.launcher_buttonSceanceAvecJulien:
			Intent intentSceanceAvecCoatch = new Intent(this,
					Activity3SceanceAvecJulien.class);
			this.startActivity(intentSceanceAvecCoatch);
			break;
		case R.id.launcher_buttonGagneReductions:
			Intent intentGagneDesReductions = new Intent(this,
					Activity4Reductions.class);
			this.startActivity(intentGagneDesReductions);
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launcher_activity, menu);
		return true;
	}

}
