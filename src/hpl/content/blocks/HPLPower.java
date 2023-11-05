package hpl.content.blocks;

import hpl.content.HPLAttribute;
import hpl.content.HPLFx;
import hpl.content.HPLItems;
import hpl.content.HPLLiquids;
import hpl.graphics.HPLPal;
import hpl.world.blocks.power.LightningPowerNode;
import hpl.world.blocks.power.ThermalEvaporator;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class HPLPower {
    public static Block
    plasmaNode, plasmaNodeLarge, plasmaDistributor, plasmaDistributorLarge, oxyliteTurbine, thermalEvaporator;
    public static void load() {
        plasmaNode = new LightningPowerNode("plasma-node", 0) {{
            requirements(Category.power, with(HPLItems.fors, 3));
            researchCost = with(HPLItems.fors, 25);

            consumePowerBuffered(1000f);
            lightningRange = 17 * 8f;
            thresholdPerTile = 0.1f / 8f;
        }};

        plasmaNodeLarge = new LightningPowerNode("plasma-node-large", 0) {{
            //todo crafting
            requirements(Category.power, with(HPLItems.khylid, 20, HPLItems.craside, 20));
            consumePowerBuffered(5000f);
            size = 2;
            lightningRange = 28 * 8f;
            thresholdPerTile = 0.1f / 8f;
        }};

        plasmaDistributor = new LightningPowerNode("plasma-distributor", 12) {{
            requirements(Category.power, with(HPLItems.fors, 45));
            researchCost = with(HPLItems.fors, 40);
            size = 2;
            consumePowerBuffered(300f);
            lightningRange = 5 * 8f;
            laserRange = 7;
            thresholdPerTile = 0.1f / 8f;
            //buildCostMultiplier = 8f;
        }};

        plasmaDistributorLarge = new LightningPowerNode("plasma-distributor-large", 24) {{
            //todo crafting
            requirements(Category.power, with(HPLItems.khylid, 20, HPLItems.craside, 20));
            consumePowerBuffered(5000f);
            size = 3;
            lightningRange = 15 * 8f;
            laserRange = 16;
            thresholdPerTile = 0.1f / 8f;
            buildCostMultiplier = 8f;
        }};

        thermalEvaporator = new ThermalEvaporator("thermal-evaporator") {{
            requirements(Category.power, with(HPLItems.fors, 40));
            researchCost = with(HPLItems.fors, 65);

            powerProduction = 1.5f / 3;
            displayEfficiency = true;
            size = 2;
            floating = true;
            placeableLiquid = true;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            attribute = HPLAttribute.mainlheatattr;
            generateEffect = HPLFx.smokeEvaporatorBig;
            effectChance = 0.2f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion() {{
                        alpha = 0.7f;
                        color = HPLPal.lightningNodeColor;
                        glowIntensity = 0.4f;
                        glowScale = 11f;
                    }}
            );
        }};

        oxyliteTurbine = new ConsumeGenerator("oxylite-turbine"){{
            requirements(Category.power, with(HPLItems.fors, 100, HPLItems.khylid, 35, HPLItems.craside, 55));
            powerProduction = 2.5f;
            itemDuration = 130f;
            consumeLiquid(HPLLiquids.oxyliteLiq, 5f / 60f);
            hasLiquids = true;
            size = 3;
            squareSprite = false;
            generateEffect = HPLFx.smokeEvaporatorSmall;
            researchCostMultiplier = 0.5f;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;

            consumeItems(with(HPLItems.khylid, 2f));

            drawer = new DrawMulti(

                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(HPLLiquids.oxyliteLiq){{
                        padLeft = 2; padRight = 2; padTop = 2; padBottom = 2;
                    }},
                    new DrawDefault(),
                    new DrawBlurSpin("-rotor", 10f)
            );
        }};
    }
}
