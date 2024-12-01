package day1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/day1/inputs.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        Map<Integer, Integer> numOfAppearance = new HashMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);

            if (numOfAppearance.get(r) == null) {
                numOfAppearance.put(r, 1);
            } else {
                int appearance = numOfAppearance.get(r);
                numOfAppearance.put(r, appearance + 1);
            }
            leftList.add(l);
            rightList.add(r);
        }
        Collections.sort(leftList);
        Collections.sort(rightList);

        int total = 0;
        for (int i = 0; i < leftList.size(); i++) {
            Integer integer = numOfAppearance.get(leftList.get(i));
            if (integer == null)
                continue;
            total += integer * leftList.get(i);
        }

        System.out.println(total);
    }
}