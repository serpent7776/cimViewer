package com.github.serpent7776.cimviewer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;

import com.github.serpent7776.cimviewer.CimViewer;

public class DesktopLauncher {

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		final FileHandle handle = args.length > 0 ? new FileHandle(args[0]) : null;
		new LwjglApplication(new CimViewer(handle), config);
	}

}
