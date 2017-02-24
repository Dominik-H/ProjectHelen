/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public abstract class AbstractActor implements Actor {

    private int posX, posY;
    private Animation anim;
    private String name;
    private World world;
    
    public AbstractActor(String name) {
        this.name = name;
    }

    @Override
    public int getX() {
        return posX;
    }

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public int getWidth() {
        return anim.getWidth();
    }

    @Override
    public int getHeight() {
        return anim.getHeight();
    }

    @Override
    public void setPosition(int x, int y) {
        posX = x;
        posY = y;
    }

    @Override
    public Animation getAnimation() {
        return anim;
    }

    @Override
    public void setAnimation(Animation anmtn) {
        anim = anmtn;
    }

    @Override
    public boolean intersects(Actor actor) {
        return ((this.getX() < (actor.getX() + actor.getWidth())) && ((this.getX() + this.getWidth()) > actor.getX()) &&
                (this.getY() < (actor.getY() + actor.getHeight())) && ((this.getY() + this.getHeight()) > actor.getY()));
    }

    @Override
    public void addedToWorld(World world) {
        this.world = world;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name + ":" + posX + ":" + posY;
    }
    
    public List<Actor> getIntersectingActors() {
        List<Actor> out = new ArrayList<>();
        
        for(Actor actor : getWorld()) {
            if(this.intersects(actor)) {
                out.add(actor);
            }
        }
        
        return out;
    }
    
    public Actor getActorByName(String name) {
        for(Actor actor : getWorld()) {
            if(actor.getName() == null ? name == null : actor.getName().equals(name)) {
                return actor;
            }
        }
        
        return null;
    }

   /* @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
