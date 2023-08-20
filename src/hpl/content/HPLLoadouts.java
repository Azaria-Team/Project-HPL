package hpl.content;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

public class HPLLoadouts{
    public static Schematic
            basicLegion;

    public static void load(){
        basicLegion = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZeBySixO9UlNz8zPY+BOSS1OLsosKAFxGBjYchKTUnOKGZiiYxkZ+DMKcnST84tSdXMgihkYGEGIkYEZACntE08=");
    }
}
