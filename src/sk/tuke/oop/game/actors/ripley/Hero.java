/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.Boss;
import sk.tuke.oop.game.Level1;
import sk.tuke.oop.game.Level2;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.enemies.MonsterB;
import sk.tuke.oop.game.actors.enemies.MonsterE;
import sk.tuke.oop.game.actors.enemies.MonsterM;
import sk.tuke.oop.game.commands.Command;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Hero extends AbstractCharacter implements Movable {

    private Rotation rot;
    private List<Actor> intersect;
    private RipleyState level;
    private Command cmd;
    private final int step;
    private boolean hasSword;
    private boolean hasEnhanced;
    private boolean done;
    private boolean hit;
    private int count;

    public Hero() {
        super("Lolko");
        setAnimation(new Animation("resources/sprites/player.png", 32, 32, 100));

        rot = Rotation.UP;
        intersect = new ArrayList<>();
        setEnergy(50);
        step = 2;
        hasSword = false;
        hasEnhanced = false;
        hit = false;
        done = false;
        level = null;
        count = 0;
    }
    
    public void setLevel(RipleyState lev) {
        this.level = lev;
    }

    public void getSword() {
        hasSword = true;
    }

    public void getEnhanced() {
        hasEnhanced = true;
    }

    public boolean hasSword() {
        return hasSword;
    }

    public boolean hasEnhanced() {
        return hasEnhanced;
    }

    private void handleInput(Input in) {
        if (in.isKeyPressed(Input.Key.E)) {
            for (Actor act : intersect) {
                if (act instanceof Usable) {
                    Use u = new Use(act, this);
                    u.execute();
                    getWorld().removeActor(act);
                }
            }
        }

        if (in.isKeyPressed(Input.Key.SPACE) && !hit) {
            int dmg = 1;
            if (hasSword) {
                dmg = 10;
            }
            if (hasEnhanced) {
                dmg = 25;
            }

            for (Actor act : intersect) {
                if (level instanceof Level1 && act instanceof MonsterE) {
                    ((MonsterE) act).setEnergy(((MonsterE) act).getEnergy() - dmg);
                }
                if (level instanceof Level2 && act instanceof MonsterM) {
                    ((MonsterM) act).setEnergy(((MonsterM) act).getEnergy() - dmg);
                }
                if (level instanceof Boss && act instanceof MonsterB) {
                    ((MonsterB) act).setEnergy(((MonsterB) act).getEnergy() - dmg);
                }
            }
            
            hit = true;
        } 
        if(!in.isKeyPressed(Input.Key.SPACE)){
            hit = false;
        }

        if ((in.isKeyDown(Input.Key.LEFT) || in.isKeyDown(Input.Key.A)) && (in.isKeyDown(Input.Key.UP) || in.isKeyDown(Input.Key.W))) {
            cmd = new Move(this, step, -1, -1);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, 1, 1);
                cmd.execute();

                getAnimation().setRotation(315);
            }
        } else if ((in.isKeyDown(Input.Key.LEFT) || in.isKeyDown(Input.Key.A)) && (in.isKeyDown(Input.Key.DOWN) || in.isKeyDown(Input.Key.S))) {
            cmd = new Move(this, step, -1, 1);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, 1, -1);
                cmd.execute();

                getAnimation().setRotation(225);
            }
        } else if ((in.isKeyDown(Input.Key.RIGHT) || in.isKeyDown(Input.Key.D)) && (in.isKeyDown(Input.Key.UP) || in.isKeyDown(Input.Key.W))) {
            cmd = new Move(this, step, 1, -1);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, -1, 1);
                cmd.execute();

                getAnimation().setRotation(45);
            }
        } else if ((in.isKeyDown(Input.Key.RIGHT) || in.isKeyDown(Input.Key.D)) && (in.isKeyDown(Input.Key.DOWN) || in.isKeyDown(Input.Key.S))) {
            cmd = new Move(this, step, 1, 1);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, -1, -1);
                cmd.execute();

                getAnimation().setRotation(135);
            }
        } else if (in.isKeyDown(Input.Key.LEFT) || in.isKeyDown(Input.Key.A)) {
            cmd = new Move(this, step, -1, 0);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, 1, 0);
                cmd.execute();

                getAnimation().setRotation(270);
            }
        } else if (in.isKeyDown(Input.Key.RIGHT) || in.isKeyDown(Input.Key.D)) {
            cmd = new Move(this, step, 1, 0);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, -1, 0);
                cmd.execute();

                getAnimation().setRotation(90);
            }
        } else if (in.isKeyDown(Input.Key.UP) || in.isKeyDown(Input.Key.W)) {
            cmd = new Move(this, step, 0, -1);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, 0, 1);
                cmd.execute();

                getAnimation().setRotation(0);
            }
        } else if (in.isKeyDown(Input.Key.DOWN) || in.isKeyDown(Input.Key.S)) {
            cmd = new Move(this, step, 0, 1);
            cmd.execute();

            if (getWorld().intersectWithWall(this)) {
                cmd = new Move(this, step, 0, -1);
                cmd.execute();

                getAnimation().setRotation(180);
            }
        }

        if (!in.isKeyDown(Input.Key.UP) && !in.isKeyDown(Input.Key.W)
                && !in.isKeyDown(Input.Key.DOWN) && !in.isKeyDown(Input.Key.S)
                && !in.isKeyDown(Input.Key.LEFT) && !in.isKeyDown(Input.Key.A)
                && !in.isKeyDown(Input.Key.RIGHT) && !in.isKeyDown(Input.Key.D)) {

            getAnimation().stop();
        }
    }

    @Override
    public void act() {
        Input in = Input.getInstance();

        if (!isDead()) {
            intersect = getIntersectingActors();

            handleInput(in);
        } else {
            if (!done) {
                done = true;
                setAnimation(new Animation("resources/sprites/player_die.png", 32, 32, 100));
            }

            count++;

            if (count >= 60) {
                System.exit(1);
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

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        //world.showBackpack(bckp);
        world.centerOn(this);
    }

}
