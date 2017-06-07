package test;

/**
 * Created by Andrew  on 2016/10/21.
 */
public class tesrExtend {
    int i=0;
    public static void main(String[] args) {
        new Circle();

    }

}
    class Draw {
        int i=0;
        public Draw(String type) {
            System.out.println(type+" draw constructor");
        }
        {
            this.i=3;
        }
    }

    class Shape {
        private Draw draw = new Draw("shape");

        public Shape(){
            System.out.println("shape constructor");
        }
    }

    class Circle extends Shape {
        private Draw draw = new Draw("circle");
        public Circle() {
            System.out.println("circle constructor");
        }
    }

