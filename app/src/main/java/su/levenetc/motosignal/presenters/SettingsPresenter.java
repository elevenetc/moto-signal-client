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
		addSub(servicesManager.clearGCMToken()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::onTokenCleared, this::onTokenNotCleared));
	}

	public void sendGCMToken() {
		view.showProgress();
		addSub(servicesManager.sendGCMToken()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::onTokenSent, this::onTokenNotSent));
	}

	private void onTokenCleared() {
		view.tokenClearSuccess();
	}

	private void onTokenNotCleared(Throwable t) {
		view.tokenClearFail();
	}

	private void onTokenSent() {
		settingsManager.setGCMTokenSent(true);
		view.registrationGCMSuccess();
	}

	private void onTokenNotSent(Throwable t) {
		view.registrationGCMFail();
	}
}