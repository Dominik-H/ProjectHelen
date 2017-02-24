/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.commands.Command;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Body extends AbstractActor implements Usable {
    
    private BackpackImpl backpack;

    public Body() {
        super("Body");
        backpack = new BackpackImpl(2);
        setAnimation(new Animation("resources/sprites/body.png", 64, 48));
        backpack.add(new Wrench());
    }

    @Override
    public void use(Actor actor) {
        for(Item i : backpack) {
            Command c = new DropItem(backpack, getWorld(), getX(), getY());
            c.execute();
        }
    }

    @Override
    public void act() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
