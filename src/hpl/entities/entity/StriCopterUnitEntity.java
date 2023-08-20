package hpl.entities.entity;

import arc.util.Time;
import hpl.entities.units.StriCopterUnitType;
import hpl.world.draw.Blade;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

public class StriCopterUnitEntity extends UnitEntity {
    public Blade.BladeMount[] blades;
    public float bladeMoveSpeedScl = 1f;


    @Override
    public void setType(UnitType type) {
        super.setType(type);
        if (type instanceof StriCopterUnitType stripcopter) {
            blades = new Blade.BladeMount[stripcopter.blade.size];
            for (int i = 0; i < blades.length; i++) {
                Blade bladeType = stripcopter.blade.get(i);
                blades[i] = new Blade.BladeMount(bladeType);
            }
        }
    }

    @Override
    public void update() {
        super.update();
        StriCopterUnitType type = (StriCopterUnitType) this.type;

        for (Blade.BladeMount blade : blades) {
            blade.bladeRotation += ((blade.blade.bladeSpeed * bladeMoveSpeedScl) + blade.blade.minimumBladeMoveSpeed) * Time.delta;
        }
        type.fallSpeed = 0.006f;
    }
}
