/**
 * @author stevenyu
 */
public class MorseLauncher extends Thread implements VirtualLauncher {
    private String morseCode;
    private StringBuffer outString;
    private Encoder e = new Encoder();
    public int level;
    public MorseLauncher(){
        this.setName("m1");
        this.morseCode = e.toASCII("SOS Distress Signal");
        outString = new StringBuffer();
    }
    public MorseLauncher(String name,String s){
        this.setName(name);
        this.morseCode = e.toASCII(s);
        outString = new StringBuffer();
    }
    @Override
    public void output(int i) {
        outString.append(morseCode.charAt(i));
        this.level = Integer.parseInt(String.valueOf(morseCode.charAt(i)));
        System.out.println(this.getName()+":"+outString.toString());

    }
    @Override
    public void run(){
        for (int i = 0;i < morseCode.length();i++){
            this.output(i);
            try {
                Thread.sleep(75);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
      }
    }
}
