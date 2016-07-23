package su.levenetc.motosignal;

import android.app.Application;

import su.levenetc.motosignal.api.ApiManager;
import su.levenetc.motosignal.di.DIHelper;

/**
 * Created by Eugene Levenetc on 17/07/2016.
 */
public class App extends Application {
	@Override public void onCreate() {
		super.onCreate();
		DIHelper.init(this);
		ApiManager.init();
	}
}
