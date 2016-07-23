package su.levenetc.motosignal.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import su.levenetc.motosignal.fragments.SettingsFragment;

/**
 * Created by Eugene Levenetc on 17/07/2016.
 */
public class SettingsActivity extends AppCompatActivity {
	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			getSupportFragmentManager()
					.beginTransaction()
					.add(SettingsFragment.create(), null)
					.commit();
		}
	}
}