package core;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
    Asteroid asteroid;
    public MyInputProcessor(Asteroid asteroid) {
        this.asteroid = asteroid;
    }

    @Override
    public boolean keyDown(int keycode) {
       switch (keycode){
           case Input.Keys.LEFT:
               asteroid.setLeftMove(true);
               break;
           case Input.Keys.RIGHT:
               asteroid.setRightMove(true);
               break;
           case Input.Keys.UP:
               asteroid.setUpMove(true);
               break;
           case Input.Keys.DOWN:
               asteroid.setDownMove(true);
               break;
       }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.LEFT:
                asteroid.setLeftMove(false);
                break;
            case Input.Keys.RIGHT:
                asteroid.setRightMove(false);
                break;
            case Input.Keys.UP:
                asteroid.setUpMove(false);
                break;
            case Input.Keys.DOWN:
                asteroid.setDownMove(false);
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
