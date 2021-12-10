package clock;

public class Display {

        private int value = 0;
        private int limit = 0;
        private static int step = 1;
        public Display(int limit){
            this.limit = limit;
        }

        public void restart(){
            value = 0;
        }
        public void increase(){
            value++;
            if(value == limit) {
                value = 0;
            }
        }

        public int getValue(){
            return value;
        }
//        static函数是类函数，这说明它只属于这个类，不属于任何其他对象
//        static函数只能互相调用
        public static void main(String [] args){
            Display d1 = new Display(10);
            Display d2 = new Display(20);
            d1.increase();
            System.out.println(d1.getValue());
            System.out.println(d2.getValue());
            System.out.println(d1.step);
            System.out.println(d2.step);
            d1.step = 2;
            /*step是static成员变量（类变量）
            它不属于任何对象，它属于这个类，可以Display.step
            但通过一个对象修改类变量后所有对象的类变量都改变了*/
            System.out.println(d1.step);
            System.out.println(d2.step);
            Display.step = 3;
            System.out.println(d1.step);
            System.out.println(d2.step);

        }
    }




