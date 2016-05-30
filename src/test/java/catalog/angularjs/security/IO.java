package catalog.angularjs.security;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by evgen on 07.04.16.
 */
public class IO {

    private static final Charset CHARSET = Charset.forName("ISO-8859-1");

    @org.junit.Test
    public void getQuantity() throws Exception {
        Path pathOriginal = Paths.get("/home/evgen/Desktop/original");
        Path pathRedesigned = Paths.get("/home/evgen/Desktop/redes");
        Set<String> setOriginal = lines(pathOriginal);
        Set<String> setRedesigned = lines(pathRedesigned);
        System.out.println("##################################################");
        setRedesigned.removeAll(setOriginal);
        System.out.println(setRedesigned.size());
    }

    private Set<String> lines(Path path) throws Exception {
        List<String> lines = Files.readAllLines(path, CHARSET);
        List<String> collect = lines.stream().map(x -> x.split(":")[0]).collect(Collectors.toList());
        System.out.println("Size: " + collect.size() + " with path: " + path);
        return new HashSet<>(collect);
    }

    @org.junit.Test
    public void test() throws Exception {
        Path pathOriginal = Paths.get("/home/evgen/Desktop/original");
        Path pathRedesigned = Paths.get("/home/evgen/Desktop/redes");
        List<String> original = list(pathOriginal);
        List<String> redesigned = list(pathRedesigned);
        Map<String, String> mapOrig = lToMap(original);
        Map<String, String> mapRed = lToMap(redesigned);
        mapOrig.forEach((k, v) -> {
            if(!mapRed.containsKey(k)) {
                throw new RuntimeException(k);
            }
            //System.out.println("Key: " + k + ", original value: <<" + v + ">>, redesigned value: <<" + mapRed.get(k) + ">>");
            if(!mapRed.get(k).equals(v)) {
                System.out.println("Different values with key=" + k + ". Expected: " + v + ", actual: " + mapRed.get(k));
            }
        });
    }

    private List<String> list(Path path) throws Exception {
        return Files.readAllLines(path, CHARSET);
    }

    private Map<String, String> listToMap(List<? extends String> list) {
        Function<String[], String> valueMapper = s -> {
            if(s.length != 2) {
                return "";
            }
            return s[1];
        };
        return list.stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(s -> s[0], valueMapper));
    }

    private Map<String, String> lToMap(List<? extends String> list) {
        Map<String, String> map = new HashMap<>();
        for(String s:list) {
            String[] ar = s.split(":");
            //System.out.println(Arrays.toString(ar));
            if(ar.length == 3) {
                check(map, ar[0] + ar[1]);
                map.put(ar[0] + ar[1],ar[2]);
            }
            else if(ar.length != 2) {
                check(map, ar[0]);
                map.put(ar[0],"");
            } else {
                check(map, ar[0]);
                map.put(ar[0], ar[1]);
            }
        }
        if(map.size() != list.size())
            throw new RuntimeException("Not unique elements");
        return map;
    }

    private void check(Map<String, String> map, String key) {
        if(map.containsKey(key))
            throw new RuntimeException(key);
    }
}
