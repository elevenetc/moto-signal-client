package su.levenetc.motosignal.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import su.levenetc.motosignal.managers.ServicesManager;
import su.levenetc.motosignal.managers.ServicesManagerImpl;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
@Module
public class ServicesModule {

	private Context context;

	public ServicesModule(Context context) {
		this.context = context;
	}

	@Provides @Singleton public ServicesManager provideServicesManager() {
		return new ServicesManagerImpl(context);
	}
}
