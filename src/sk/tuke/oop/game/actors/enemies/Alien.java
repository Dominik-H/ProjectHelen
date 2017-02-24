/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.enemies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Command;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Alien extends AbstractCharacter implements Movable, Enemy {

    private final int step;
    private Rotation rot;
    private int counter, stop;
    private Command cmd;
    
    public Alien(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/warrior_alien.png", 32, 32, 100));
        rot = Rotation.UP;
        setPosition(100, 100);
        step = 2;
        cmd = new Move(this, step, 0, -1);
        counter = 0;
        stop = ThreadLocalRandom.current().nextInt(20, 50 + 1);
    }
    
    public Alien() {
        super("Alien");
        setAnimation(new Animation("resources/sprites/warrior_alien.png", 32, 32, 100));
        rot = Rotation.UP;
        setPosition(100, 100);
        step = 2;
        cmd = new Move(this, step, 0, -1);
        counter = 0;
        stop = ThreadLocalRandom.current().nextInt(20, 50 + 1);
    }

    @Override
    public void act() {
        counter++;
        
        List<Actor> delete = new ArrayList<>();
        
        for(Actor actor : getWorld()) {
            if(actor instanceof Ripley && actor.intersects(this)) {
                ((Ripley)actor).setEnergy(((Ripley)actor).getEnergy() - 1);
            }
            
            if(this.intersects(actor) && actor instanceof Bullet)
            {
                this.setEnergy(this.getEnergy()-10);
                delete.add(actor);
            }
        }
        
        for(Actor a : delete) {
            a.getWorld().removeActor(a);
        }
        
        if(getEnergy() <= 0)
            getWorld().removeActor(this);
        
        if(counter > stop) {
            counter = 0;
            stop = ThreadLocalRandom.current().nextInt(20, 50 + 1);
            
            int randomNum = ThreadLocalRandom.current().nextInt(0, 8 + 1); 
        
            switch(randomNum) {
                case 0:
                    cmd = new Move(this, step, -1, 0);
                    break;
                case 1:
                    cmd = new Move(this, step, 1, 0);
                    break;
                case 2:
                    cmd = new Move(this, step, 0, -1);
                    break;
                case 3:
                    cmd = new Move(this, step, 0, 1);
                    break;
                case 4:
                    cmd = new Move(this, step, 1, 1);
                    break;
                case 5:
                    cmd = new Move(this, step, -1, 1);
                    break;
                case 6:
                    cmd = new Move(this, step, 1, -1);
                    break;
                case 7:
                    cmd = new Move(this, step, -1, -1);
                    break;
                default:
                    cmd = null;
                    break;
            }
        }
        
        if(cmd != null)
            cmd.execute();
    }

    @Override
    public Rotation getRotation() {
        return rot;
    }
    
    @Override
    public void setRotation(Rotation rot) {
        this.rot = rot;
    }
    
}
