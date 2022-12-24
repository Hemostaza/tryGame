package com.tryingdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainGameScreen implements Screen {

    final TryGame game;
    OrthographicCamera camera;

    TileMap tileMap = new TileMap();
    List<Pawn> pawnList = new ArrayList<>();

    Selector selector;

    public MainGameScreen(TryGame tryGame) {
        this.game = tryGame;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        selector = new Selector(camera, tileMap);
        Gdx.input.setInputProcessor(selector);

        tileMap.createTileMap(pawnList);
        //Gdx.app.log("Tile","Tile 2,2 ".getPawn());
        Ray ray = camera.getPickRay(0,0);

//        Pawn p = new BluePawn(tileMap.getTileOn(1,0));
//        pawnList.add(p);
//        p.changePosition(tileMap.getTileOn(2,1));
//        p.changePosition(tileMap.getTileOn(2,2));

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        tileMap.renderMap(game.batch);
        game.batch.begin();
        for(Pawn p:pawnList){
            p.render(game.batch);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        tileMap.dispose();
        pawnList.get(0).dispose();
    }
}
