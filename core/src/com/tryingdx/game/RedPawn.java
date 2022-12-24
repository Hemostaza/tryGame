package com.tryingdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RedPawn extends Pawn {
    public RedPawn(Tile parent) {
        super(parent);
        texture = new Texture(Gdx.files.internal("redPawn.png"));
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.side = PawnSide.UP;
    }
}
