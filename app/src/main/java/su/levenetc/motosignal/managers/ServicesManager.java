package su.levenetc.motosignal.managers;

import rx.Observable;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public interface ServicesManager {
	Observable<String> sendGCMToken();
}
