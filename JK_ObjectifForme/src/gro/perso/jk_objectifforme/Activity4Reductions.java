package gro.perso.jk_objectifforme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class Activity4Reductions extends Activity {

	ImageView mImageQrCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity4_reductions);
		mImageQrCode = (ImageView) findViewById(R.id.activityReduction_imageview_qrcode);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity4_reductions, menu);
		return true;
	}

}
