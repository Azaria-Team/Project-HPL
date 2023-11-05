package hpl.world.blocks.production;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.layout.Table;
import arc.struct.Seq;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import hpl.world.blocks.environment.UndergroundOre;
import hpl.world.meta.HPLStat;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.logic.Ranged;
import mindustry.ui.Styles;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.*;
import static mindustry.content.Blocks.air;

public class OreRadar extends Block {
    public int range = 20 * 8;
    public float radarSpeed = 1f;
    public float radarCone = 15f;
    public float circleAlpha = 1f;
    public float coneAlpha = 0.4f;
    public float moveCircleAlpha = 0.4f;

    public OreRadar(String name) {
        super(name);
        solid = true;
        update = true;
    }

    @Override
    public void setStats() {
        super.setStats();

        stats.add(Stat.range, range / tilesize, StatUnit.blocks);
        stats.add(HPLStat.radarSpeed.toStat(), radarSpeed, StatUnit.blocks);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Color.valueOf("4b95ff"));
    }

    public class OreRadarBuild extends Building implements Ranged {
        public float start;

        @Override
        public float range() {
            return range;
        }


        public float rot() {
            return (timeRad() * radarSpeed) % 360f;
        }

        public float timeRad() {
            return Time.time - start;
        }

        @Override
        public void draw() {
            super.draw();
            if (canConsume()) {
                Draw.z(Layer.light);
                //Draw.alpha(0.6f);
                Lines.stroke(2f, team.color);

                Draw.alpha(moveCircleAlpha - (timeRad() % 120f) / 120f);
                Lines.circle(x, y, (timeRad() % 120f) / 120f * range());

                Draw.alpha(coneAlpha);
                Fill.arc(x, y, range(), radarCone / 360f, rot());


                Draw.alpha(circleAlpha);
                Lines.circle(x, y, range());

                Draw.reset();
                locateOres(range());
            }
        }

        @Override
        public void drawSelect() {
            Drawf.dashCircle(x, y, range, team.color);
        }

        public void locateOres(float radius) {
            tile.circle((int) (radius / tilesize), (ore) -> {
                if (ore != null && ore.overlay() != null && ore.overlay() instanceof UndergroundOre u
                        && ore.block() == air) {
                    var angle = Mathf.angle(ore.x - tile.x, ore.y - tile.y);
                    var c1 = rot();
                    var c2 = rot() + radarCone;
                    if (c2 >= 360f && angle < 180f) {
                        angle += 360;
                    }

                    if (angle > c2 || angle < c1) return;

                    u.shouldDrawBase = true;
                    u.drawBase(ore);
                    u.shouldDrawBase = false;

                    if (ore.block() != null) {
                        Draw.z(Layer.max);
                        Draw.alpha(1f);
                        Draw.rect(u.itemDrop.uiIcon, ore.x * 2, ore.y * 2 + 2);
                    }
                }
            });
        }
    }
}
