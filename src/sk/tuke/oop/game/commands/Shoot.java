/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Shoot implements Command {
    
    private Ripley rip;
    
    public Shoot(Ripley ripley) {
        rip = ripley;
    }
    
    @Override
    public void execute() {
        if(rip.getAmmo() > 0) {
            Bullet bull = new Bullet("a");
            bull.shoot(rip.getWorld(), rip.getX(), rip.getY(), rip.getAnimation().getRotation());
            rip.setAmmo(rip.getAmmo() - 1);
        }
            
    }
    
}
