package gro.perso.jk_objectifforme.request;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class HttpClient extends AsyncTask<String, Void, String> {

	private static String BASE_URL = "http://geolocproject.alwaysdata.net/geolocproject/";


	public String getTraining(String type) {
		HttpURLConnection con = null;
		InputStream is = null;
		StringBuffer buffer = null;
		try {
			System.out.println("Debut de la demande");
			con = (HttpURLConnection) (new URL(BASE_URL/*
														 * ajout du type lorsque
														 * le serveur sera OK
														 */)
					.openConnection());
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();

			// Let's read the response
			buffer = new StringBuffer();
			con.getResponseCode();
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null)
				buffer.append(line + "\r\n");

			is.close();
			con.disconnect();
			System.out.println(buffer.toString());
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Throwable t) {
			}
			try {
				con.disconnect();
			} catch (Throwable t) {
			}
		}

		return buffer.toString();

	}

	@Override
	protected String doInBackground(String... arg0) {
		return getTraining(arg0[0]);
	}



}
