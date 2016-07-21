package com.github.serpent7776.cimviewer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

public class CimViewer extends ApplicationAdapter {

	private final FileHandle handle;
	private final Vector2 size;
	private final Vector2 offset;
	private SpriteBatch batch;
	private Pixmap pixmap;
	private Texture img;

	public CimViewer(FileHandle handle) {
		this.handle = handle;
		this.size = new Vector2();
		this.offset = new Vector2();
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		pixmap = PixmapIO.readCIM(handle);
		img = new Texture(pixmap);
		Gdx.gl.glClearColor(0.333f, 0.333f, 0.333f, 1);
	}

	@Override
	public void resize(int width, int height) {
		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
		final Vector2 vec = Scaling.fit.apply(img.getWidth(), img.getHeight(), width, height);
		size.set(vec);
		offset.set((width - size.x) / 2, (height - size.y) / 2);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, offset.x, offset.y, size.x, size.y);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		pixmap.dispose();
	}

}
