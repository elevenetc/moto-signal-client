package su.levenetc.motosignal.api;

import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Eugene Levenetc on 20/07/2016.
 */
public interface RestService {
	@POST("gcmToken") Observable<Object> sendGCMToken(@Query("token") String token);

	@DELETE("gcmToken") Observable<Object> clearGCMToken(@Query("token") String token);
}
