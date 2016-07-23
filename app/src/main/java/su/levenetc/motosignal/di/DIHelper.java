package su.levenetc.motosignal.di;

import android.content.Context;

import su.levenetc.motosignal.di.components.AppComponent;
import su.levenetc.motosignal.di.components.DaggerAppComponent;
import su.levenetc.motosignal.di.modules.ServicesModule;
import su.levenetc.motosignal.di.modules.SettingsModule;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public class DIHelper {

	private static AppComponent appComponent;

	public static void init(Context context) {
		appComponent = DaggerAppComponent.builder()
				.settingsModule(new SettingsModule())
				.servicesModule(new ServicesModule(context))
				.build();
	}

	public static AppComponent getAppComponent() {
		return appComponent;
	}
}
