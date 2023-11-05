package hpl.world.blocks.defense;

import arc.graphics.g2d.Draw;
import hpl.content.HPLStatusEffects;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.gen.Building;
import mindustry.gen.Posc;
import mindustry.gen.Unitc;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.Ranged;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.tilesize;

public class NavalMine extends Block{

    public float tileDamage = 10f;
    public float range = 35f;
    public float statusDuration = 60f;
    public StatusEffect status = HPLStatusEffects.decomposition;
    public Effect acceptEffect = Fx.none;
    public float damage = 130;
    public float teamAlpha = 0.3f;
    public boolean targetHost = true;
    public NavalMine(String name){
        super(name);
        update = true;
        destructible = true;
        solid = false;
        targetable = false;
        outlinedIcon = 1;
    }

    @Override
    public void setStats(){
        super.setStats();
        stats.add(Stat.range, range / tilesize, StatUnit.blocks);
        stats.add(Stat.damage, damage);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Pal.accent);
    }

    @Override
    public void drawOverlay(float x, float y, int rotation){
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Pal.accent);
    }

    public class NavalMineBuild extends Building implements Ranged {
        public Posc target;
        @Override
        public void drawTeam() {
            //no
        }


        @Override
        public float range() {
            return range;
        }

        protected void findTarget() {
            target = Units.closestTarget(team, x, y, range());
        }

        protected boolean validateTarget() {
            return !(Units.invalidateTarget(target, team, x, y) || !(target instanceof Unitc));
        }

        @Override
        public void updateTile() {
            if (!validateTarget()) target = null;


            if(validateTarget()){
                if(targetHost) {
                    explosion();
                }
            }

            if(timer(0, 20)){
                findTarget();
            }
        }

        protected void explosion() {
            Units.nearbyEnemies(team, x, y, range, unit -> {
                if(!unit.isFlying() && !unit.hovering) {
                    unit.apply(status, statusDuration);
                    acceptEffect.at(unit);
                    unit.damage(damage);
                    damage(tileDamage);
                }
            });
        }

        @Override
        public void draw() {
            super.draw();
            Draw.color(team.color, teamAlpha);
            Draw.rect(teamRegion, x, y);
            Draw.color();
        }

        @Override
        public void drawCracks() {
            //no
        }


        /*
        @Override
        public void unitOn(Unit unit){
            if(enabled && unit.team != team && timer(timerDamage, cool down)){
                damage(tileDamage);
            }
        }

         */
    }
}
