package com.lix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //createStreamFromCollection().forEach(System.out::println);
        //createStreamFromValues().forEach(System.out::println);
        //createStreamFromArrays().forEach(System.out::println);
        //createStreamFromFile();
        //createStreamFromIterator().forEach(System.out::println);
        //createStreamFromGenerate().forEach(System.out::println);
        createObjStreamFromGenerate().forEach(System.out::println);
    }

    private static Stream<String> createStreamFromCollection() {
        List<String> strings = Arrays.asList("hello", "lol", "love", "kof");
        return strings.stream();
    }

    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "lol", "love", "kof");
    }

    private static Stream<String> createStreamFromArrays() {
        String[] strings = {"hello", "lol", "love", "kof"};
        return Arrays.stream(strings);
    }

    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("D:\\git-source\\javaworld\\all-customize\\src\\main\\java\\com\\lix\\Customize2.java");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Stream<Integer> createStreamFromIterator() {
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2).limit(10);
        return iterate;
    }

    private static Stream<Double> createStreamFromGenerate() {
        Stream<Double> iterate = Stream.generate(Math::random).limit(10);
        return iterate;
    }

    private static Stream<Obj> createObjStreamFromGenerate(){
        return Stream.generate(new ObjSupplier()).limit(10);
    }
    //自定义
    static class ObjSupplier implements Supplier<Obj> {
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());
        @Override
        public Obj get() {
            index = random.nextInt(10);
            return new Obj(index,"name->"+index);
        }
    }

    static class Obj {
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
