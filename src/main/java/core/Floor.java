package core;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Floor {
    BodyDef bodyDef;
    Body body;
    PolygonShape groundBox;
    public Floor(World world, Camera camera){
        bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(0,0));
        body = world.createBody(bodyDef);
        groundBox = new PolygonShape();
        groundBox.setAsBox(camera.viewportWidth, 0.1f);
        body.createFixture(groundBox,0.0f);
        groundBox.dispose();
    }
}
