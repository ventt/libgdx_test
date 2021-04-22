package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import static helper.Constants.PPM;

public class GameScreen extends ScreenAdapter {
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    private Texture asteroidTexture = new Texture(Gdx.files.internal("smallAsteroid.png"));;

    public GameScreen(OrthographicCamera camera){
        this.camera = camera;
        this.spriteBatch = new SpriteBatch();
        this.world = new World(new Vector2(0,0),false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();
    }
    public void Update(){
        world.step(1/60f,6,2);
        cameraUpdate();
        spriteBatch.setProjectionMatrix(camera.combined);
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }
    private void cameraUpdate(){
        camera.position.set(new Vector3(0,0,0));
        camera.update();
    }

    @Override
    public void render(float delta){
        this.Update();
        Gdx.gl.glClearColor(0,0,0,1); //Black screen as clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        // render objects
        spriteBatch.draw(asteroidTexture,100,100);
        spriteBatch.draw(asteroidTexture,0,100);
        spriteBatch.end();
        box2DDebugRenderer.render(world, camera.combined.scl(PPM));
    }
}
