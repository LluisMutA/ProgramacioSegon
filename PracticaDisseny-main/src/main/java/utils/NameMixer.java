package utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameMixer {

    public String nameGenerator() {
        Random random = new Random();
        List<String> animals;
        List<String> adjectives;
        List<String> combined = new ArrayList<>();
        animals = loadAnimals();
        adjectives = loadAdjectives();

        int size = Math.min(animals.size(), adjectives.size());
        for (int i = 0; i < size; i++) {
            String value1 = animals.get(random.nextInt(animals.size()));
            String value2 = adjectives.get(random.nextInt(adjectives.size()));
            combined.add(value2 + value1);
        }
        return combined.get(random.nextInt(combined.size()));
    }

    private List<String> loadAnimals(){
        List<String> animals = new ArrayList<>();
        animals.add("Axolotl");
        animals.add("Bandicoot");
        animals.add("Bat");
        animals.add("Beagle");
        animals.add("Camel");
        animals.add("Coyote");
        animals.add("Goat");
        animals.add("Kiwi");
        animals.add("Lemming");
        animals.add("Mouse");
        animals.add("Owl");
        animals.add("Peacock");
        animals.add("Sparrow");
        animals.add("Weasel");
        animals.add("Wombat");

        return animals;
    }
    private List<String> loadAdjectives(){
        List<String> adjectives = new ArrayList<>();
        adjectives.add("Admirable");
        adjectives.add("Authentic");
        adjectives.add("Brave");
        adjectives.add("Beloved");
        adjectives.add("Clumsy");
        adjectives.add("Cool");
        adjectives.add("Cute");
        adjectives.add("Dense");
        adjectives.add("Disguised");
        adjectives.add("Euphoric");
        adjectives.add("Evil");
        adjectives.add("Exotic");
        adjectives.add("Fluffy");
        adjectives.add("Grumpy");
        adjectives.add("Infamous");
        adjectives.add("Kaleidoscopic");
        adjectives.add("Lucky");

        return adjectives;
    }
}
