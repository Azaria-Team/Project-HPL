package hpl.content;

import arc.util.Time;
import hpl.type.weather.Element;
import hpl.type.weather.StormWeather;
import hpl.type.weather.WeatherElement;
import mindustry.type.Weather;

public class HPLWheather {
    public static Weather
            storm;

    public static void load() {
        storm = new StormWeather("storm") {{
            density = 400f;
            sizeMin = 20f;
            sizeMax = 30f;

            xspeed = -18;
            yspeed = -16f;
            stroke = 0.8f;
            soundVol = 0.8f;
            duration = 5 * Time.toMinutes;
            padding = 45f;
            force = 0.8f;
            element = new Element[]{new WeatherElement.Thunder("")};
        }};
    }
}
