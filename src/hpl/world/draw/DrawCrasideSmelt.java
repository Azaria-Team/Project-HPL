package hpl.world.draw;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.world.draw.DrawBlock;

public class DrawCrasideSmelt extends DrawBlock {
    public Color flameColor = Color.valueOf("craside"), midColor = Color.valueOf("craside");
    public float circleStroke = 1.5f;

    public float layer = Layer.block;
    public float alpha = 0.68f;
    public int particles = 15;
    public float particleLife = 30f, particleRad = 10f;
    public Blending blending = Blending.additive;

    @Override
    public void draw(Building build){
        if(build.warmup() > 0f && flameColor.a > 0.001f){

            float a = alpha * build.warmup();
            Draw.blend(blending);

            Draw.color(midColor, a);

            float base = (Time.time / particleLife);
            rand.setSeed(build.id);
            for(int i = 0; i < particles; i++){
                float fin = (rand.random(1f) + base) % 1f, fout = 1f - fin;
                float len = particleRad * Interp.pow2Out.apply(fin);
                Fill.circle(build.x + len, build.y + len, particleRad * fout * build.warmup());
            }

            Draw.blend();
            Draw.reset();
        }
    }
}
