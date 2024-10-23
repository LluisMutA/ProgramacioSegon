import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class WeatherData{

    private List<WeatherObserver> observers;
    private float tempaeratura;
    private float humitat;
    private float pressio;

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        MobileApp mobileApp = new MobileApp();
        WeatherStation weatherStation = new WeatherStation();
        AdScreen adScreen = new AdScreen();

        weatherData.afegirObserver(mobileApp);
        weatherData.afegirObserver(weatherStation);
        weatherData.afegirObserver(adScreen);

        Random random = new Random();
        for (int i = 0; i < 10;) {
            float temperature = 20 + random.nextFloat() * 15;
            float humidity = random.nextFloat() * 100;
            float pressure = 980 + random.nextFloat() * 40;

            System.out.println("\nActualització");
            weatherData.setData(temperature, humidity, pressure);


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void afegirObserver(WeatherObserver observer){
        observers.add(observer);
    }

    public void eliminarObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void eliminarTotsObservers(WeatherObserver observer){
        observers.clear();
    }

    public void avisarObservers(){
        observers.forEach(observer -> observer.update(tempaeratura, humitat, pressio));
    }
    public void setData(float tempaeratura, float humitat, float pressio){
        this.tempaeratura =  (float) Math.random()*100;// TODO: crear numeros aleatoris
        this.humitat = (float) Math.random()*50;
        this.pressio = (float) Math.random()*5000;
        avisarObservers();
    }
}