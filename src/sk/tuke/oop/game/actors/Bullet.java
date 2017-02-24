/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Bullet extends AbstractActor implements Movable {

    private Rotation rot;
    private boolean isShot;
    private World world;
    private int dx, dy;

    public Bullet(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/bullet.png", 16, 16));

        rot = null;
        isShot = false;
        world = null;
        
        dx = dy = 0;
    }

    public void shoot(World world, int x, int y, int rot) {
        isShot = true;
        this.world = world;
        setPosition(x, y);
        world.addActor(this);
        getAnimation().setRotation(rot);

        if (rot == 0) {
            dx = 0;
            dy = -1;
        }

        if (rot == 45) {
            dx = 1;
            dy = -1;
        }

        if (rot == 90) {
            dx = 1;
            dy = 0;
        }

        if (rot == 135) {
            dx = 1;
            dy = 1;
        }

        if (rot == 180) {
            dx = 0;
            dy = 1;
        }

        if (rot == 225) {
            dx = -1;
            dy = 1;
        }

        if (rot == 270) {
            dx = -1;
            dy = 0;
        }

        if (rot == 315) {
            dx = -1;
            dy = -1;
        }
    }

    @Override
    public Rotation getRotation() {
        return rot;
    }

    @Override
    public void setRotation(Rotation rot) {
        this.rot = rot;
    }

    @Override
    public void act() {
        if (isShot) {
            this.setPosition(this.getX() + (dx*2), this.getY() + (2*dy));

            if (world != null) {
                /*boolean remove = false;

                for (Actor act : world) {
                    if (act instanceof Alien && this.intersects(act)) {
                        remove = true;
                    }
                }

                if (remove) {
                    world.removeActor(this);
                }*/

                if (world.intersectWithWall(this)) {
                    world.removeActor(this);
                }

            }
        }
    }

}
