package hpl.content;

import arc.graphics.Color;
import hpl.content.HPLBlocks.*;
import hpl.content.blocks.HPLCoreRelatedBlocks;
import hpl.maps.generators.AurionaPlanetGenerator;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;

import static hpl.content.HPLItems.aurionaItems;
import static mindustry.content.Planets.erekir;
import static mindustry.content.Planets.serpulo;

public class HPLPlanets {
    public static Planet aStar, bStar, auriona;

    public static void load() {
        aStar = new Planet("aStar", null, 6f){{
            bloom = true;
            accessible = false;
            rotateTime = 20f * 60f;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("e6d3ff"),
                    Color.valueOf("e6d3ff"),
                    Color.valueOf("bfa1ff"),
                    Color.valueOf("bfa1ff"),
                    Color.valueOf("8686ff"),
                    Color.valueOf("6e6eed")
            );
        }};

        bStar = new Planet("bStar", aStar, 5f){{
            bloom = true;
            accessible = false;
            orbitRadius = 130f;
            visible = true;
            drawOrbit = false;
            orbitTime = 20 * 60f * 60f;
            rotateTime = 20f * 60f;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("ffc87c"),
                    Color.valueOf("ffc87c"),
                    Color.valueOf("ffa853"),
                    Color.valueOf("ffa853"),
                    Color.valueOf("ff593d"),
                    Color.valueOf("ff3d40")
            );
        }};

        auriona = new Planet("auriona", aStar, 1.2f, 3){{
            generator = new AurionaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 7);
            cloudMeshLoader = () -> new MultiMesh( // 81ffd7 old color > 5de7a3
                    new HexSkyMesh(this, 11, 0.25f, 0.14f, 6, Color.valueOf("5de7a3").a(0.75f), 2, 0.45f, 0.87f, 0.38f),
                    new HexSkyMesh(this, 2, 0.6f, 0.17f, 6, Color.valueOf("c1f4e4").a(0.75f), 2, 0.45f, 1f, 0.43f)
            );

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            orbitTime = 2 * 60f * 60f;
            rotateTime = 34f * 60f;
            orbitSpacing = 10;

            allowLaunchToNumbered = false;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = false;
            iconColor = Color.valueOf("24b95a");
            atmosphereColor = Color.valueOf("24b95a");
			defaultCore = HPLCoreRelatedBlocks.coreLegion;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            orbitRadius = 60f;
            clearSectorOnLose = true;
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("24b95a");
            serpulo.hiddenItems.addAll(aurionaItems).removeAll(Items.serpuloItems);
            erekir.hiddenItems.addAll(aurionaItems).removeAll(Items.erekirItems);
            itemWhitelist = aurionaItems;
           // hiddenItems.addAll(Items.erekirItems).removeAll(aurionaItems);
          //  hiddenItems.addAll(Items.serpuloItems).removeAll(aurionaItems);
            //hiddenItems.addAll(Items.serpuloItems).addAll(Items.erekirItems).addAll(Items.erekirOnlyItems).removeAll(aurionaItems);
            ruleSetter = r -> {
                r.waveTeam = HPLTeam.testteam;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = true;
                r.coreDestroyClear = true;
                r.onlyDepositCore = false;
                unlockedOnLand.add(HPLCoreRelatedBlocks.coreLegion);
            };
        }};
    }
}
