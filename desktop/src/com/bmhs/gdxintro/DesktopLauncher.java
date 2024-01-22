package com.bmhs.gdxintro;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.bmhs.gdxintro.AppHandler;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(32*31,32*28);
		config.setForegroundFPS(60);
		config.setTitle("LibGDXIntro");
		new Lwjgl3Application(new AppHandler(), config);
	}
}
