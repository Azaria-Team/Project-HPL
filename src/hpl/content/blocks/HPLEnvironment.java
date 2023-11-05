package hpl.content.blocks;

import arc.graphics.Color;
import hpl.content.HPLAttribute;
import hpl.content.HPLItems;
import hpl.content.HPLLiquids;
import hpl.graphics.HPLPal;
import hpl.world.blocks.environment.ModOverlayFloor;
import hpl.world.blocks.environment.UndergroundOre;
import mindustry.Vars;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;

public class HPLEnvironment {
    public static Block
            forsite, forsiteWall, fir, firWall, forenite, foreniteWall,
            kust, bigKust, swampShine, swampShineBoulder,
    //sea biome
    serridDust, serridDustWall, crabStone, crabStoneWall, serridicRock, serridicRockWall,
    //crystal biome
    crystalIce, crystalIceWall, lamprosMineral, lamprosMineralWall, lamprosCrystals,
    //other
    darkSerrid, darkSerridWall, huitaRock, huitaRockWall,
    //liquids
    oxylite, deepOxylite, serridOxylite, darkSerridOxylite,

    //prop
    ancientSus, crabStoneBoulder, serridBoulder, serridicBoulder, huitaBoulder,
            foreniteBoulder, firBoulder, darkSerridBoulder, forsiteBoulder, forsBoulder,
            lamprosBoulder, crystalIceBoulder,
    //ores
    forsOre, ferbiumOre, forsRock, khylidOre;

