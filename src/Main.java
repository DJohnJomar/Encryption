import java.util.HashMap;
import java.util.Map;

public class Main {
    private static HashMap<Character, Character> caesarMap = new HashMap<>();
    //Main method to demonstrate the encryption and decryption
    public static void main(String[] args) throws Exception {
       putValuesToMap();
       String str = "Group 3 Malwares- Encryption Activity 1234567890 !@#$%^&*()_+";
       System.out.println("Value to encrypt: "+str);
       String encryptedStr = encrypt(str);
       System.out.println("\nEncrypted String: "+encryptedStr);
       String decryptedStr = decrypt(encryptedStr);
       System.out.println("\nDecrypted String: "+decryptedStr);
    }
    //Encryption Function
    //Encrypts a string using caesar cypher converted to binary string
    public static String encrypt(String origStr){
        if(origStr == "")
        return "";
        //Caesar Cypher using the set of key charaters in the hash map
        String caesarStr = "";
        for(int i = 0; i <origStr.length();i++){
            caesarStr+= caesarMap.get(origStr.charAt(i));
        }
        //Convert to each character to a binary number.
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
        //Converts bytes of binary numbers to a character.
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
        //Using the Values from the hash map, the key is found and added to the decrypted string.
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
    //Instantiates the values in the Hash Map to be used in the Caesar Cypher.
    //put values in the map with caesar cypher, only supports ASCII characters from SPACE to ~ characters (Decimal values 32 - 126).
    public static void putValuesToMap(){
        final int caesarShift = 10; //The number of shift in the caesar cypher
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
