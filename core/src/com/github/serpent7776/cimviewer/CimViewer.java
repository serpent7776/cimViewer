package com.github.serpent7776.cimviewer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CimViewer extends ApplicationAdapter {

	private final FileHandle handle;
	private SpriteBatch batch;
	private Pixmap pixmap;
	private Texture img;

	public CimViewer(FileHandle handle) {
		this.handle = handle;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		pixmap = PixmapIO.readCIM(handle);
		img = new Texture(pixmap);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		pixmap.dispose();
	}

}
