import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 24.06.2017.
 */
public class Sorts {

    /**Quicksort sample*/
    public static List<Integer> quicksort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        }
        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<Integer>();
        final List<Integer> higher = new ArrayList<Integer>();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            } else {
                higher.add(numbers.get(i));
            }
        }
        final List<Integer> sorted = quicksort(lower);
        sorted.add(pivot);
        sorted.addAll(quicksort(higher));
        return sorted;
    }

    /**Mergesort sample*/
    public static List<Integer> mergesort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }
        final List<Integer> leftHalf =
                values.subList(0, values.size() / 2);
        final List<Integer> rightHalf =
                values.subList(values.size() / 2, values.size());
        return merge(mergesort(leftHalf), mergesort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left,
                                       final List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;
        final List<Integer> merged = new ArrayList<Integer>(left.size() + right.size());
        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }
        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }
        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }
        return merged;
    }



}
