import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ConcurrentModificationException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    static Stream<Arguments> streamProvider(){
        return Stream.of(
                Arguments.of(new int[] {1, 5, 3}, new int[] {1, 3, 5}),
                Arguments.of(new int[] {-3, -1, -2, 5}, new int[] {-3, -2, -1, 5}),
                Arguments.of(new int[] {3, -2, -5, -1, 2}, new int[] {-5, -2, -1, 2, 3}),
                Arguments.of(new int[] {-3, 1, 11, 0, 9, 3}, new int[] {-3, 0, 1, 3, 9, 11}),
                Arguments.of(new int[] {3, 7, 2, -1, -2}, new int[] {-2, -1, 2, 3, 7})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0}, {1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0; // for cnt index
        Integer s; // for PriorityQueue.poll()
        int[] result = new int[random_array.length];

        // TODO: random_array add to PriorityQueue
        for (Integer i : random_array){
            test.add(i);
        }

        // TODO: get PriorityQueue result
        for (index = 0; index < random_array.length; index++){
            s = test.poll();
            result[index] = s;
        }

        assertArrayEquals(correct_array, result);
    }


    @Test
    public void Exception_Test1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void Exception_Test2() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().offer(null);
        });
    }

    @Test
    public void Exception_Test3(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });
    }
}