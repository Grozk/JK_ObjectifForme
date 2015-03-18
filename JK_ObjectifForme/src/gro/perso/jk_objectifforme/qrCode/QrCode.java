package gro.perso.jk_objectifforme.qrCode;

import java.util.concurrent.ExecutionException;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class QrCode {

	Bitmap mImageQrCode = null;
	DownloadQRCodeGoogleChart googleChart;

	public QrCode(ImageView imageView, String uri) {

		// Recuperation du QRCode
		googleChart = new DownloadQRCodeGoogleChart(imageView);

		try {
			this.mImageQrCode = googleChart.execute(uri).get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
