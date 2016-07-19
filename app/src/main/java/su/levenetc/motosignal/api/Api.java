package su.levenetc.motosignal.api;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Eugene Levenetc on 20/07/2016.
 */
public interface Api {
	@POST("gcmToken") Observable<Object> sendGCMToken(@Query("token") String token);
}
