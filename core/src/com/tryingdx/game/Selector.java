package com.tryingdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class Selector extends InputAdapter {

    private OrthographicCamera camera;
    private CameraInputController cameraInputController;

    Tile selectedTile;
    Pawn selectedPawn;

    boolean selected;

    private TileMap tileMap;

    public Selector(OrthographicCamera camera, TileMap tileMap) {
        this.tileMap = tileMap;
        this.camera = camera;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int x = (int) screenX / 64;
        int y = (int) ((screenY - 600) / 64) * -1;
        if (button == Input.Buttons.LEFT) {
            selectedTile = tileMap.getTileOn(x, y);
            if (selectedTile.getPawn() != null) {
                if (!selected) {
                    selectedPawn = selectedTile.getPawn();
                    selected = true;
                } else {
                    selected = false;
                }
            }
            else {
                if (selectedPawn != null && selected) {
                    selectedPawn.changePosition(selectedTile);
                    selected = false;
                }
            }
            Gdx.app.log("Click", selected + "");
            return true;
        }

        return false;
    }

//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        return false;
//    }
//
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }

}
