public class MorseDecoder extends Thread implements VirtualDecoder {
    private StringBuffer outString;
    private MorseLauncher targetThread;
    public MorseDecoder(String name,MorseLauncher target){
        this.setName(name);
        this.targetThread = target;
        outString = new StringBuffer();
    }
    @Override
    public int DigitalRead() {
        return targetThread.level;
    }
    @Override
    public void run(){
        while (true){
            outString.append(DigitalRead());
            System.out.println(this.getName()+":"+outString.toString());
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
