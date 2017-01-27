package com.b2w.challenge;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Leonardo on 26/01/2017.
 */
public class Application {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<int[]> triangle = Pattern.compile("\\[\\[|[^\\d],[^\\d]|\\]\\]|[\\s]").splitAsStream(in.nextLine()).filter(s -> !s.isEmpty()).
                map(a -> Pattern.compile("\\D").splitAsStream(a).mapToInt(Integer::new).toArray()).collect(Collectors.toList());

        HellTriangle hellTriangle = new HellTriangle(triangle);
        Integer maximumTotal = hellTriangle.getMaximumTotal();

        System.out.println(maximumTotal);
    }

}
