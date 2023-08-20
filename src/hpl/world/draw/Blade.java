package hpl.world.draw;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.util.Nullable;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.io.JsonIO;
import mindustry.type.UnitType;

public class Blade {
    public final String name;
    public float bladeSpeed = 1;
    public float bladeSizeScl = 1, shadeSizeScl = 1;
    public int bladeC = 1;
    public float minimumBladeMoveSpeed = 0f;
    public float x;
    public float y;
    public float layer = 0.6f;
    public boolean doubleB = false;
    public TextureRegion bladeRegion, blurRegion, shadowRegion, outlineRegion;

    public Blade(String name){
        this.name = name;
    }

    public void load() {
        bladeRegion = Core.atlas.find(name + "-blade");
        blurRegion = Core.atlas.find(name + "-blur");
        shadowRegion = Core.atlas.find(name + "-shadow");
        outlineRegion = Core.atlas.find(name + "-outline");
    }

    public static class BladeMount {
        public final Blade blade;
        public float bladeRotation;

        public BladeMount(Blade blade) {
            this.blade = blade;
        }
    }

    public Blade copy() {
        return JsonIO.copy(this, new Blade(name));
    }
}
