package su.levenetc.motosignal.managers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import su.levenetc.motosignal.api.RestService;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public class RestManagerImpl implements RestManager {

	private final RestService restService;

	public RestManagerImpl() {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost:8080/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		restService = retrofit.create(RestService.class);
	}

	@Override public Observable<Object> sendGCMToken(String token) {
		return restService.sendGCMToken(token);
	}
}
