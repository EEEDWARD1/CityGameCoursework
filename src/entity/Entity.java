package entity;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Entity extends Walker{
    private final Feet feet;
    private float moveInput;
    private boolean walking;

    public Entity(World world, Shape shape) {
        super(world, shape);
        this.feet = new Feet();
    }

    public void setMoveInput(float moveInput){
        this.moveInput = moveInput;
    }

    public void jumpF(float force) {
        Vec2 v = this.getLinearVelocity();
        if (Math.abs(v.y) < 0.01F) {
            if(Math.abs(v.x) > 0.01F){
                this.applyForce(new Vec2(0,force+3000));
            } else {
                this.applyForce(new Vec2(0,force));
            }

        }
    }

    public void startWalkingF(float speed) {
        if (!this.walking) {
            this.getWorld().addStepListener(this.feet);
            this.walking = true;
        }

        this.feet.setTargetSpeed(speed);
    }

    public void stopWalkingF(float speed){
        if (this.walking) {
            this.walking = false;
        }

        this.feet.setTargetSpeed(speed);
    }

    private class Feet implements StepListener {
        float targetSpeed;
        float moveSpeed;
        float acceleration;
        float deceleration;
        float velPower;

        public void feet(){

        }
        public void setTargetSpeed(Float targetSpeed){
            this.targetSpeed = targetSpeed;
        }

        @Override
        public void preStep(StepEvent e) {
            Vec2 v = getLinearVelocity();

            final float ACCELERATION_SCALAR = 1000.f;
            final float DECELERATION_SCALAR = 400.f;

            float speedDelta = targetSpeed - v.x;

            if (Math.abs(speedDelta) > 0.5f) {
                float force = 0.f;

                if (Math.abs(targetSpeed) < Math.abs(v.x)) {
                    setLinearVelocity(new Vec2(0,v.y));
                } else {
                    force = Math.signum(speedDelta) * ACCELERATION_SCALAR;
                }

                applyForce(new Vec2(force, 0));
                System.out.println("FORCEEEE : " + force);

            }
        }

        @Override
        public void postStep(StepEvent e) {

        }
    }

}
