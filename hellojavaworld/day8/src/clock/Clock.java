package clock;
import clock.Display;
public class Clock {
    private Display hour = new Display(24);
    private Display minute = new Display(60);
    private Display second = new Display(60);

    public void start(){
        while (true) {
            second.increase();
            if (second.getValue() == 0) {
                minute.increase();
                if (minute.getValue() == 0) {
                    hour.increase();
                }
            }
            System.out.printf("%02d:%02d:%02d\n",
                    hour.getValue(), minute.getValue(), second.getValue());
        }
    }
    public static void main(String[] args){
        Clock clock = new Clock();
        clock.hour.restart();
        clock.minute.restart();
        clock.second.restart();
        clock.start();
    }
}
