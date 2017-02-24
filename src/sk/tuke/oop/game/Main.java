package sk.tuke.oop.game;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.actors.ripley.Hero;
/*import sk.tuke.oop.game.actors.Alien;
import sk.tuke.oop.game.actors.Body;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.Ripley;
import sk.tuke.oop.game.actors.Ventilator;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;*/


/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SlickWorld world = new SlickWorld("My Great Game", 800, 600);
                
        ActorFactoryImpl factory = new ActorFactoryImpl();
        world.setFactory(factory);
        world.setMap("resources/levels/map.tmx");
        
        Hero h = null;
        
        for(Actor act : world) {
            if(act instanceof Hero)
                h = (Hero) act;
        }
        Game gam = new Game("a", h);
        world.addActor(gam);
        
        world.run();
    }
    
    public static void scenario() {
        
    }
    
}
