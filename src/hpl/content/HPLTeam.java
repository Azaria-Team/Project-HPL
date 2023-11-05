package hpl.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Font;
import arc.graphics.g2d.TextureRegion;
import arc.math.geom.Vec2;
import arc.struct.ObjectIntMap;
import arc.struct.ObjectMap;
import arc.struct.Seq;
import arc.util.Reflect;
import arc.util.Scaling;
import mindustry.game.Team;
import mindustry.ui.Fonts;

public class HPLTeam {
    public static Team testteam;

    public static void load() {
        testteam = newTeam(7, "auriona", Color.valueOf("68FFF8"));
    }

    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = Color.valueOf("219db1");
        team.palette[2] = Color.valueOf("1c6192");

        for(int i = 0; i < 3; i++){
            team.palettei[i] = team.palette[i].rgba();
        }

        //attempt to load the team icon
        Seq<Font> fonts = Seq.with(Fonts.def, Fonts.outline);

        var ch = 65000 + id;
        Reflect.<ObjectIntMap<String>>get(Fonts.class, "unicodeIcons").put(name, ch);
        var stringIcons = Reflect.<ObjectMap<String, String>>get(Fonts.class, "stringIcons");
        stringIcons.put(name, ((char)ch) + "");

        int size = (int)(Fonts.def.getData().lineHeight/Fonts.def.getData().scaleY);
        TextureRegion region = Core.atlas.find("hpl-team-" + name);
        Vec2 out = Scaling.fit.apply(region.width, region.height, size, size);
        Font.Glyph glyph = new Font.Glyph(){{
            id = ch;
            srcX = 0;
            srcY = 0;
            width = (int)out.x;
            height = (int)out.y;
            u = region.u;
            v = region.v2;
            u2 = region.u2;
            v2 = region.v;
            xoffset = 0;
            yoffset = -size;
            xadvance = size;
            kerning = null;
            fixedWidth = true;
            page = 0;
        }};
        fonts.each(f -> f.getData().setGlyph(ch, glyph));

        //now put whatever the heck we get for an emoji
        team.emoji = stringIcons.get(team.name, "");

        return team;
    }
}
