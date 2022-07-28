package pl.szkolenia.comarch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Function<Integer, Integer> funkcja = integer -> integer * 10;

        int wynik = funkcja.apply(3);
        System.out.println(wynik);

        int wynik2 = funkcja(3);
        System.out.println(wynik2);

        System.out.println(poddajDZialaniuFunkcjiISprawdz(2, funkcja));

        Function<Integer, Integer> function2 = i -> i / 3;

        System.out.println(poddajDZialaniuFunkcjiISprawdz(23, function2));

        BiFunction<Integer, Integer, Double> biFunction = (a, b) -> ((double) a) / ((double) b);

        double wynikDzielenia = biFunction.apply(7,2);
        System.out.println(wynikDzielenia);

        UnaryOperator<String> operatorUnarny = s -> s.replace("a", "");

        System.out.println(operatorUnarny.apply("abcdefa"));

        Predicate<Double> predykat = d -> d > 15.5;

        System.out.println(predykat.test(10.0));

        Supplier<List<Integer>> dostawcaLosowychLiczb = () -> {
            List<Integer> lista = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                lista.add(random.nextInt(100));
            }
            return lista;
        };

        System.out.println(dostawcaLosowychLiczb.get());
        System.out.println(dostawcaLosowychLiczb.get());

        Consumer<List<Integer>> zjadaczList = l -> {
            for (int i = 0; i < l.size(); i++) {
                l.set(i, l.get(i) * 10);
            }

            System.out.println(l);
        };

        zjadaczList.accept(dostawcaLosowychLiczb.get());
    }

    public static int funkcja(int a) {
        return a * 10;
    }

    public static boolean poddajDZialaniuFunkcjiISprawdz(int x, Function<Integer, Integer> f) {
        int wynik = f.apply(x);
        if(wynik > 15) {
            return true;
        } else {
            return false;
        }
    }
}
