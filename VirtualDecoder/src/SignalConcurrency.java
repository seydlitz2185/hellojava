
import java.lang.Thread.State;
/**
 * @author stevenyu
 */
public class SignalConcurrency {
    public static void main(String[] args) {
        Thread m1 = new MorseLauncher("m1", "Hahaha");
        Thread m2 = new MorseLauncher("m2", "ahahaH");
        Thread d1 = new MorseDecoder("d1",(MorseLauncher) m1);
        m1.start();
        d1.start();
        //m2.start();
        /*
        while (true){
            if (m1.isAlive()){
                System.out.println(m1.getName()+"(线程)正在运行～～～");
            }
            if (m1.getState()==State.TIMED_WAITING){
                System.out.println(m1.getName()+"(线程)正在等待～～～");
            }
            if (m2.isAlive()){
                System.out.println(m2.getName()+"(线程)正在运行～～～");
            }
            if (m2.getState()==State.TIMED_WAITING){
                System.out.println(m2.getName()+"(线程)正在等待～～～");
            }
        }
        */

    }
}