    public static void load() {

        //region forest biome
        forsite = new Floor("forsite-plates") {{
            variants = 4;
        }};
        forsiteWall = new StaticWall("forsite-wall") {{
            variants = 3;
            forsite.asFloor().wall = this;
        }};
        forsiteBoulder = new Prop("forsite-boulder") {{
            variants = 2;
            forsite.asFloor().decoration = this;
        }};
        forsBoulder = new Prop("fors-boulder") {{
            variants = 2;
            //probably there were no parent floor & you will place this block with your kutty paws uwu
        }};
        forenite = new Floor("forenite") {{
            mapColor = Color.valueOf("313a3b");
            variants = 4;
        }};
        foreniteWall = new StaticWall("forenite-wall") {{
            variants = 3;
            forenite.asFloor().wall = this;
            mapColor = Color.valueOf("869985");
        }};
        foreniteBoulder = new Prop("forenite-boulder") {{
            variants = 3;
            forenite.asFloor().decoration = this;
        }};
        fir = new Floor("fir") {{
            mapColor = Color.valueOf("222625");
            variants = 4;
        }};
        firWall = new StaticWall("fir-wall") {{
            variants = 3;
            fir.asFloor().wall = this;
            mapColor = Color.valueOf("54685e");
        }};
        firBoulder = new Prop("fir-boulder") {{
            variants = 3;
            fir.asFloor().decoration = this;
        }};
        kust = new TreeBlock("kust") {{
            variants = 2;
        }};
        bigKust = new TallBlock("big-kust") {{
            variants = 3;
        }};
        swampShine = new TallBlock("swamp-shine") {{
            variants = 3;
            emitLight = true;
            lightColor = HPLPal.forestLight;
            lightRadius = 7 * Vars.tilesize;
        }};
        swampShineBoulder = new Prop("swamp-shine-boulder") {{
            variants = 3;
            emitLight = true;
            lightColor = HPLPal.forestLight;
            lightRadius = 3 * Vars.tilesize;
        }};
        //endregion forest biome

        //region sea biome
        serridDust = new Floor("serrid-dust") {{
            variants = 4;
        }};
        serridDustWall = new StaticWall("serrid-dust-wall") {{
            variants = 3;
            serridDust.asFloor().wall = this;
        }};
        serridBoulder = new Prop("serrid-boulder") {{
            variants = 3;
            serridDust.asFloor().decoration = this;
        }};
        crabStone = new Floor("crab-stone") {{
            variants = 4;
        }};
        crabStoneWall = new StaticWall("crab-stone-wall") {{
            variants = 3;
            crabStone.asFloor().wall = this;
        }};
        crabStoneBoulder = new Prop("crab-stone-boulder") {{
            variants = 3;
            crabStone.asFloor().decoration = this;
        }};
        serridicRock = new Floor("serridic-rock") {{
            variants = 4;
        }};
        serridicRockWall = new StaticWall("serridic-stone-wall") {{
            variants = 3;
            serridicRock.asFloor().wall = this;
        }};
        serridicBoulder = new Prop("serridic-boulder") {{
            variants = 3;
            serridicRock.asFloor().decoration = this;
        }};
        oxylite = new Floor("oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
            attributes.set(HPLAttribute.mainlheatattr, 0.25f);
            mapColor = Color.valueOf("50a9a8");
        }};
        deepOxylite = new Floor("deep-oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
            drownTime = 140f;
        }};
        serridOxylite = new Floor("serrid-oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
        }};
        darkSerridOxylite = new Floor("dark-serrid-oxylite") {{
            variants = 4;
            liquidDrop = HPLLiquids.oxyliteLiq;
            cacheLayer = CacheLayer.water;
            liquidMultiplier = 1f;
            isLiquid = true;
            albedo = 0.7f;
        }};
        //endregion sea biome

        //region crystal biome
        crystalIce = new Floor("crystal-ice") {{
            variants = 4;
        }};
        crystalIceWall = new StaticWall("crystal-ice-wall") {{
            variants = 2;
            crystalIce.asFloor().wall = this;
        }};
        crystalIceBoulder = new Prop("crystal-ice-boulder") {{
            variants = 3;
            crystalIce.asFloor().decoration = this;
        }};
        lamprosMineral = new Floor("lampros-mineral") {{
            variants = 4;
        }};
        lamprosCrystals = new Floor("lampros-crystals") {{
            variants = 4;
        }};
        lamprosMineralWall = new StaticWall("lampros-mineral-wall") {{
            variants = 3;
            lamprosMineral.asFloor().wall = this;
        }};
        lamprosBoulder = new Prop("lampros-boulder") {{
            variants = 3;
            lamprosMineral.asFloor().decoration = this;
        }};
        //endregion crystal biome

        //region other
        darkSerrid = new Floor("dark-serrid") {{
            variants = 4;
        }} ;
        darkSerridWall = new StaticWall("dark-serrid-wall") {{
            variants = 3;
            darkSerrid.asFloor().wall = this;
        }};
        darkSerridBoulder = new Prop("dark-serrid-boulder") {{
            variants = 3;
            darkSerrid.asFloor().decoration = this;
        }};
        huitaRock = new Floor("huita-rock") {{
            itemDrop = HPLItems.volcanicSerrid;
            variants = 4;
        }};
        huitaRockWall = new StaticWall("huita-rock-wall") {{
            variants = 3;
            huitaRock.asFloor().wall = this;
        }};
        huitaBoulder = new Prop("huita-boulder") {{
            variants = 2;
            huitaRock.asFloor().decoration = this;
        }};
        //endregion other
        //region prop
        ancientSus = new Prop("ancient-sus") {{
            breakable = false;
            size = 1;
            solid = true;

        }};
        //endregion prop

        //ores
        forsOre = new OreBlock(HPLItems.fors){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        ferbiumOre = new UndergroundOre("ore-ferbium"){{
            itemDrop = HPLItems.ferbium;
            generateIcons = false;
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
            variants = 3;
        }};
        forsRock = new ModOverlayFloor("fors-rock") {{
            parent = blendGroup = forsite;
            variants = 2;
            attributes.set(HPLAttribute.forsattr, 1f);
        }};
        khylidOre = new ModOverlayFloor(("khylid-ore")) {{
            parent = blendGroup = oxylite;
            variants = 2;
            cacheLayer = CacheLayer.water;
            attributes.set(HPLAttribute.khylidattr, 1f);
        }};
    }
}
