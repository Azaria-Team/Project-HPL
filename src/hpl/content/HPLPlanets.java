package hpl.content;

import arc.graphics.Color;
import hpl.maps.generators.AurionaPlanetGenerator;
import mindustry.content.*;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.type.*;

public class HPLPlanets {
    public static Planet aStar, bStar, auriona;

    public static void load() {
        aStar = new Planet("aStar", null, 6f){{
            bloom = true;
            accessible = false;

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
            accessible = true;
            orbitRadius = 130f;
            camRadius = 6f;
            visible = true;
            alwaysUnlocked = true;
            drawOrbit = false;
            orbitTime = 10 * 60f * 60f * 60f * 60f;
            rotateTime = 2 * 60f * 60f * 60f;

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

        auriona = new Planet("auriona", aStar, 1.2f, 4){{
            generator = new AurionaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 7);
            cloudMeshLoader = () -> new MultiMesh( // 81ffd7 old color > 5de7a3
                    new HexSkyMesh(this, 11, 0.25f, 0.14f, 5, Color.valueOf("5de7a3").a(0.75f), 2, 0.45f, 0.87f, 0.38f),
                    new HexSkyMesh(this, 2, 0.6f, 0.17f, 5, Color.valueOf("c1f4e4").a(0.75f), 2, 0.45f, 1f, 0.43f)
            );

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 2;
            tidalLock = true;
            orbitTime = 2 * 60f * 60f * 60f * 60f;
            rotateTime = 17 * 60f * 60f * 60f;



            allowLaunchToNumbered = false;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            iconColor = Color.valueOf("24b95a");
            atmosphereColor = Color.valueOf("24b95a");
			defaultCore = HPLBlocks.coreLegion;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            orbitRadius = 60f;
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("24b95a");
            hiddenItems.addAll(Items.erekirItems).addAll(Items.serpuloItems).removeAll(HPLItems.aurionaItems);
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = true;
                r.coreDestroyClear = true;
            };
        }};
    }
}
