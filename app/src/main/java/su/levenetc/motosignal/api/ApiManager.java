package su.levenetc.motosignal.api;

/**
 * Created by Eugene Levenetc on 20/07/2016.
 */
public class ApiManager {

	private static RestService restService;

	public static void init() {

	}

	public static RestService getRestService() {
		return restService;
	}
}
