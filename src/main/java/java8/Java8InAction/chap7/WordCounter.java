package java8.Java8InAction.chap7;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Andrew
 * @date 2017/12/23
 */
public class WordCounter {
    public static final String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita " +
                    "mi  ritrovai in una  selva oscura" +
                    " che la  dritta via era   smarrita ";

    public static void main(String[] args) {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");

        Stream<Character> stream2 = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream2.parallel()) + " words");

        //使用自定义的Spliterator
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream3 = StreamSupport.stream(spliterator,true);
        System.out.println("Parallel found " + countWords(stream3) + " words");

        //充分测试，在使用stream时转换为显示使用并行
        Spliterator<Character> spliterator2 = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream4 = StreamSupport.stream(spliterator2,true);
        System.out.println("Parallel found " + countWords(stream4.parallel()) + " words");
    }
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }
    public WordCounter accumulate(Character c){
        if (Character.isWhitespace(c)){
            return lastSpace ? this : new WordCounter(counter, true);
        }else {
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter(){
        return counter;
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }
}
