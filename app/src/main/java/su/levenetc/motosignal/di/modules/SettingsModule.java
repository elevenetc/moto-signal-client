package su.levenetc.motosignal.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import su.levenetc.motosignal.managers.SettingsManager;
import su.levenetc.motosignal.managers.SettingsManagerImpl;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
@Module
public class SettingsModule {
	private Context context;

	public SettingsModule(Context context) {
		this.context = context;
	}

	@Singleton @Provides public SettingsManager provideSettingsManager() {
		return new SettingsManagerImpl(context);
	}
}
