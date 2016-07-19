package su.levenetc.motosignal.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eugene Levenetc on 20/07/2016.
 */
public class ApiManager {

	private static Api api;

	public static void init() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost:8080/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		api = retrofit.create(Api.class);
	}

	public static Api getApi() {
		return api;
	}
}
