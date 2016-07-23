package su.levenetc.motosignal.managers;

import android.content.Context;
import android.content.Intent;

import su.levenetc.motosignal.services.GCMRegistrationService;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public class ServicesManagerImpl implements ServicesManager {

	private Context context;

	public ServicesManagerImpl(Context context) {
		this.context = context;
	}

	@Override public void startGCMRegistration() {
		context.startService(new Intent(context, GCMRegistrationService.class));
	}
}
