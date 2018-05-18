package pers.caijx.leetcode;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/5/18/018.
 */
public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        StringBuilder strValue = new StringBuilder();
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            char[] wordsArray = words[i].toCharArray();
            for (int j = 0; j < wordsArray.length; j++) {
                strValue.append(morse[(int)wordsArray[j] - 97]);
            }
            hs.add(strValue.toString());
            strValue = new StringBuilder();
        }

//        Iterator<String> iterator = hs.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println(s);
//        }
        return hs.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords instance = new UniqueMorseCodeWords();
        System.out.println(instance.uniqueMorseRepresentations(new String[]{"rwjje","aittjje","auyyn","lqtktn","lmjwn"}));
    }
}
