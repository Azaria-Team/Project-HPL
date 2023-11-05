package hpl.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Vec2;
import arc.struct.Seq;
import arc.util.Time;
import hpl.graphics.HPLPal;
import mindustry.core.Renderer;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;

public class HPLFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();
    public static final Effect

    forsDrillEffect = new Effect(30, e -> {
        color(Color.white, HPLPal.fors, e.fin());
        randLenVectors(e.id, 5, 2f + 14f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 2.5f + 0.5f);
        });
    }),

    smokeEvaporatorSmall = new Effect(50, e -> {
        color(Color.white, e.fin());
        randLenVectors(e.id, 3, 2f + 8f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 2f + 0.2f);
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
        });
    }),
    smokeEvaporatorBig = new Effect(30, e -> {
        color(Color.white, e.fin());
        randLenVectors(e.id, 5, 2f + 12f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 2f + 0.2f);
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
        });
    }),

    crasideBrewerSmoke = new Effect(120, e -> {
        color(HPLPal.craside, HPLPal.craside2, e.fin());
        randLenVectors(e.id, 10, 1f + 6f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 2 + 0.1f);
            Fill.circle(e.x + x / 0.9f, e.y + y / 3f, e.fout());
        });
        randLenVectors(e.id, 8, 1f + 10f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 4 + 0.1f);
            Fill.circle(e.x + x / 0.9f, e.y + y / 6f, e.fout());
        });
    }).layer(Layer.block + 0.05f),

    hitExplosion = new Effect(30, e -> {
        color(HPLPal.vogPink);
        e.scaled(7, i -> {
            stroke(3f * i.fout());
            Lines.circle(e.x, e.y, 3f + i.fin() * 10f);
        });

        color(HPLPal.vogPink);

        randLenVectors(e.id, 7, 2f + 19f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
        });

        color(HPLPal.vogPink, HPLPal.vogPinkBack, Color.pink, e.fin());
        stroke(1.5f * e.fout());

        randLenVectors(e.id + 1, 8, 1f + 23f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
        });
    }),

    explosionSmall2 = new Effect(20, e -> {
        color(HPLPal.vogPink);
        e.scaled(8, i -> {
            stroke(2f * i.fout());
            Lines.circle(e.x, e.y, 2f + i.fin() * 5f);
        });

        color(HPLPal.vogPink, HPLPal.vogPinkBack, Color.pink, e.fin());
        stroke(1.01f * e.fout());

        randLenVectors(e.id + 1, 4, 1f + 16 * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 2f);
        });
    }),

    blueHitExplosion1 = new Effect(30, e -> {
        color(HPLPal.droneBullet);
        e.scaled(7, i -> {
            stroke(3f * i.fout());
            Lines.square(e.x, e.y, 3f + i.fin() * 10f, e.rotation * Mathf.random(20) * Time.delta);
        });

        color(HPLPal.droneBullet);

        color(HPLPal.droneBullet, HPLPal.droneBulletBack, e.fin());
        stroke(1.5f * e.fout());

        randLenVectors(e.id + 1, 8, 1f + 23f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
        });
    }),

    smallestBlueExplosion= new Effect(20, e -> {
        color(HPLPal.droneBullet);

        color(HPLPal.droneBullet, HPLPal.droneBulletBack, e.fin());
        stroke(0.50f * e.fout());

        randLenVectors(e.id + 1, 2, 1f + 5 * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 0.5f + e.fout() * 1f);
        });
    }),


    smallBlueExplosion= new Effect(20, e -> {
        color(HPLPal.droneBullet);
        e.scaled(8, i -> {
            stroke(2f * i.fout());
            Lines.square(e.x, e.y, 2f + i.fin() * 5f, e.rotation * Mathf.random(20) * Time.delta);
        });

        color(HPLPal.droneBullet, HPLPal.droneBulletBack, e.fin());
        stroke(1.01f * e.fout());

        randLenVectors(e.id + 1, 4, 1f + 16 * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 2f);
        });
    }),

    blueHitExplosionNormal = new Effect(30, e -> {
        color(HPLPal.droneBullet);
        e.scaled(10, i -> {
            stroke(3f * i.fout());
            Lines.square(e.x, e.y, 5f + i.fin() * 15f, e.rotation * Mathf.random(30) * Time.delta);
        });

        color(HPLPal.droneBullet);

        color(HPLPal.droneBullet, HPLPal.droneBulletBack, e.fin());
        stroke(1.5f * e.fout());

        randLenVectors(e.id + 3, 8, 3f + 25f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 2f + e.fout() * 4f);
        });
    }),

    blueExplosionNormal = new Effect(20, e -> {
        color(HPLPal.droneBullet);
        e.scaled(10, i -> {
            stroke(2f * i.fout());
            Lines.square(e.x, e.y, 3f + i.fin() * 8f, e.rotation * Mathf.random(20) * Time.delta);
        });

        color(HPLPal.droneBullet, HPLPal.droneBulletBack, e.fin());
        stroke(2f * e.fout());

        randLenVectors(e.id + 1, 6, 2f + 19
                * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 2f + e.fout() * 2f);
        });
    }),

    smallGreenExplosion = new Effect(20, e -> {
        color(HPLPal.unmakerColor);
        e.scaled(10, i -> {
            stroke(2f * i.fout());
        });

        color(HPLPal.unmakerColor, Color.white, e.fin());
        stroke(1.01f * e.fout());

        randLenVectors(e.id + 1, 10, 1f + 15 * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 0.5f + e.fout() * 1.5f);
        });
    }),

    vogTrail = new Effect(15, e -> {
        color(HPLPal.vogPink, HPLPal.vogPinkBack, e.fin());
        stroke(0.3f + e.fout() * 0.7f);
        rand.setSeed(e.id);

        for(int i = 0; i < 1; i++){
            float rot = e.rotation + rand.range(10f) + 180f;
            v.trns(rot, rand.random(e.fin() * 18f));
            lineAngle(e.x + v.x, e.y + v.y, rot, e.fout() * rand.random(1f, 4f) + 1f);
        }
    }),

    aimMissileTrail = new Effect(20f, 50f, e -> {
        color(HPLPal.vogPink, HPLPal.vogPinkBack, Color.pink,  e.fin() * e.fin());

        randLenVectors(e.id, 4, 1f + e.finpow() * 15, e.rotation + 180, 7f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.30f + e.fout() * 1.1f);
        });
    }),

    unmakerBulletTrail = new Effect(50, e -> {
        color(HPLPal.unmakerColor);
        Fill.circle(e.x, e.y, e.rotation * e.fout());
    }).layer(Layer.bullet - 0.001f), //below bullets

    shootForce = new Effect(10, e -> {
        color(HPLPal.vogPink, e.fin());
        float w = 1.3f + 10 * e.fout();
        Drawf.tri(e.x, e.y, w, 20f * e.fout(), e.rotation);
        Drawf.tri(e.x, e.y, w, 5f * e.fout(), e.rotation + 180f);
    }),

    shootSmokeForce = new Effect(60f, e -> {
        rand.setSeed(e.id);
        for(int i = 0; i < 10; i++){
            v.trns(e.rotation + rand.range(10f), rand.random(e.finpow() * 20f));
            e.scaled(e.lifetime * rand.random(0.1f, 0.3f), b -> {
                color(e.color, HPLPal.forceBullet, b.fin());
                Fill.circle(e.x + v.x, e.y + v.y, b.fout() * 2f + 0.3f);
            });
        }
    }),

    forceBulletTrail = new Effect(25, e -> {
        color(HPLPal.forceBullet, HPLPal.forceBulletBack, e.fin());

        stroke(0.6f + e.fout() * 0.9f);
        rand.setSeed(e.id);

        color(HPLPal.forceBullet, HPLPal.forceBulletBack, e.fin());
        for(int i = 0; i < 1; i++){
            float rot = e.rotation + rand.range(20f) + 180f;
            v.trns(rot, rand.random(e.fin() * 20f));
            lineAngle(e.x + v.x, e.y + v.y, rot, e.fout() * rand.random(2f, 3f) + 1f);
        }

    }),

    forceBulletHit = new Effect(30, e -> {
        color(HPLPal.fors);
        e.scaled(10, i -> {
            stroke(4f * i.fout());
            Lines.circle(e.x, e.y, 7f + i.fin() * 15f);
        });

        color(HPLPal.fors);

        randLenVectors(e.id, 10, 3f + 20f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 2f + 0.7f);
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
        });

        color(HPLPal.vogPink, HPLPal.vogPinkBack, Color.pink, e.fin());
        stroke(1.5f * e.fout());
    }),

    forceBulletDespawn = new Effect(30, e -> {
        color(HPLPal.fors);
        e.scaled(10, i -> {
            stroke(4f * i.fout());
            Lines.circle(e.x, e.y, 7f + i.fin() * 15f);
        });

        color(HPLPal.vogPink, HPLPal.vogPinkBack, Color.pink, e.fin());
        stroke(1.5f * e.fout());

        randLenVectors(e.id + 1, 10, 1f + 30f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 2f + e.fout() * 3f);
        });
    }),

    hornBulletHit = new Effect(30, e -> {
        color(HPLPal.craside);
        e.scaled(10, i -> {
            stroke(4f * i.fout());
            Lines.circle(e.x, e.y, 7f + i.fin() * 15f);
        });

        color(HPLPal.craside);

        randLenVectors(e.id, 10, 3f + 20f * e.finpow(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fout() * 2f + 0.7f);
            Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
        });

        color(HPLPal.craside, HPLPal.craside2, Color.orange, e.fin());
        stroke(1.5f * e.fout());
    }),

    hornBulletDespawn = new Effect(30, e -> {
        color(HPLPal.craside);
        e.scaled(10, i -> {
            stroke(4f * i.fout());
            Lines.circle(e.x, e.y, 7f + i.fin() * 15f);
        });

        color(HPLPal.craside, HPLPal.craside2, Color.orange, e.fin());
        stroke(1.5f * e.fout());

        randLenVectors(e.id + 1, 10, 1f + 30f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 2f + e.fout() * 3f);
        });
    }),

    lightning2 = new Effect(10f, 500f, e -> {
        if(!(e.data instanceof Seq)) return;
        Seq<Vec2> lines = e.data();

        stroke(3f * e.fout());
        color(e.color, Color.white, e.fin());
        Draw.alpha(Renderer.laserOpacity);

        for(int i = 0; i < lines.size - 1; i++){
            Vec2 cur = lines.get(i);
            Vec2 next = lines.get(i + 1);

            Lines.line(cur.x, cur.y, next.x, next.y, false);
        }

        for(Vec2 p : lines){
            Fill.circle(p.x, p.y, Lines.getStroke() / 2f);
        }
    });

    public static void lightning(float x1, float y1, float x2, float y2, Color c, int iterations, float rndScale, Effect e) {
        Seq<Vec2> lines = new Seq<>();
        boolean swap = Math.abs(y1 - y2) < Math.abs(x1 - x2);
        if(swap) {
            lines.add(new Vec2(y1, x1));
            lines.add(new Vec2(y2, x2));
        } else {
            lines.add(new Vec2(x1, y1));
            lines.add(new Vec2(x2, y2));
        }
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < lines.size - 1; j += 2) {
                Vec2 v1 = lines.get(j), v2 = lines.get(j + 1);
                Vec2 v = new Vec2((v1.x + v2.x) / 2, ((v1.y + v2.y) / 2));
                float ang = (v2.angle(v1) + 90f) * Mathf.degRad;
                float sin = Mathf.sin(ang), cos = Mathf.cos(ang);
                float rnd = Mathf.random(rndScale);
                v.x += rnd * sin;
                v.y += rnd * cos;
                lines.insert(j + 1, v);
            }
        }
        if(swap) {
            for(int i = 0; i < lines.size; i++) {
                Vec2 v = lines.get(i);
                float px = v.x;
                v.x = v.y;
                v.y = px;
            }
        }
        e.at(x1, y1, 0f, c, lines);
    }
}
