package hpl.content;

import mindustry.type.SectorPreset;

import static hpl.content.HPLPlanets.auriona;

public class HPLSectorPreset {
    public static SectorPreset abandonedShoreline;

    public static void load(){
        abandonedShoreline = new SectorPreset("abandoned-shoreline", auriona, 15){{
            alwaysUnlocked = true;
            difficulty = 1;
            captureWave = 10;
            startWaveTimeMultiplier = 3f;
        }};
    }
}
