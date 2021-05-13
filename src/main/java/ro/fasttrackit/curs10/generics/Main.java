package ro.fasttrackit.curs10.generics;

import ro.fasttrackit.curs10.mongo.model.entity.RoomEntity;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> stringBox = new Pair<>("string", 1);
        Pair<String, RoomEntity> altBox = new Pair<>("string", new RoomEntity("abc"));
        Pair<Integer, File> intBox = new Pair<>(1, new File("hello"));

        processBox(stringBox);
        Integer value = getValue(stringBox);
        RoomEntity room = getValue(altBox);
        System.out.println(altBox.transform(Pair::getValue));
        System.out.println(Pair.sum(2,3.0));
    }

    private static <V> V getValue(Pair<String, V> pair) {
        return pair.getValue();
    }

    private static void processBox(Pair<String, Integer> intBox) {
        Integer value = intBox.getValue();

    }
}
