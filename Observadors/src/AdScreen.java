public class AdScreen implements WeatherObserver {
    @Override
    public void update(float tempaeratura, float humitat, float pressio){
                if(tempaeratura > 30 && tempaeratura < 40){System.out.println("AdScreen: La temperatura és de " + tempaeratura + "ºC \uD83E\uDD75");}
                if(tempaeratura > 40){System.out.println("AdScreen: La temperatura és de " + tempaeratura + "ºC \uD83D\uDC80");}
                if(pressio < 1000){System.out.println("AdScreen: La pressió és baixa, alta probabilitat de plujes \uD83C\uDF27\uFE0F");}
    }
}