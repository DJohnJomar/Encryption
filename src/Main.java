import java.util.HashMap;
import java.util.Map;

public class Main {
    private static HashMap<Character, Character> caesarMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
       putValuesToMap();
       String str = "Bwakanang Shiet";
       System.out.println("Value to encrypt: "+str);
       String encryptedStr = encrypt(str);
       System.out.println("Encrypted String: "+encryptedStr);
       String decryptedStr = decrypt(encryptedStr);
       System.out.println("Decrypted String: "+decryptedStr);


        
    }

    //Encrypts a string using -3 shift caesar cypher converted to binary string
    public static String encrypt(String origStr){
        if(origStr == "")
        return "";
        //Caesar Cypher uisng the map
        String caesarStr = "";
        for(int i = 0; i <origStr.length();i++){
            caesarStr+= caesarMap.get(origStr.charAt(i));
        }
        //Convert to each character to binary.
        String binaryStr = "";
        for(int i = 0; i <caesarStr.length();i++){
           binaryStr += String.format("%8s", Integer.toBinaryString(caesarStr.charAt(i))).replace(" ","0");
        }
        return binaryStr;
    }

    //Decryption function
    public static String decrypt(String origStr){
        String binaryCharacter = "";
        String decryptedStr= "";
        String strContainer= "";
        int binaryIntValue= 0 ;
        int ctr = 1;
        //Part for converting binary to a character
        for(int i = 0 ; i<origStr.length();i++){
            binaryCharacter+=origStr.charAt(i);
            if(ctr==8){
                binaryIntValue = Integer.parseInt(binaryCharacter,2);
                strContainer+=(char) binaryIntValue;
                binaryCharacter = "";
                ctr=1;
                continue;
            }
            ctr++;
        }
        //Caesar cypher decryption
         for(int i = 0 ; i<strContainer.length();i++){
            char currentChar = strContainer.charAt(i);
            for(Map.Entry<Character, Character> entry : caesarMap.entrySet()){
                if(entry.getValue() == currentChar){
                    decryptedStr+=entry.getKey();
                }
            }
         }
        return decryptedStr;
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
        
        caesarMap.put('A','X');
        caesarMap.put('B','Y');
        caesarMap.put('C','Z');
        caesarMap.put('D','A');
        caesarMap.put('E','B');
        caesarMap.put('F','C');
        caesarMap.put('G','D');
        caesarMap.put('H','E');
        caesarMap.put('I','F');
        caesarMap.put('J','G');
        caesarMap.put('K','H');
        caesarMap.put('L','I');
        caesarMap.put('M','J');
        caesarMap.put('N','K');
        caesarMap.put('O','L');
        caesarMap.put('P','M');
        caesarMap.put('Q','N');
        caesarMap.put('R','O');
        caesarMap.put('S','P');
        caesarMap.put('T','Q');
        caesarMap.put('U','R');
        caesarMap.put('V','S');
        caesarMap.put('W','T');
        caesarMap.put('X','U');
        caesarMap.put('Y','V');
        caesarMap.put('Z','W');
        
        caesarMap.put(' ', ' ');
    }
}
