package hpl.entities.bullets;

import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Bullet;

public class ModEmpBulletType extends BasicBulletType {
    public float radius = 100f;
    public float timeIncrease = 2.5f, timeDuration = 60f * 10f;
    public float powerDamageScl = 2f, powerSclDecrease = 0.2f;
    public Effect hitPowerEffect = Fx.hitEmpSpark, chainEffect = Fx.chainEmp, applyEffect = Fx.heal;
    public boolean hitUnits = false;
    public float unitDamageScl = 0.7f;
    @Override
    public void hit(Bullet b, float x, float y){
        super.hit(b, x, y);

        if(!b.absorbed){
            Vars.indexer.allBuildings(x, y, radius, other -> {
                /*if(other.team == b.team){
                    if(other.block.hasPower && other.block.canOverdrive && other.timeScale() < timeIncrease){
                        other.applyBoost(timeIncrease, timeDuration);
                        //chainEffect.at(x, y, 0, hitColor, other);
                        //applyEffect.at(other, other.block.size * 7f);
                    }

                 */
                if(other.power != null){
                    var absorber = Damage.findAbsorber(b.team, x, y, other.x, other.y);
                    if(absorber != null){
                        other = absorber;
                    }

                    if(other.power != null && other.power.graph.getLastPowerProduced() > 0f){
                        other.applySlowdown(powerSclDecrease, timeDuration);
                        other.damage(damage * powerDamageScl);
                        hitPowerEffect.at(other.x, other.y, b.angleTo(other), hitColor);
                        chainEffect.at(x, y, 0, hitColor, other);
                    }
                }
            });

            if(hitUnits){
                Units.nearbyEnemies(b.team, x, y, radius, other -> {
                    if(other.team != b.team && other.hittable()){
                        var absorber = Damage.findAbsorber(b.team, x, y, other.x, other.y);
                        if(absorber != null){
                            return;
                        }

                        hitPowerEffect.at(other.x, other.y, b.angleTo(other), hitColor);
                        chainEffect.at(x, y, 0, hitColor, other);
                        other.damage(damage * unitDamageScl);
                        other.apply(status, statusDuration);
                    }
                });
            }
        }
    }
}
