package su.levenetc.motosignal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import su.levenetc.motosignal.services.GCMRegistrationService;

/**
 * Created by Eugene Levenetc on 17/07/2016.
 */
public class SettingsActivity extends AppCompatActivity {
	@Override protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startService(new Intent(this, GCMRegistrationService.class));
	}
}