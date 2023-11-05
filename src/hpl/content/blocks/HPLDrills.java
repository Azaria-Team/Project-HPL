package hpl.content.blocks;

import hpl.content.HPLAttribute;
import hpl.content.HPLFx;
import hpl.content.HPLItems;
import hpl.graphics.HPLPal;
import hpl.world.blocks.production.HPLBurstDrill;
import hpl.world.blocks.production.OreRadar;
import hpl.world.draw.DrawDrillPart;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.with;

public class HPLDrills {
    public static Block
    forsDrill, pumpDrill, waveDrill, oreDetector;
    public static void load() {
        forsDrill = new AttributeCrafter("fors-block") {{
            requirements(Category.production, with(HPLItems.fors, 20));
            researchCost = with(HPLItems.fors, 5);
            attribute = HPLAttribute.forsattr;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HPLItems.fors, 4);
            craftTime = 240f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            displayEfficiency = false;
            size = 2;
            craftEffect = HPLFx.forsDrillEffect;
            squareSprite = false;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = HPLPal.fors;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
        }};
        pumpDrill = new AttributeCrafter("pump-drill") {{
            requirements(Category.production, with(HPLItems.fors, 40));
            researchCost = with(HPLItems.fors, 7);
            attribute = HPLAttribute.khylidattr;
            group = BlockGroup.liquids;
            minEfficiency = 4f - 0.0001f;
            baseEfficiency = 0f;
            boostScale = 1f / 4f;
            outputItem = new ItemStack(HPLItems.khylid, 4);
            craftTime = 160;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            consumePower(0.5f);
            displayEfficiency = false;
            size = 2;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.8f;
                        color = HPLPal.khylid;
                        glowIntensity = 0.1f;
                        glowScale = 9f;
                    }}
            );
            squareSprite = false;
        }};
        waveDrill = new HPLBurstDrill("wave-drill"){{
            requirements(Category.production, with(HPLItems.fors, 35, HPLItems.craside, 15));
            drillTime = 60f * 5f;
            size = 3;
            hasPower = true;
            tier = 3;
            //drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            shake = 3f;
            itemCapacity = 20;
            researchCost = with(HPLItems.fors, 50);

            fogRadius = 4;
            consumePower(15f / 60f);
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawDrillPart(11f / 4f){{
                        shadowOffset = 1f;
                        baseOffset = 1.0f; //you're fucking genius to write 4.0f/4.0f;
                        layer = Layer.blockOver;
                        angleOffset = 135;
                        drawPlan = false;

                    }},
                    new DrawRegion("-top"){{
                        layer = Layer.blockOver + 0.1f;
                    }}
            );
        }};

        oreDetector = new OreRadar("ore-detector") {{
            requirements(Category.production, with(HPLItems.fors, 20, HPLItems.khylid, 20, HPLItems.craside, 35));
            size = 3;
            consumePower(30f/60f);
        }};
    }
}
