package core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Boot extends Game {
    public static Boot INSTANCE;
    private int widthScreen, heightSreen;
    private OrthographicCamera orthographicCamera;
    public Boot(){
        INSTANCE = this;
    }
    @Override
    public void create() {
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightSreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false,widthScreen,heightSreen);
        setScreen(new GameScreen(orthographicCamera));
    }
}
