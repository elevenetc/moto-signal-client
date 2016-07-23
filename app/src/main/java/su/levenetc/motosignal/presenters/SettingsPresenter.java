package su.levenetc.motosignal.presenters;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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
		view.setIsRegisteredAtGCM(settingsManager.isGCMTokenSent());
	}

	public void clearGCMToken() {
		view.showProgress();
	}

	public void sendGCMToken() {
		view.showProgress();
		servicesManager.sendGCMToken()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe();
	}

	private void onTokenSent(String token) {
		settingsManager.setGCMTokenSent(true);
		view.registrationGCMSuccess();
	}

	private void onTokenNotSent(Throwable t) {
		view.registrationGCMFail();
	}
}