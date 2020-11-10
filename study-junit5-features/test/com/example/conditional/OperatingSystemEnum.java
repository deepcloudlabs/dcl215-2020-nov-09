package com.example.conditional;

public enum OperatingSystemEnum {
	WINDOWS, UNIX, UNKNOWN;
	public static OperatingSystemEnum determineOs() {
		var osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win"))
			return WINDOWS;
		if (osName.contains("nix"))
			return UNIX;
		return UNKNOWN;
	}
}
