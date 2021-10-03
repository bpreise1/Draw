package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class Draw extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture turtle;
	float x, y;
	float obstacleX, obstacleY;
	float dx, dy;
	float w, h;
	BitmapFont font;

	public void setTurtleCoords() {
		obstacleX = new Random().nextInt((int)w);
		obstacleY = new Random().nextInt((int)h);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		turtle = new Texture("turtle.png");
		x = 0;
		y = 0;
		dx = 10;
		dy = 10;
		font = new BitmapFont();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		if(false) {
			setTurtleCoords();
		}

		x += dx;
		y += dy;

		if(x > w - img.getWidth() || x < 0) {
			dx = -dx;
		}
		if(y > h - img.getHeight() || y < 0) {
			dy = -dy;
		}

		batch.begin();
		//font.draw(batch, "Hello", x, y);
		batch.draw(img, x, y);
		//batch.draw(turtle, obstacleX, obstacleY);
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
