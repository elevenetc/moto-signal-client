package su.levenetc.motosignal.managers;

import android.content.Context;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import su.levenetc.motosignal.R;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public class ServicesManagerImpl implements ServicesManager {

	private Context context;
	private SettingsManager settingsManager;
	private RestManager restManager;

	public ServicesManagerImpl(
			Context context,
			SettingsManager settingsManager,
			RestManager restManager
	) {
		this.context = context;
		this.settingsManager = settingsManager;
		this.restManager = restManager;
	}

	@Override public Observable<String> sendGCMToken() {
		return getToken().flatMap(this::sendToken);
	}

	private Observable<String> getToken() {
		return Observable.create(new Observable.OnSubscribe<String>() {
			@Override public void call(Subscriber<? super String> subscriber) {
				String token = settingsManager.getGCMToken();
				if (token == null) {
					try {
						subscriber.onNext(
								InstanceID.getInstance(context)
										.getToken(context.getString(R.string.gcmSenderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE, null)
						);
						subscriber.onCompleted();
					} catch (IOException e) {
						subscriber.onError(e);
					}
				}
			}
		});
	}

	private Observable<String> sendToken(String token) {
		return restManager.sendGCMToken(token).map(o -> token);
	}
}
