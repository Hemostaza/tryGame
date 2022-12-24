package com.tryingdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Objects;

public class Pawn extends Rectangle {
    public Texture texture;
    private Tile tile;
    final float dimension = 64;
    PawnSide side;

    public Pawn() {
        x = 0;
        y = 0;
    }

    public Pawn(Tile parent) {
        this.tile = parent;
        setPosition(parent);
    }

    public void setPosition(Tile parent){
        this.x = parent.getX();
        this.y = parent.getY();
        parent.setPawn(this);
    }

    public Tile getTileParent() {
        return tile;
    }

    public Texture getTexture() {
        return texture;
    }

    public void changePosition(Tile newTile) {
        if (checkNewPosition(newTile)) {
            tile.setPawn(null);
            newTile.setPawn(this);
            this.tile = newTile;
            this.x = newTile.getX();
            this.y = newTile.getY();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x * dimension, y * dimension);
    }

    private boolean checkNewPosition(Tile newTile) {
        if (Objects.equals(newTile.getTexture().toString(), "whiteTile.png")){
            Gdx.app.log("Move", this.toString() + " Wrong move, on white");
            return false;
        }
        float diffX = Math.abs(newTile.getX() - tile.getX());
        float diffY = newTile.getY() - tile.getY();
        if(diffY!=side.side){
            Gdx.app.log("Move", this.toString() + " Wrong move, backward");
            return false;
        }
        if (diffX > 1) {
            Gdx.app.log("Move", this.toString() + " Wrong move, to far");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pawn[" + x + ":" + y + "]";
    }

    public void dispose(){
        texture.dispose();
    }
}

enum PawnSide{
    UP(-1),
    DOWN(1);

    public final int side;
    private PawnSide(int side){
        this.side = side;
    }
}
