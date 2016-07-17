package su.levenetc.motosignal.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.List;

/**
 * Created by Eugene Levenetc on 17/07/2016.
 */
public class SystemUtils {
	public static boolean hasSensor(int type, Context context) {
		SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
		for (Sensor sensor : sensorList) {

			if (sensor.getType() == type) {
				return true;
			}
		}
		return false;
	}
}
