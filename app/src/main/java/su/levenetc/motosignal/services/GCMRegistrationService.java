package su.levenetc.motosignal.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import su.levenetc.motosignal.R;

/**
 * Created by Eugene Levenetc on 18/07/2016.
 */
public class GCMRegistrationService extends IntentService {

	private static final String TAG = "RegIntentService";

	public GCMRegistrationService() {
		super(TAG);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		try {
			InstanceID instanceID = InstanceID.getInstance(this);
			String token = instanceID.getToken(getString(R.string.gcmSenderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
			Log.i(TAG, "GCM Registration Token: " + token);

			sendToServer(token);
			sharedPreferences.edit().putBoolean("GCM-token", true).apply();
		} catch (Exception e) {
			sharedPreferences.edit().putBoolean("GCM-token", false).apply();
		}
	}

	private void sendToServer(String token) {

	}

}
