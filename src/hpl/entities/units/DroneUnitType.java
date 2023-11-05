package hpl.entities.units;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.math.Mathf;
import arc.struct.Seq;
import hpl.entities.entity.DroneUnitEntity;
import hpl.world.draw.Rotor;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;

public class DroneUnitType extends UnitType {
    // Copters.
    public final Seq<Rotor> rotors = new Seq<>();

    public float spinningFallSpeed = 0;
    public float rotorDeathSlowdown = 0.01f;
    public float fallSmokeX = 0f, fallSmokeY = -5f, fallSmokeChance = 0.1f;
    public boolean hover = false;

    public DroneUnitType(String name) {
        super(name);
        engineSize = 0;
        constructor = DroneUnitEntity::new;
    }

    @Override
    public void drawSoftShadow(Unit unit, float alpha) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        Draw.z(z - 3f);
        super.drawSoftShadow(unit, alpha);
    }
    public void drawRotor(Unit unit) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        applyColor(unit);
        if (unit instanceof DroneUnitEntity copter) {
            for (Rotor.RotorMount mount : copter.rotors) {
                Rotor rotor = mount.rotor;
                float rx = unit.x + Angles.trnsx(unit.rotation - 90, rotor.x, rotor.y);
                float ry = unit.y + Angles.trnsy(unit.rotation - 90, rotor.x, rotor.y);
                float rotorScl = Draw.scl * rotor.rotorSizeScl;
                float rotorTopScl = Draw.scl * rotor.rotorTopSizeScl;

                for (int i = 0; i < rotor.bladeCount; i++) {
                    float angle = (i * 360f / rotor.bladeCount + mount.rotorRot) % 360;
                    float blurAngle = (i * 360f / rotor.bladeCount + (mount.rotorRot * rotor.rotorBlurSpeedMultiplier)) % 360;

                    // region Normal Rotor
                    Draw.z(z + rotor.rotorLayer);
                    Draw.alpha(rotor.rotorShadeRegion.found() ? 1 - (copter.rotSpeedScl / 0.8f) : 1);
                    Draw.mixcol(Color.white, unit.hitTime);
                    Draw.rect(rotor.bladeRegion, rx, ry,
                            rotor.bladeRegion.width * rotorScl,
                            rotor.bladeRegion.height * rotorScl,
                            unit.rotation - angle
                    );
                    // endregion Normal Rotor
                    Draw.reset();

                    // Blur Rotor
                    if (rotor.rotorNotRadial) {
                        if (rotor.rotorShadeRegion.found()) {
                            Draw.z(z + rotor.rotorLayer);
                            Draw.alpha(copter.rotSpeedScl * rotor.rotorBlurAlphaMultiplier * (copter.dead() ? copter.rotSpeedScl * 0.5f : 1));
                            Draw.rect(
                                    rotor.rotorShadeRegion, rx, ry,
                                    rotor.rotorShadeRegion.width * rotorScl,
                                    rotor.rotorShadeRegion.height * rotorScl,
                                    unit.rotation - -blurAngle
                            );
                        }

                        Draw.reset();

                    }
                }
                // Blur Rotor
                float blurAngle = (mount.rotorRot * rotor.rotorBlurSpeedMultiplier) % 360;
                float glowAngle = (mount.rotorRot * rotor.rotorBlurSpeedMultiplier * rotor.rotorGlowSpeedMultiplier) % 360;
                if (rotor.rotorRadial) {
                    if (rotor.rotorShadeRegion.found()) {
                        Draw.z(z + rotor.rotorLayer);
                        Draw.alpha(copter.rotSpeedScl * rotor.rotorBlurAlphaMultiplier * (copter.dead() ? copter.rotSpeedScl * 0.5f : 1));
                        Draw.rect(
                                rotor.rotorShadeRegion, rx, ry,
                                rotor.rotorShadeRegion.width * rotorScl,
                                rotor.rotorShadeRegion.height * rotorScl,
                                -blurAngle
                        );
                    }

                    Draw.reset();

                    if (rotor.drawGlow) {
                        if (rotor.rotorGlowRegion.found()) {
                            Draw.z(z + rotor.rotorLayer + 0.01f);
                            Draw.alpha(copter.rotSpeedScl * rotor.rotorGlowAlphaMultiplier * (copter.dead() ? copter.rotSpeedScl * 0.5f : 1));
                            Draw.rect(
                                    rotor.rotorGlowRegion, rx, ry,
                                    rotor.rotorGlowRegion.width * rotorScl,
                                    rotor.rotorGlowRegion.height * rotorScl,
                                    -glowAngle
                            );
                        }

                        Draw.reset();
                    }
                    // Rotor Top
                    if (rotor.drawRotorTop) {
                        Draw.z(z + rotor.rotorLayer + 0.02f);
                        Draw.rect(
                                rotor.topRegion, rx, ry,
                                rotor.topRegion.width * rotorTopScl,
                                rotor.topRegion.height * rotorTopScl,
                                unit.rotation - 90
                        );
                    }
                    Draw.reset();
                }
            }
        }
    }

    @Override
    public void draw(Unit unit) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        super.draw(unit);
        Draw.z(z);
        drawRotor(unit);
    }

    @Override
    public void load() {
        super.load();
        rotors.each(Rotor::load);
    }
}