package hpl.entities.units;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.math.Mathf;
import arc.struct.Seq;
import hpl.entities.entity.StriCopterUnitEntity;
import hpl.world.draw.Blade;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;

public class StriCopterUnitType extends UnitType {
    public final Seq<Blade> blade = new Seq<>();

    public StriCopterUnitType(String name){
        super(name);
        constructor = StriCopterUnitEntity::create;
    }

    public void drawBlade(Unit unit) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        applyColor(unit);
        if (unit instanceof StriCopterUnitEntity stri) {
            for (Blade.BladeMount mount : stri.blades) {
                Blade blade = mount.blade;
                float rx = unit.x + Angles.trnsx(unit.rotation - 90, blade.x, blade.y);
                float ry = unit.y + Angles.trnsy(unit.rotation - 90, blade.x, blade.y);
                float bladeScl = Draw.scl * blade.bladeSizeScl;
                float shadeScl = Draw.scl * blade.shadeSizeScl;

                for (int i = 0; i < blade.bladeC; i++) {
                    if (blade.bladeRegion.found()) {
                        Draw.z(z + blade.layer);
                        Draw.rect(
                                blade.outlineRegion, rx, ry,
                                blade.outlineRegion.width * bladeScl,
                                blade.outlineRegion.height * bladeScl,
                                unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                        );
                        Draw.mixcol(Color.white, unit.hitTime);
                        Draw.rect(blade.bladeRegion, rx, ry,
                                blade.bladeRegion.width * bladeScl,
                                blade.bladeRegion.height * bladeScl,
                                unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                        );

                        if (blade.doubleB) {
                            Draw.rect(
                                    blade.outlineRegion, rx, ry,
                                    blade.outlineRegion.width * bladeScl * -Mathf.sign(false),
                                    blade.outlineRegion.height * bladeScl,
                                    -unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                            );
                            Draw.mixcol(Color.white, unit.hitTime);
                            Draw.rect(blade.bladeRegion, rx, ry,
                                    blade.bladeRegion.width * bladeScl * -Mathf.sign(false),
                                    blade.bladeRegion.height * bladeScl,
                                    -unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                            );
                        }
                        Draw.reset();
                    }

                    if (blade.blurRegion.found()) {
                        Draw.z(z + blade.layer);
                        Draw.rect(
                                blade.blurRegion, rx, ry,
                                blade.blurRegion.width * bladeScl,
                                blade.blurRegion.height * bladeScl,
                                unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                        );

                        // Double Rotor Blur
                        if (blade.doubleB) {
                            Draw.rect(
                                    blade.blurRegion, rx, ry,
                                    blade.blurRegion.width  * bladeScl * -Mathf.sign(false),
                                    blade.blurRegion.height * bladeScl,
                                    unit.rotation - 90 + Mathf.random(blade.bladeSpeed,-blade.minimumBladeMoveSpeed)
                            );
                        }
                        Draw.reset();
                    }

                    Draw.reset();
                    if (blade.shadowRegion.found()) {
                        Draw.z(z + blade.layer + 0.001f);
                        Draw.rect(
                                blade.shadowRegion, rx, ry,
                                blade.shadowRegion.width * shadeScl,
                                blade.shadowRegion.height * shadeScl,
                                unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                        );
                        Draw.mixcol(Color.white, unit.hitTime);
                        Draw.rect(
                                blade.shadowRegion, rx, ry,
                                blade.shadowRegion.width * shadeScl,
                                blade.shadowRegion.height * shadeScl,
                                unit.rotation - 90 + Mathf.random(blade.bladeSpeed, -blade.minimumBladeMoveSpeed)
                        );
                        Draw.reset();
                    }
                }
            }
        }
    }

    @Override
    public void draw(Unit unit) {
        float z = unit.elevation > 0.5f ? (lowAltitude ? Layer.flyingUnitLow : Layer.flyingUnit) : groundLayer + Mathf.clamp(hitSize / 4000f, 0, 0.01f);
        super.draw(unit);
        Draw.z(z);
        drawBlade(unit);
    }

    @Override
    public void load() {
        super.load();
        blade.each(Blade::load);
    }
}
