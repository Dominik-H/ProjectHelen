/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Hero;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Lava extends AbstractActor {

    public Lava(String name) {
        super(name);
        
        if("1x5".equals(name))
            setAnimation(new Animation("resources/sprites/lava1x5.png", 16, 74));
        
        if("1x6".equals(name))
            setAnimation(new Animation("resources/sprites/lava1x6.png", 16, 80));
        
        if("4x13".equals(name))
            setAnimation(new Animation("resources/sprites/lavaEnd.png", 64, 208));
        
        if("block1".equals(name) || "block3".equals(name) || "block2".equals(name))
            setAnimation(new Animation("resources/sprites/lavaBlock.png", 16, 32));
        
        getAnimation().stop();
    }

    @Override
    public void act() {
        for(Actor act : getWorld()) {
            if(act instanceof Hero && this.intersects(act))
                ((Hero)act).setEnergy(0);
        }
    }
    
}
