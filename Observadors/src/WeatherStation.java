public class WeatherStation implements WeatherObserver {
    @Override
    public void update(float tempaeratura, float humitat, float pressio){
        System.out.println("WeatherStation: La temperatura és de: " + Math.round(tempaeratura) + "ºC - L'humitat és del: "
                            + Math.round(humitat) + "% - La pressió es de: " + pressio + " hPA");
    }
}