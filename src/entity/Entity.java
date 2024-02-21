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

            final float ACCELERATION_SCALAR = 1000.f;
            final float DECELERATION_SCALAR = 400.f;

            float speedDelta = targetSpeed - getLinearVelocity().x;

            if (Math.abs(speedDelta) > 0.5f) {
                float force = 0.f;

                if (Math.abs(targetSpeed) < Math.abs(getLinearVelocity().x)) {
                    setLinearVelocity(new Vec2(0,0));
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
