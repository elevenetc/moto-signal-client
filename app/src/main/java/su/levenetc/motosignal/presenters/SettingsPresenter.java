package su.levenetc.motosignal.presenters;

import javax.inject.Inject;

import su.levenetc.motosignal.managers.ServicesManager;
import su.levenetc.motosignal.managers.SettingsManager;
import su.levenetc.motosignal.views.SettingsView;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public class SettingsPresenter extends BasicPresenter<SettingsView> {

	@Inject ServicesManager servicesManager;
	@Inject SettingsManager settingsManager;

	public void onCreate() {

	}

	@Override void onViewCreated() {
		view.setIsRegisteredAtGCM(settingsManager.isGCMRegistered());
	}

	public void registerAtGCMHandler() {
		view.registrationGCMProgress();
		servicesManager.startGCMRegistration();
	}
}