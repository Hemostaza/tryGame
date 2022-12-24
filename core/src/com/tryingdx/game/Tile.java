package com.tryingdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Tile extends Rectangle {

    private Texture texture;
    private Pawn pawn;

    public Tile(Texture texture, float posX, float posY) {
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        x = posX;
        y = posY;
    }

    public Texture getTexture() {
        return texture;
    }

    @Override
    public String toString() {
        return "Tile texture: " + texture.toString();
    }

    public void setPawn(Pawn pawn){
        this.pawn = pawn;
    }

    public Pawn getPawn(){
        return pawn;
    }

}