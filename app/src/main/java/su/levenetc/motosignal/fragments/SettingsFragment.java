package su.levenetc.motosignal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import su.levenetc.motosignal.R;
import su.levenetc.motosignal.di.DIHelper;
import su.levenetc.motosignal.presenters.SettingsPresenter;
import su.levenetc.motosignal.views.SettingsView;

/**
 * Created by Eugene Levenetc on 23/07/2016.
 */
public class SettingsFragment extends Fragment implements SettingsView {

	private final SettingsPresenter presenter = new SettingsPresenter();

	@BindView(R.id.btn_register) Button btnRegister;
	@BindView(R.id.btn_unregister) Button btnUnregister;
	@BindView(R.id.text_status) TextView textStatus;
	private Unbinder unbinder;

	public static SettingsFragment create() {
		SettingsFragment result = new SettingsFragment();
		result.setRetainInstance(true);
		return result;
	}

	@Override public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DIHelper.getAppComponent().inject(presenter);
		presenter.onCreate();
	}

	@Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.fragment_settings, container, false);
		unbinder = ButterKnife.bind(this, result);
		presenter.setView(this);
		return result;
	}

	@Override public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	@Override public void setIsRegisteredAtGCM(boolean isRegisterer) {
		if (isRegisterer) {
			textStatus.setText(R.string.status_registered);
			btnRegister.setEnabled(false);
			btnUnregister.setEnabled(true);
		} else {
			textStatus.setText(R.string.status_unregistered);
			btnRegister.setEnabled(true);
			btnUnregister.setEnabled(false);
		}
	}

	@Override public void showProgress() {
		disableView();
		textStatus.setText(R.string.status_registration_progress);
	}

	@Override public void registrationGCMFail(Throwable t) {
		String prefix = getContext().getString(R.string.error);
		textStatus.setText(String.format("%s:%s", prefix, t.toString()));
		btnRegister.setEnabled(true);
		btnUnregister.setEnabled(false);
	}

	@Override public void registrationGCMSuccess() {
		textStatus.setText(R.string.status_registered);
		btnRegister.setEnabled(false);
		btnUnregister.setEnabled(true);
	}

	@Override public void tokenClearSuccess() {
		btnRegister.setEnabled(true);
		btnUnregister.setEnabled(false);
		textStatus.setText(R.string.status_unregistered);
	}

	@Override public void tokenClearFail() {
		btnRegister.setEnabled(false);
		btnUnregister.setEnabled(true);
		textStatus.setText(R.string.status_registered);
	}

	@OnClick(R.id.btn_register) public void sendToken() {
		presenter.sendGCMToken();
	}

	@OnClick(R.id.btn_unregister) public void clearToken() {
		presenter.clearGCMToken();
	}

	private void disableView() {
		btnRegister.setEnabled(false);
		btnUnregister.setEnabled(false);
	}
}
