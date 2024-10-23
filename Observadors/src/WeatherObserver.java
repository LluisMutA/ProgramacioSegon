public interface WeatherObserver {
    default void update(float tempaeratura, float humitat, float pressio){
    }
}