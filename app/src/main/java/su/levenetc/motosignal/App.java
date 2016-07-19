package su.levenetc.motosignal;

import android.app.Application;

import su.levenetc.motosignal.api.ApiManager;

/**
 * Created by Eugene Levenetc on 17/07/2016.
 */
public class App extends Application {
	@Override public void onCreate() {
		super.onCreate();
		ApiManager.init();
	}
}
