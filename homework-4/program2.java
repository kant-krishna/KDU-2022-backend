import java.util.ArrayList;
import java.util.List;

class  Program2 {
    public static void main(String[] args) {
        ArrayList<Random> randoms = new ArrayList<Random>();

        //
        for(Integer i = 0; i < 10000000; i++) {
            randoms.add(new Random(i.toString(), i));
        }

        long intialTime = System.nanoTime();
        for(Integer i = 0; i < 10000000; i++) {
            Integer value = randoms.get(i).getValue();
        }
        long finalTime = System.nanoTime();

        System.out.println("Time taken FOR LOOP: " + (finalTime - intialTime));

        intialTime = System.nanoTime();
        for(Random each: randoms) {
            Integer value = each.getValue();
        }
        finalTime = System.nanoTime();
        System.out.println("Time taken by FOR EACH LOOP: " + (finalTime - intialTime));

        intialTime = System.nanoTime();
        randoms.stream().forEach(random -> {Integer value = random.getValue();});
        finalTime = System.nanoTime();
        System.out.println("Time taken by STREAM: " + (finalTime - intialTime));

        intialTime = System.nanoTime();
        randoms.parallelStream().forEach(random -> {Integer value = random.getValue();});
        finalTime = System.nanoTime();
        System.out.println("Time taken by PARALLEL STREAM: " + (finalTime - intialTime));



    }
}


class Random {
    String name;
    Integer value;
    Random(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    int getValue() {
        return this.value;
    }

}


