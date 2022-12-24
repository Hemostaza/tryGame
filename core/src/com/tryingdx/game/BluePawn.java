package com.tryingdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BluePawn extends Pawn {

    public BluePawn(Tile parent) {
        super(parent);
        texture = new Texture(Gdx.files.internal("bluePawn.png"));
        this.width = texture.getWidth();
        this.height = texture.getHeight();
    }
}
