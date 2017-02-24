/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Hero;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Sword extends AbstractActor implements Item, Usable {

    private int damage;
    
    public Sword(String name) {
        super(name);
        damage = 5;
        
        setAnimation(new Animation("resources/sprites/sword.png", 16, 16));
    }
    
    public Sword() {
        super("swordik");
        damage = 5;
        
        setAnimation(new Animation("resources/sprites/sword.png", 16, 16));
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int dmg) {
        damage = dmg;
    }

    @Override
    public void act() {
        
    }

    @Override
    public void use(Actor actor) {
        if(actor instanceof Hero) {
            ((Hero)actor).getSword();
            getWorld().removeActor(this);
        }
    }
    
}
