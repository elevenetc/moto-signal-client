package su.levenetc.motosignal.managers;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public interface SettingsManager {
	void setGCMRegistered(boolean value);

	boolean isGCMRegistered();
}
