package su.levenetc.motosignal.di.components;

import javax.inject.Singleton;

import dagger.Component;
import su.levenetc.motosignal.di.modules.ServicesModule;
import su.levenetc.motosignal.di.modules.SettingsModule;
import su.levenetc.motosignal.presenters.SettingsPresenter;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
@Singleton
@Component(modules = {
		SettingsModule.class,
		ServicesModule.class
})
public interface AppComponent {
	void inject(SettingsPresenter presenter);
}
