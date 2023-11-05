package hpl.content.blocks;

import hpl.content.HPLBullets;
import hpl.content.HPLFx;
import hpl.content.HPLItems;
import hpl.content.HPLLiquids;
import hpl.graphics.HPLPal;
import hpl.world.blocks.defense.turret.BlockRepairTurret;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.consumers.ConsumeLiquids;
import mindustry.world.draw.DrawTurret;

import static mindustry.type.ItemStack.with;

public class HPLTurrets {
    
    public static Block
    forceTurret, hornTurret,
    raze;

    public static void load() {
        forceTurret = new ItemTurret("force"){{
            requirements(Category.turret, with(HPLItems.fors, 70, HPLItems.khylid, 25));
            researchCost = with(HPLItems.fors, 150, HPLItems.khylid, 70);
            health = 700;
            shootEffect = HPLFx.shootForce;
            smokeEffect = HPLFx.shootSmokeForce;
            reload = 70f;
            inaccuracy = 2f;
            shake = 2f;
            shootY = -2;
            outlineColor = HPLPal.aureliaOutline;
            size = 2;
            recoil = 2f;
            range = 24 * Vars.tilesize;
            shootCone = 10f;
            rotateSpeed = 4f;

            shootSound = Sounds.cannon;
            squareSprite = false;
            itemCapacity = 20;
            coolantMultiplier = 2f;
            coolant = consume(new ConsumeLiquid(HPLLiquids.oxyliteLiq, 10f / 60f));

            ammo(HPLItems.fors, HPLBullets.forceBullet);


            drawer = new DrawTurret("fortified-"){{
                parts.add(
                        new RegionPart("-edge-r"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveRot = -8f;
                        }},
                        new RegionPart("-edge-l"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveRot = 8f;
                        }},
                        new RegionPart("-barrel"){{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveX = 0f;
                            moveY = -1f;
                            moveRot = 0f;
                            x = 0;
                            y = 0;
                        }});
            }};
        }};

        hornTurret = new PowerTurret("horn"){{
            requirements(Category.turret, with(HPLItems.fors, 70, HPLItems.craside, 25));
            researchCost = with(HPLItems.fors, 150, HPLItems.khylid, 70);
            health = 900;
            //shootEffect = HPLFx.shootForce;
            //smokeEffect = HPLFx.shootSmokeForce;
            shootEffect = Fx.none;
            smokeEffect = Fx.none;
            reload = 100f;
            inaccuracy = 0f;
            shake = 4f;
            shootY = -2;
            outlineColor = HPLPal.aureliaOutline;
            size = 2;
            recoil = 4f;
            range = 16 * Vars.tilesize;
            shootCone = 35f;
            rotateSpeed = 3.4f;

            shootSound = Sounds.cannon;
            squareSprite = false;

            shoot = new ShootSpread(7, 6);

            shootType = HPLBullets.hornBullet;
            consumePower(1.5f);
            coolantMultiplier = 2f;
            coolant = consume(new ConsumeLiquid(HPLLiquids.oxyliteLiq, 12f / 60f));

            drawer = new DrawTurret("fortified-"){{
                parts.add(
                        new RegionPart("-blade-r"){{
                            progress = PartProgress.warmup;

                            mirror = false;
                            under = false;
                            moveY = -2;
                            moves.add(new PartMove(PartProgress.reload, 0f, 6f, 0f));
                        }},

                        new RegionPart("-blade-l"){{
                            progress = PartProgress.warmup;
                            mirror = false;
                            under = false;
                            moveY = -2;
                            moves.add(new PartMove(PartProgress.reload, 0f, 6f, 0f));
                        }},

                        new RegionPart("-piston"){{
                            progress = PartProgress.recoil;
                            mirror = false;
                            under = false;
                            moveX = 0f;
                            moveY = -3f;
                            moveRot = 0f;
                            x = 0;
                            y = 0;
                        }});
            }};
        }};
/*
        raze = new PowerTurret("raze") {{
            size = 3;
            requirements(Category.turret, with(HPLItems.superdenseAlloy, 300));
        }};


 */
    }
}
