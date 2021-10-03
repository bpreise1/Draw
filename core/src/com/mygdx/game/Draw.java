package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Rectangle;
import java.util.Random;

public class Draw extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x, y;
	float dx, dy;
	float w, h;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("turtle.png");
		x = w / 2;
		y = h / 2;
		dx = 0;
		dy = 0;

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				if(dx == 0 && dy == 0) {
					dx = 10;
					dy = 10;
				}
				else {
					dx = -dx;
					dy = -dy;
				}
				return true;
			}
		});
	}

	@Override
	public void render () {
		ScreenUtils.clear((float).2, (float).5 , (float).5, 1);

		x += dx;
		y += dy;

		if(x > w - img.getWidth() || x < 0) {
			dx = -dx;
		}
		if(y > h - img.getHeight() || y < 0) {
			dy = -dy;
		}

		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		w = width;
		h = height;
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
