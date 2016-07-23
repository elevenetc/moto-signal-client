package su.levenetc.motosignal.presenters;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public abstract class BasicPresenter<V> {

	protected V view;
	protected CompositeSubscription composite = new CompositeSubscription();

	public void setView(V view) {
		this.view = view;
		onViewCreated();
	}

	protected void addSub(Subscription subscription) {
		composite.add(subscription);
	}

	abstract void onViewCreated();

	public void onViewDestroyed() {
		composite.unsubscribe();
	}
}
