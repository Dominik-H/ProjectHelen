/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Hero;
import sk.tuke.oop.game.actors.ripley.RipleyState;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Game extends AbstractActor {
    
    private RipleyState level;
    private Hero h;

    public Game(String name, Hero h) {
        super(name);
        setAnimation(new Animation("resources/sprites/actionZone.png", 48, 112));
        
        level = new Tutorial(h, this);
        this.h = h;
        h.setLevel(level);
    }
    
    public void setLevel(RipleyState lev) {
        level = lev;
    }

    @Override
    public void act() {
        Input in = Input.getInstance();
        if(in.isKeyPressed(Input.Key.ESCAPE))
            System.exit(0);
        
        Message msg = new Message("Health: " + h.getEnergy() + " Sword: " + h.hasSword() + " Enhanced: " + h.hasEnhanced(), 10, 60);
        getWorld().showMessage(msg);
        
        h.setLevel(level);
        
        level.act();
    }
    
}
