public class Encoder {
    public String toASCII(String s){
        StringBuffer asciis = new StringBuffer();
        for (char c:
             s.toCharArray()) {
            asciis.append(Integer.toBinaryString(c));
        }
       // System.out.println(asciis);
        return asciis.toString();
    }
    public static void main(String[] args){
        Encoder e = new Encoder();
        e.toASCII("SOS Distress Signal");
    }
}
