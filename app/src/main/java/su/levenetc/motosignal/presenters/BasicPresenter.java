package su.levenetc.motosignal.presenters;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public abstract class BasicPresenter<V> {

	protected V view;

	public void setView(V view) {
		this.view = view;
		onViewCreated();
	}

	abstract void onViewCreated();
}
