/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.game.actors.openables.Door;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.commands.Command;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.NextItem;
import sk.tuke.oop.game.commands.Shoot;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author (c) Dominik Hornak 2015
 */
public class Ripley extends AbstractCharacter implements Movable {

    private Rotation rot;
    private RipleyState state;
    private BackpackImpl bckp;
    private int step;
    private Command cmd;
    private int ammo;
    private boolean isDeadAnim;
    private int counter;

    public Ripley() {
        super("Ripley");
        setAnimation(new Animation("resources/sprites/player.png", 32, 32, 100));
        getAnimation().stop();
        bckp = new BackpackImpl(10);
        rot = Rotation.UP;
        setPosition(100, 100);
        ammo = 375;
        step = 2;
        counter = 0;
        isDeadAnim = false;
    }

    @Override
    public Rotation getRotation() {
        return rot;
    }

    @Override
    public void setRotation(Rotation rot) {
        this.rot = rot;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void takeAmmo(int amount) {
        this.ammo += amount;
    }

    public Item getItemByName(String name) {
        return bckp.getItemByName(name);
    }

    @Override
    public void act() {
        Input in = Input.getInstance();
        if (in.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        
        
        Message msg = new Message("Health: " + getEnergy() + " Ammo: " + ammo, 80, 10);
        getWorld().showMessage(msg);

        if (!isDead()) {
            if (in.isKeyPressed(Input.Key.L)) {
                setEnergy(0);
            }
            
            if(in.isKeyPressed(Input.Key.SPACE))
            {
                Shoot shoot = new Shoot(this);
                shoot.execute();
            }

            List<Actor> actors = getIntersectingActors();

            if (in.isKeyPressed(Input.Key.Q)) {
                Item i = bckp.getLastItem();
                if (i != null) {
                    Use u = new Use(i, this);
                    u.execute();
                    if (i instanceof Energy || i instanceof Ammo) {
                        bckp.remove(i);
                    }
                }
            }

            if (in.isKeyPressed(Input.Key.E)) {
                for (Actor act : actors) {
                    if (act instanceof Usable) {
                        boolean us = false;
                        Actor tmp;
                        if (act instanceof Door) {
                            tmp = bckp.getLastItem();
                            if (tmp instanceof AccessCard) {
                                Command c = new DropItem(bckp, getWorld(), getX(), getY());
                                c.execute();
                                us = true;
                            }
                        } else if (act instanceof Cooler) {
                            tmp = bckp.getLastItem();
                            if (tmp instanceof Hammer || tmp instanceof Wrench) {
                                Command c = new DropItem(bckp, getWorld(), getX(), getY());
                                c.execute();
                                us = true;
                            }
                        } else {
                            tmp = this;
                        }

                        Use u = new Use(act, tmp);
                        u.execute();

                        if (us) {
                            getWorld().removeActor(tmp);
                        }
                    }
                }
            }

            if (in.isKeyPressed(Input.Key.F)) {
                for (Actor act : actors) {
                    if (act instanceof Item) {
                        Command c = new TakeItem(bckp, (Item) act);
                        c.execute();
                    }
                }
            }

            if (in.isKeyPressed(Input.Key.G)) {
                Command c = new DropItem(bckp, getWorld(), getX(), getY());
                c.execute();
            }

            if (in.isKeyPressed(Input.Key.R)) {
                Command c = new NextItem(bckp);
                c.execute();
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
        } else {
            if(!isDeadAnim) {
                setAnimation(new Animation("resources/sprites/player_die.png", 32, 32, 100));
                isDeadAnim = true;
            }
            
            counter++;
            
            if(counter >= 100)
                System.exit(0);
        }
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.showBackpack(bckp);
        world.centerOn(this);
    }
}
