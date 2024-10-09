public class MobileApp implements WeatherObserver {
    @Override
    public void update(float tempaeratura, float humitat, float pressio){
        System.out.println("MobileApp: La temperatura és de " + tempaeratura + "ºC");
    }
}
