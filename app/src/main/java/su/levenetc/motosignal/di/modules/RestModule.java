package su.levenetc.motosignal.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import su.levenetc.motosignal.managers.RestManager;
import su.levenetc.motosignal.managers.RestManagerImpl;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
@Module
public class RestModule {
	@Provides @Singleton public RestManager provideRestManager() {
		return new RestManagerImpl();
	}
}
