import java.util.HashMap;

public class Main {
    private static HashMap<Character, Character> caesarMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
       putValuesToMap();
       String str = "malwares";
       String encryptedStr = encrypt(str);
       System.out.println(encryptedStr);


        
    }

    public static String encrypt(String origStr){
        if(origStr == "")
        return "";
        //Caesar Cypher uisng the map
        String caesarStr = "";
        for(int i = 0; i <origStr.length();i++){
            caesarStr+= caesarMap.get(Character.toLowerCase(origStr.charAt(i)));
        }
        //Convert to each character to binary.
        String binaryStr = "";
        for(int i = 0; i <caesarStr.length();i++){
           binaryStr += String.format("%8s", Integer.toBinaryString(Character.toLowerCase(caesarStr.charAt(i)))).replace(" ","0");
        }
        return binaryStr;
    }
    //Caesar Cyperh -3 shift
    public static void putValuesToMap(){
        caesarMap.put('a','x');
        caesarMap.put('b','y');
        caesarMap.put('c','z');
        caesarMap.put('d','a');
        caesarMap.put('e','b');
        caesarMap.put('f','c');
        caesarMap.put('g','d');
        caesarMap.put('h','e');
        caesarMap.put('i','f');
        caesarMap.put('j','g');
        caesarMap.put('k','h');
        caesarMap.put('l','i');
        caesarMap.put('m','j');
        caesarMap.put('n','k');
        caesarMap.put('o','l');
        caesarMap.put('p','m');
        caesarMap.put('q','n');
        caesarMap.put('r','o');
        caesarMap.put('s','p');
        caesarMap.put('t','q');
        caesarMap.put('u','r');
        caesarMap.put('v','s');
        caesarMap.put('w','t');
        caesarMap.put('x','u');
        caesarMap.put('y','v');
        caesarMap.put('z','w');
    }
}
