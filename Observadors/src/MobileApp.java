public class MobileApp implements WeatherObserver {
    @Override
    public void update(float tempaeratura, float humitat, float pressio){
        if(tempaeratura < 15){System.out.println("MobileApp: La temperatura és de " + tempaeratura + "ºC \uD83E\uDD76");}
        if(tempaeratura > 15 && tempaeratura < 30){System.out.println("MobileApp: La temperatura és de " + tempaeratura + "ºC \uD83D\uDE0E");}
        if(tempaeratura > 30 && tempaeratura < 40){System.out.println("MobileApp: La temperatura és de " + tempaeratura + "ºC \uD83E\uDD75");}
        if(tempaeratura > 40){System.out.println("MobileApp: La temperatura és de " + tempaeratura + "ºC \uD83D\uDC80");}
    }
}