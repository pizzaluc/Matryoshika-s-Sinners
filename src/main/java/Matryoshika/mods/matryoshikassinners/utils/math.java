package Matryoshika.mods.matryoshikassinners.utils;

public class math {

	public static double py3d(double dx, double dy, double dz) {
		double val;
		val = dx*dx+dy*dy+dz*dz;
		return Math.sqrt(val);
	}
}
