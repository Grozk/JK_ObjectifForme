package gro.perso.jk_objectifforme.qrCode;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class DownloadQRCodeGoogleChart extends AsyncTask<String, Void, Bitmap> {

	ImageView mImageQrCode = null;

	public DownloadQRCodeGoogleChart(ImageView bmImage) {
		this.mImageQrCode = bmImage;
	}

	protected Bitmap doInBackground(String... urls) {
		String urldisplay = urls[0];
		Bitmap mIcon11 = null;
		try {
			InputStream in = new java.net.URL(urldisplay).openStream();
			mIcon11 = BitmapFactory.decodeStream(in);
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}
		return mIcon11;
	}

	protected void onPostExecute(Bitmap result) {
		mImageQrCode.setImageBitmap(result);
	}

}