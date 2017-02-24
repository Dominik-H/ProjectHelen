/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public abstract class AbstractCharacter extends AbstractActor {

    private int energy;
    private boolean isDead;
    
    public AbstractCharacter(String name) {
        super(name);
        energy = 100;
        isDead = false;
    }
    
    public void setEnergy(int ene) {
        energy = ene;
        
        if(ene <= 0)
            isDead = true;
    }
    
    public boolean isDead() {
        return isDead;
    }
    
    public int getEnergy() {
        return energy;
    }    
}
