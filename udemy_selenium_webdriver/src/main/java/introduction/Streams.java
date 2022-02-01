package introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args){
//        regularWay();
//        streamFilter();
//        streamFilter2();
//        printNames();
//        streamMap();
          streamSort();
    }

    public static void regularWay(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahbeeb");
        names.add("Antar");
        names.add("bantar");
        names.add("nantar");
        names.add("Anntar");
        int count = 0;

        for (int i = 0; i< names.size();i++){
            String name = names.get(i);
            if (name.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahbeeb");
        names.add("Antar");
        names.add("bantar");
        names.add("nantar");
        names.add("Anntar");

        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);
    }

    public static void streamFilter2(){
        long newStream = Stream.of("Anti","Ahg","bye","teh","Anu").filter(d -> {
            d.startsWith("A");
            return true;
        }).count();
        System.out.println(newStream);// output not correct
    }
    // function to print names greater than 4
    public static void printNames(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahbeeb");
        names.add("Antar");
        names.add("bantar");
        names.add("nantar");
        names.add("Anntar");
        names.stream().filter(s -> s.length()> 4).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

    }
    // using the mapper when you need to modify your result
    public static void streamMap(){
        Stream.of("Antia","Ahga","bye","teh","Ana").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }
    //using Sort on streams
@Test
    public static void streamSort(){
        List<String> names = Arrays.asList("Akanke","Don","Anita","Adam", "Rema");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }
    // merging two different list with streams
    @Test
    public static void streamMerge(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ahbeeb");
        names.add("Antar");
        names.add("don");
        names.add("bolaji");
        List<String> names1 = Arrays.asList("Akanke","Don","Anita","Adam", "Rema");

        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));
        Boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);
    }

    @Test
    public static void streamCollect(){
        List<String> ls =  Stream.of("Antia","Ahga","bye","teh","Ana").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

    }
    // assignment
    @Test
    public static void streamCollection(){
        List<Integer> values = Arrays.asList(3,4,5,3,2,1,5,6,8,1,2);
        //print unique number
        // sort the array -3rd index
//        values.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }


}
