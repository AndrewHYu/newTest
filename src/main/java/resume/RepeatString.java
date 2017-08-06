package resume;

import java.util.*;

/**
 * Created by Andrew  on 2017/7/17.
 */
public class RepeatString {
    static class SubString implements Comparable<SubString>{

        private String s;
        private int count = 1 ;

        public SubString(String s) {
            this.s = s;
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof SubString))
                return false;
            SubString s = (SubString)obj;
            return this.s.equals(s.getS());
        }

        @Override
        public int compareTo(SubString o) {
            int result = this.s.compareTo(o.getS());
            if (result == 0 && this != o)
                o.setCount(o.getCount() + 1);
            return result;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String s = "abcabcabab";
        char sArray[] = s.toCharArray();
        int num = sArray.length;
        List<Set<SubString>> subList = new ArrayList<>();
        for (int i = 1 ; i < num ; i++ ){
            Set<SubString> sSet = new TreeSet<>();
            for (int j = 0 ; j < num-i ; j++){
                sSet.add(new SubString(s.substring(j,j+i+1)));
            }
            subList.add(sSet);
        }

        for (Set<SubString> ss:
             subList) {
            for (Iterator<SubString> iterator = ss.iterator();iterator.hasNext();){
                SubString ss1 = iterator.next();
                if (ss1.getCount()<=1){
                    iterator.remove();
                }
            }
        }

    }
}
