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
    private Asteroid asteroid;
    private Floor floor;
    private Texture texture = new Texture(Gdx.files.internal("smallAsteroid.png"));
    private MyInputProcessor mip;


    public GameScreen(OrthographicCamera camera){
        this.camera = camera;
        this.spriteBatch = new SpriteBatch();
        this.world = new World(new Vector2(0,0),false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();
        floor = new Floor(world,camera);
        this.asteroid = new Asteroid(world);
        asteroid.setPosition(new Vector2(0,0));
        asteroid.setAsteroidTexture(texture);
        mip = new MyInputProcessor(asteroid);
        world.createBody(asteroid.getBodyDef());
        Gdx.input.setInputProcessor(mip);
    }
    public void Update(){
        mip.asteroid.updateMotion();
        System.out.println("X: "+asteroid.getPosition().x+" Y: "+asteroid.getPosition().y);
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
        spriteBatch.draw(asteroid.getAsteroidTexture(), asteroid.getPosition().x,asteroid.getPosition().y);
        //spriteBatch.draw(asteroidTexture,0,0);
        spriteBatch.end();
        box2DDebugRenderer.render(world, camera.combined.scl(PPM));
    }
}
