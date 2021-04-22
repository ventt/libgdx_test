package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Asteroid {
    boolean leftMove;
    boolean rightMove;
    boolean upMove;
    boolean downMove;

    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }

    private BodyDef bodyDef = new BodyDef();
    FixtureDef fixtureDef = new FixtureDef();
    CircleShape circleShape = new CircleShape();
    Body body;
    Fixture fixture;
    float maxVel;

    public void setAsteroidTexture(Texture asteroidTexture) {
        this.asteroidTexture = asteroidTexture;
    }

    private Texture asteroidTexture;
    private Vector2 position;
    public void setPosition(Vector2 position) {
        //this.position = position;
        bodyDef.position.set(position);
    }



    public Texture getAsteroidTexture() {
        return asteroidTexture;
    }

    public Vector2 getPosition() {
        return body.getPosition();
    }

    public Asteroid(World world) {
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        circleShape.setRadius(5);
        fixtureDef.shape = circleShape;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f;
        body = world.createBody(bodyDef);
        fixture = body.createFixture(fixtureDef);
        body.setGravityScale(0f);
        circleShape.dispose();
    }

    void updateMotion() {
       // bodyDef.position.y -= body.getGravityScale();
        if (leftMove) {
           if(body.getLinearVelocity().x > -maxVel){
               body.applyLinearImpulse(-0.8f,0,body.getPosition().x,body.getPosition().y,true);
           }
        }
        if (rightMove) {
          //  bodyDef.position.x += 100 * Gdx.graphics.getDeltaTime();
           // body.getPosition().x -= 100 * Gdx.graphics.getDeltaTime();
            //body.applyForce(1.0f,0.0f, getPosition().x, getPosition().y, true);
            //body.applyForceToCenter(1.0f,0.0f,true);
            if(body.getLinearVelocity().x  < maxVel){
                body.applyLinearImpulse(0,0.8f,body.getPosition().x,body.getPosition().y,true);
            }
        }
        if (upMove) {
           // bodyDef.position.y += 100 * Gdx.graphics.getDeltaTime();
           // body.getPosition().x -= 100 * Gdx.graphics.getDeltaTime();
           // body.applyForce(0.0f,1.0f, getPosition().x, getPosition().y, true);
            body.applyForceToCenter(0.0f,1.0f,true);
        }
        if (downMove) {
           // bodyDef.position.y -= 100 * Gdx.graphics.getDeltaTime();
           // body.getPosition().x -= 100 * Gdx.graphics.getDeltaTime();
            //body.applyForce(0.0f,-1.0f, getPosition().x, getPosition().y, true);
            body.applyForceToCenter(0.0f,-1.0f,true);
        }
    }

    public void setLeftMove(boolean t) {
        if (rightMove && t) rightMove = false;
        leftMove = t;
    }

    public void setRightMove(boolean t) {
        if (leftMove && t) leftMove = false;
        rightMove = t;
    }

    public void setUpMove(boolean t) {
        if (downMove && t) downMove = false;
        upMove = t;
    }

    public void setDownMove(boolean t) {
        if (upMove && t) upMove = false;
        downMove = t;
    }
}
