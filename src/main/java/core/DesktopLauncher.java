package core;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import java.awt.*;


public class DesktopLauncher {

    public static void main(String args[]){
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 640;
        //config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());

        config.vSyncEnabled = true;
        config.useHDPI = true;

        LwjglApplication application = new LwjglApplication(new Boot(),config);

    }
}