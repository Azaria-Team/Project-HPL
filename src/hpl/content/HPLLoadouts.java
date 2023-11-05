package hpl.content;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

public class HPLLoadouts{
    public static Schematic
            basicLegion;

    public static void load(){
        basicLegion = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZWBJSixOZeBOSS1OLsosKMnMz2NgYGDLSUxKzSlmYIqOZWTgzyjI0U3OL0rVzUlNh8gzghCQAACQQREI");
    }
}
