package su.levenetc.motosignal.views;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public interface SettingsView {
	void setIsRegisteredAtGCM(boolean value);

	void showProgress();

	void registrationGCMFail();

	void registrationGCMSuccess();
}
