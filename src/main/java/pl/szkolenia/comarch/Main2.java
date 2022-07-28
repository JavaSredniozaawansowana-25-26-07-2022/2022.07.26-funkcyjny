package pl.szkolenia.comarch;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,0,7,8,9);

        /*List<Integer> filteredList = new ArrayList<>();
        for(int number : numbers) {
            if(number > 2 && number < 7) {
                filteredList.add(number);
            }
        }

        for(int i = 0; i < 2; i++) {
            System.out.println(filteredList.get(i));
        }*/

        numbers.stream()
                .filter(i -> i > 2)
                .filter(i -> i < 7)
                .peek(i -> System.out.println(i))
                .sorted((i1, i2) -> i1-i2)
                .limit(2)
                .forEach(i -> System.out.println(i));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Owczarek"));
        dogs.add(new Dog("Sznaucer"));
        dogs.add(new Dog("Pudel"));
        dogs.add(new Dog("Kundel"));

        List<String> raceList = dogs.stream()
                .map(dog -> dog.getRace())
                .peek(race -> System.out.println(race))
                .collect(Collectors.toList());

        for (String race : raceList) {
            System.out.println(race);
        }

        int sum = numbers.stream().reduce(0, (acc, i) -> acc + i);

        System.out.println(sum);

        int min = numbers.stream().reduce(9999, (acc, i) -> i<acc ? i : acc);

        System.out.println(min);

        long count = numbers.stream().filter(i -> i > 3).count();
        System.out.println(count);

        boolean ok = numbers.stream().allMatch(i -> i < 9);
        System.out.println(ok);

        int[] tab = {1,2,3,4};
        OptionalDouble average = Arrays.stream(tab).average();
        double d = average.getAsDouble();

        Optional<Dog> dogBox = getDogFromDB(6);
        if(dogBox.isPresent()) {
            System.out.println(dogBox.get().getRace());
        }

        dogBox.orElseGet(() -> new Dog("Domyślny"));

        /*Optional<Integer> first = numbers.stream().filter(i -> i > 3).findFirst();
        if(first.isPresent()) {
            System.out.println(first.get());
        }*/

        Dog dog2 = null;
        Optional<Dog> dogBox2 = Optional.of(dog2);
        System.out.println(dogBox2.isPresent());
    }

    public static Optional<Dog> getDogFromDB(int id) {
        if(id == 5) {
            return Optional.of(new Dog("Kundel"));
        } else {
            return Optional.empty();
        }
    }
}
