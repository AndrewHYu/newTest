package java8.Java8InAction.chap7;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Andrew
 * @date 2017/12/23
 */
public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10){
             return null;
        }
        for (int spiltPos = currentSize/2 + currentChar; spiltPos < string.length(); spiltPos++){
            if (Character.isWhitespace(string.charAt(spiltPos))){
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar,spiltPos));
                currentChar = spiltPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}
