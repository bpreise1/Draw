package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Draw extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x, y;
	float dx, dy;
	float w, h;
	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		x = 0;
		y = 0;
		dx = 10;
		dy = 10;
		font = new BitmapFont();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		x += dx;
		y += dy;

		if(x > w || x < 0) {
			dx = -dx;
		}
		if(y > h || y < 0) {
			dy = -dy;
		}

		batch.begin();
		font.draw(batch, "Hello", 0, 0);
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void resize(int width, int height) {
		w = width;
		h = height;
	}
}
