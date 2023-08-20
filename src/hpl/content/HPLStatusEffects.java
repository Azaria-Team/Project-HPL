package hpl.content;

import arc.graphics.Color;
import hpl.HPL;
import hpl.graphics.HPLPal;
import mindustry.type.StatusEffect;

public class HPLStatusEffects {
    public static StatusEffect decomposition, advancedDecomposition;

    public static void load() {
        decomposition = new StatusEffect ("decomposition") {{
            damage = 0.25f;
            healthMultiplier = 0.8f;
            speedMultiplier =  0.5f;
        }};

        advancedDecomposition = new StatusEffect("no-sprite-because-rename") {{
            damage = 1.1f;
            healthMultiplier = 0.7f;
            buildSpeedMultiplier = 0.8f;
        }};
    }
}
