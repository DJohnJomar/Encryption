import java.util.HashMap;
import java.util.Map;

public class Main {
    private static HashMap<Character, Character> caesarMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
       putValuesToMap();
       String str = "Group 3 Malwares XDX 6969 !@#$%";
       System.out.println("Value to encrypt: "+str);
       String encryptedStr = encrypt(str);
       System.out.println("Encrypted String: "+encryptedStr);
       String decryptedStr = decrypt(encryptedStr);
       System.out.println("Decrypted String: "+decryptedStr);
    //    for(Map.Entry<Character, Character> entry : caesarMap.entrySet()){
    //     System.out.println("getKey: "+entry.getKey()+" getValue: "+entry.getValue());
    //    }
       
    }
    //Encrypts a string using caesar cypher converted to binary string
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
        System.out.println("Decrypted String Characters: "+strContainer);
        //Caesar cypher decryption
         for(int i = 0 ; i<strContainer.length();i++){
            char currentChar = strContainer.charAt(i);
            for(Map.Entry<Character, Character> entry : caesarMap.entrySet()){
                if(entry.getValue() == currentChar){
                    //System.out.println("getValue: "+entry.getValue()+" currentChar: "+currentChar);
                    decryptedStr+=entry.getKey();
                    //System.out.println("getKey: "+entry.getKey());
                }
            }
         }
         
        return decryptedStr;
    }
    //put values in the map with caesar cypher, only supports ASCII values (128 ASCII characters).
    public static void putValuesToMap(){
        final int caesarShift = 10; //Other Values tend to break the cyphering, value = 10 works most of the time.
        int keyCtr;
        int valuesCtr;

        for (keyCtr = 32; keyCtr <=126; keyCtr++){
           valuesCtr = keyCtr+caesarShift;
           if(valuesCtr>126){
            valuesCtr = keyCtr+valuesCtr-95;
           }
           if(valuesCtr<32){
            valuesCtr = keyCtr+valuesCtr+95;
           }
           caesarMap.put((char)keyCtr, (char)valuesCtr);
        }
    }
}
