package 散列表;
import java.util.HashMap;
import java.util.Scanner;

public class Coin {
    private HashMap<Integer,String> coinNames
            = new HashMap<Integer,String>();
    public Coin(){
        coinNames.put(1,"penny");
        coinNames.put(10,"dime");
        coinNames.put(25,"quarter");
        coinNames.put(50,"half-dollar");
        coinNames.put(50,"五毛");
//        Hash表每一个键都是唯一的，即只有一对一的关系，重复赋值会覆盖之前的
        System.out.println(coinNames.keySet().size());
//        keySet将HashMap对象转化为集合容器Hashset对象，
//        对HashSet对象再使用size方法求出大小
        System.out.println(coinNames);
    }
    public void showHashMap(){
        for (Integer k : coinNames.keySet()){
            String s = coinNames.get(k);
            System.out.println(s);
        }
    }
    public String getName(int amount){
        return coinNames.get(amount);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Coin coin = new Coin();
        System.out.println(coin.getName(in.nextInt()));
        coin.showHashMap();
    }
}
