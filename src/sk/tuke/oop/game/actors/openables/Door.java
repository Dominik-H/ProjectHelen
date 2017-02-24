/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.items.AccessCard;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Door extends AbstractActor implements Usable, Openable {

    private boolean isOpen;
    private boolean locked;
    private final boolean vertical;
    
    public Door(String name, boolean vertical) {
        super(name);
        this.vertical = vertical;
        if(vertical)
            setAnimation(new Animation("resources/sprites/vdoor.png", 16, 32, 100));
        else
            setAnimation(new Animation("resources/sprites/hdoor.png", 32, 16, 100));
        
        isOpen = false;
        locked = false;
        getAnimation().setLooping(false);       
        getAnimation().stop();
    }
    
    public void unlock(Actor actor) {
        if(actor instanceof AccessCard) {
            locked = false;
        }
    }

    @Override
    public void use(Actor actor) {
        unlock(actor);
        
        if(!locked) {
            if(isOpen)
                close();
            else
                open();
        }
    }

    @Override
    public void open() {
        isOpen = true;
        getAnimation().setPingPong(false); 
        getAnimation().start();
        
        if(vertical) {
            getWorld().setWall(getX()/16, getY()/16, false);
            getWorld().setWall(getX()/16, 1 + getY()/16, false);
        }
        else {
            getWorld().setWall(getX()/16, getY()/16, false);
            getWorld().setWall(1 + getX()/16, getY()/16, false);
        }
    }

    @Override
    public void close() {
        isOpen = false;
        getAnimation().setPingPong(true); 
        getAnimation().start();
        
        if(vertical) {
            getWorld().setWall(getX()/16, getY()/16, true);
            getWorld().setWall(getX()/16, 1 + getY()/16, true);
        }
        else {
            getWorld().setWall(getX()/16, getY()/16, true);
            getWorld().setWall(1 + getX()/16, getY()/16, true);
        }
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void act() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
