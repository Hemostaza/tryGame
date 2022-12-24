package com.tryingdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TryGame extends Game {

	SpriteBatch batch;

	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainGameScreen(this));
	}

	public void render () {
		super.render();
	}

	public void dispose () {
		batch.dispose();
	}
}
