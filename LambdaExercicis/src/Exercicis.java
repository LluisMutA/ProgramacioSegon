
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

public class Exercicis {
    /**
     * Torna un supplier que sempre torna "Hello"
     */
    public static Supplier<String> helloSupplier() {
        /*Supplier<String> eys = */return () -> "Hello";
    }

    /**
     *
     * Torna un Predicate que mira si l'string és buit
     *
     */
    public static Predicate<String> isEmptyPredicate() {
        Predicate<String> esBuit = str -> str.isEmpty();
        return esBuit;
    }

    /**
     *
     * Torna un Function que accepta un String que retorna aquest string repetit
     * n vegades, on n es passa com a argument de la funció.
     *
     */
    public static BiFunction<String, Integer, String> stringMultiplier() {
       // return (str, u) -> str.repeat(u); Mes simple

        return (str, u) -> {
            String res = "";
            for (int i = 0; i < u; i++) {
                res += str;
            }
            return res;
        };
    }

    /**
     *
     * Torna un Function que converteix un BigDecimal a String que comença pel símbol "$"
     *
     */
    public static Function<BigDecimal, String> toDollarStringFunction() {
        return (n) -> "$" + n.toString();
    }

    /**
     *
     * Es reben dos paràmetres que representen un rang (min,max) i retorna
     * un Predicate<String> que verifica si la longitud de l'string està
     * dins aquest rang.
     *
     */
    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        return (s) -> s.length() >= min && s.length() <= max;
    }

    /**
     *
     * Retorna un Supplier de números enters aleatoris
     *
     */
    public static IntSupplier randomIntSupplier() {
        return () -> (int) (Math.random()*10);
    }


    /**
     *
     * Retorna un IntUnaryOperator que reb un int com un límit que a la vegada
     * retorna un número aleatori dins aquest límit
     *
     */
    public static IntUnaryOperator boundedRandomIntSupplier() {
        return (maxim) -> (int) (Math.random() * maxim);
    }

    /**
     *
     * Retorna un IntUnaryOperator que calcula un quadrat d'un número
     *
     */
    public static IntUnaryOperator intSquareOperation() {
        return num -> num*num;
    }

    /**
     *
     * Retorna un LongBinaryOperator que realitza l'operació de suma
     *
     */
    public static LongBinaryOperator longSumOperation() {
        return (a, b) -> a + b;
    }

    /**
     *
     * Retorna un ToIntFunction<String> que converteix un String a un Integer
     *
     */
    public static ToIntFunction<String> stringToIntConverter() {
        return str -> Integer.valueOf(str);
    }

    /**
     *
     * Reb un paràmetre n (int), i retorna un Supplier que proporciona un IntUnaryOperator
     * que realitza la funció f(x) = n * x
     *
     */
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {

        return null;
    }

    /**
     *
     * Retorna una funció que composa funcions amb la funció trim() de String
     *
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        return func -> func.compose(s -> s.trim());
    }

    /**
     *
     * Reb un Runnable com a paràmetre i retorna un Supplier<Thread>
     * Aquest thread s'iniciarà quan es cridi al mètode "get()" del supplier.
     *
     */
    public static Supplier<Thread> runningThreadSupplier(Runnable runnable) {
        return () -> {
            Thread t = new Thread(runnable);
            t.start();
            return t;
        };
    }

    /**
     *
     * Retorna un Consumer que accepta un Runnable com a paràmetre i l'executa
     * dins un nou fil (thread)
     *
     */
    public static Consumer<Runnable> newThreadRunnableConsumer() {
        throw new RuntimeException("TODO");
    }

    /**
     *
     * Retorna una Function que accepta una instància d'un Runnable i retorna
     * un Supplier d'un Thread que s'ha creat per aquest Runnable.
     *
     */
    public static Function<Runnable, Supplier<Thread>> runnableToThreadSupplierFunction() {
        throw new RuntimeException("TODO");
    }

    /**
     *
     * Retorna una BiFunction que té 2 paràmetres.
     *
     * El primer serà un IntUnaryOperator, que és una funció "integer".
     *
     * El segon serà un IntPredicate, que és una condició sobre un integer.
     *
     * Aquesta BiFunction tornarà una funció composada, que farà el següent:
     *
     * - Si el IntPredicate verifica la seva condició, aplicarà la funció
     * - Si el IntPredicate no es compleix, retorna el mateix element que s'ha rebut
     *
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        return new BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(IntUnaryOperator op, IntPredicate pred) {
                if (pred.test());
            }
        }
    }

    /**
     *
     * Torna una BiFunction, on el primer paràmetre és un un Map (la clau és una nom d'una funció
     * i el valor és una funció tipus IntUnaryOperator), el segon paràmetre és un String, que és
     * també el nom d'una funció.
     *
     * Si el Map conté una funció amb el nom del segon paràmetre, aleshores es torna la funció
     * emmagatzemada al map. Si no hi és, tornem la funció "identity()", que no és més que una
     * funció que retorna el mateix paràmetre que li passem.
     *
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        return new BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(Map<String, IntUnaryOperator> sintop, String s) {
                if (sintop.containsKey(s)){
                    return sintop.get(s);
                }
                return p -> p;
            }
        };
    }

    /**
     *
     * Retorna un Supplier d'un Supplier d'un Supplier de l'string "BEN FET!"
     *
     */
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        return () -> () -> () -> "BEN FET!";
    }
}
