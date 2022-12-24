package com.tryingdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileMap {
    private Tile[][] tiles = new Tile[8][8];

    private final Texture blackTileTexture = new Texture(Gdx.files.internal("blackTile.png"));
    private final Texture whiteTileTexture = new Texture(Gdx.files.internal("whiteTile.png"));

    private static float dimension = 64;

    public TileMap() {
        createTileMap();
    }

    public void createTileMap() {
        Texture textureToUse;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        textureToUse = whiteTileTexture;
                    } else textureToUse = blackTileTexture;
                } else {
                    if (j % 2 == 0) {
                        textureToUse = blackTileTexture;
                    } else textureToUse = whiteTileTexture;
                }
                tiles[i][j] = new Tile(textureToUse, i , j );
            }
        }
    }

    public void renderMap(SpriteBatch batch) {
        batch.begin();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile tile = tiles[i][j];
                tile.setPosition(i, j);
                batch.draw(tile.getTexture(), i*dimension, j*dimension);
            }
        }
        batch.end();
    }

    public Tile getTileOn(int posX, int posY) {
        return tiles[posX][posY];
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void dispose(){
        blackTileTexture.dispose();
        whiteTileTexture.dispose();
    }
}
