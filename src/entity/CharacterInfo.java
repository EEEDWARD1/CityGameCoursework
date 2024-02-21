package entity;

import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

public class CharacterInfo extends Walker {

    private int maxHealth;
    private int health;

    //private Weapon weapon;

    protected CharacterInfo(World world, Shape shape) {
        super(world, shape);
    }


    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    /* .............
    Do this for weapons!!!
    ..................
     */

    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            destroy();
        }
    }

    public void healDamage(int heal){
        health += heal;
        if (health >= maxHealth){
            health = maxHealth;
        }
    }

    /*.................
    Weapon damage inheritance!!!!!
    .......................
    */
    public void jump(float speed){

    }

    //Friction

    //Force Movement

}
