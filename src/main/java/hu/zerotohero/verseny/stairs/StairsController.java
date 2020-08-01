package hu.zerotohero.verseny.stairs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

@RestController
public class StairsController {


    @GetMapping("/number-of-steps/getNumberOfSteps")
    public String getNumberOfSteps(@RequestParam(value = "numberOfStair") Integer numberOfStair,
                                   @RequestParam(value = "stepSizeList", defaultValue = "1") List<Integer> stepSizeList) {
        if (numberOfStair < 1) {
            return "At least 1 stair need";
        }
        Set<Integer> stepSizeSet = new HashSet<>(stepSizeList);
        Integer[] array = Arrays.copyOf(stepSizeSet.toArray(), stepSizeSet.size(), Integer[].class);
        int[] primitiveArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        System.out.println(numberOfStair + " " +  Arrays.toString(primitiveArray) + " " + primitiveArray.length);
        return countWays(numberOfStair, primitiveArray, primitiveArray.length) + " way is possible";
    }


    private int countWays(int n, int[] arr, int len) {
        int noWays = 0;
        for (int i = 0; i < len; i++) {
            if (n - arr[i] >= 0) {
                noWays += countWays(n - arr[i], arr, len);
                System.out.println(noWays);
            }
        }
        return noWays;
    }
}
