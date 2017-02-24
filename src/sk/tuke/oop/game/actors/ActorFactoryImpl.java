/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.MonsterB;
import sk.tuke.oop.game.actors.enemies.MonsterE;
import sk.tuke.oop.game.actors.enemies.MonsterM;
import sk.tuke.oop.game.actors.ripley.Hero;
import sk.tuke.oop.game.items.Potion;
import sk.tuke.oop.game.items.Sword;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class ActorFactoryImpl implements ActorFactory {

    @Override
    public Actor create(String string, String string1) {
        if("lava".equals(string1))
            return new Lava(string);
        
        if("sword".equals(string1))
            return new Sword();
        
        if("monster1".equals(string1))
            return new MonsterE(string);
        
        if("monster2".equals(string1))
            return new MonsterM(string);
        
        if("monsterBoss".equals(string1))
            return new MonsterB(string);
        
        if("hero".equals(string1))
            return new Hero();
        
        if("actionZone".equals(string1))
            return new ActionZone(string);
        
        if("potion".equals(string1))
            return new Potion();
        
        return null;
    }
    
}
