package hpl.content;

import arc.graphics.Color;
import hpl.HPL;
import hpl.graphics.HPLPal;
import mindustry.type.StatusEffect;

public class HPLStatusEffects {
    public static StatusEffect weakness, decomposition, ultraSuperDuperMegaDohuaMoschniyBuff;

    public static void load() {
        weakness = new StatusEffect ("weakness") {{

            color = HPLPal.unmakerColor;
            damage = 0.3f;
            healthMultiplier = 0.8f;
            speedMultiplier =  0.5f;
            reloadMultiplier = 1f / 3 * 2;
        }};

        decomposition = new StatusEffect ("decomposition") {{
            damage = 1.4f;
            healthMultiplier = 0.7f;
            buildSpeedMultiplier = 0.8f;
        }};

        ultraSuperDuperMegaDohuaMoschniyBuff = new StatusEffect("ultra-super-duper-mega-dohua-moschniy-buff") {{
           healthMultiplier = 1.5f;
           speedMultiplier = 1.3f;
           buildSpeedMultiplier = 1.3f;
        }};
    }
}
