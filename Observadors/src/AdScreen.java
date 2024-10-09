public class AdScreen implements WeatherObserver {
    @Override
    public void update(float tempaeratura, float humitat, float pressio){
                if(tempaeratura > 30){System.out.println("AdScreen: La temperatura és de: " + tempaeratura);}
                if(pressio < 1000){System.out.println("AdScreen: La pressió és baixa, plujes probables");}
    }
}
