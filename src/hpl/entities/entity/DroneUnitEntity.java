package hpl.entities.entity;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import hpl.content.HPLUnits;
import hpl.entities.units.DroneUnitType;
import hpl.world.draw.Blade;
import hpl.world.draw.Rotor;
import mindustry.content.Fx;
import mindustry.entities.EntityCollisions;
import mindustry.gen.UnitEntity;
import hpl.world.draw.Rotor.RotorMount;
import hpl.world.draw.Rotor;
import mindustry.type.UnitType;

public class DroneUnitEntity extends UnitEntity {
    public RotorMount[] rotors;
    public float rotSpeedScl = 1f;

    @Override
    public String toString() {
        return "DroneUnit#" + id;
    }

    @Override
    public int classId() {
        return HPLUnits.classID(getClass());
    }

    /** @author GlennFolker#6881 */
    @Override
    public void setType(UnitType type) {
        super.setType(type);
        if (type instanceof DroneUnitType drone) {
            rotors = new RotorMount[drone.rotors.size];
            for (int i = 0; i < rotors.length; i++) {
                Rotor rotorType = drone.rotors.get(i);
                rotors[i] = new RotorMount(rotorType);
            }
        }
    }

    @Override
    public EntityCollisions.SolidPred solidity(){
        DroneUnitType type = (DroneUnitType) this.type;
        if(type.hover){
            return isFlying() ? null : EntityCollisions::solid;
        }
        else {
            return null;
        }
    }

    @Override
    public void update() {
        super.update();
        DroneUnitType type = (DroneUnitType) this.type;
        float rX = x + Angles.trnsx(rotation - 90, type.fallSmokeX, type.fallSmokeY);
        float rY = y + Angles.trnsy(rotation - 90, type.fallSmokeX, type.fallSmokeY);

        // Slows down rotor when dying
        if (dead || health() <= 0) {
            rotation += Time.delta * (type.spinningFallSpeed * vel().len()) * Mathf.signs[id % 2];
            if (Mathf.chanceDelta(type.fallSmokeChance)) {
                Fx.fallSmoke.at(rX, rY);
                Fx.burning.at(rX, rY);
            }
            rotSpeedScl = Mathf.lerpDelta(rotSpeedScl, 0f, type.rotorDeathSlowdown);
        } else {
            rotSpeedScl = Mathf.lerpDelta(rotSpeedScl, 1f, type.rotorDeathSlowdown);
        }

        for (RotorMount rotor : rotors) {
            rotor.rotorRot += ((rotor.rotor.rotorSpeed * rotSpeedScl) + rotor.rotor.minimumRotorSpeed) * Time.delta;
        }
        type.fallSpeed = 0.006f;
    }
}

