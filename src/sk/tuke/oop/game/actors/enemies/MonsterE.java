/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.enemies;

import static java.lang.Math.abs;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Hero;
import sk.tuke.oop.game.commands.Move;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class MonsterE extends AbstractCharacter implements Movable, Enemy {

    private Rotation rot;
    
    public MonsterE(String name) {
        super(name);
        
        rot = Rotation.UP;
        setEnergy(10);
        
        setAnimation(new Animation("resources/sprites/warrior_alien_lv1.png", 32, 32, 100));
    }

    @Override
    public void act() {
        if(getEnergy() <= 0)
            getWorld().removeActor(this);
        
        for(Actor act : getWorld()) {
            if(act instanceof Hero) {
                if(abs(act.getX() - this.getX()) < 50 && abs(act.getY() - this.getY()) < 100) {
                    int x = 0;
                    int y = 0;
                    if(getX() < act.getX())
                        x = 1;
                    if(getX() > act.getX())
                        x = -1;
                    if(getY() < act.getY())
                        y = 1;
                    if(getY() > act.getY())
                        y = -1;
                    
                    Move mov = new Move(this, 2, x, y);
                    mov.execute();
                    
                    if(this.intersects(act)) {
                        ((Hero)act).setEnergy(((Hero)act).getEnergy() - 1);
                    }
                }
            }
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
    
}
