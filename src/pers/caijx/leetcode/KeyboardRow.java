package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

 Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 Note:
 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.
 * Created by Administrator on 2018/6/20/020.
 */
public class KeyboardRow {

    static char[] charToRow;

    static {
        charToRow= new char[126];
        charToRow[(int)'q']=0;
        charToRow[(int)'w']=0;
        charToRow[(int)'e']=0;
        charToRow[(int)'r']=0;
        charToRow[(int)'t']=0;
        charToRow[(int)'y']=0;
        charToRow[(int)'u']=0;
        charToRow[(int)'i']=0;
        charToRow[(int)'o']=0;
        charToRow[(int)'p']=0;
        charToRow[(int)'a']=1;
        charToRow[(int)'s']=1;
        charToRow[(int)'d']=1;
        charToRow[(int)'f']=1;
        charToRow[(int)'g']=1;
        charToRow[(int)'h']=1;
        charToRow[(int)'j']=1;
        charToRow[(int)'k']=1;
        charToRow[(int)'l']=1;
        charToRow[(int)'z']=2;
        charToRow[(int)'x']=2;
        charToRow[(int)'c']=2;
        charToRow[(int)'v']=2;
        charToRow[(int)'b']=2;
        charToRow[(int)'n']=2;
        charToRow[(int)'m']=2;
    }

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int row = 0;
            if (word.length() > 0) {
                row = charToRow[(int)Character.toLowerCase(word.charAt(0))];
                boolean isSameRow = true;
                for (int j = 1; j < word.length(); ++j) {
                    if (charToRow[(int)Character.toLowerCase(word.charAt(j))] != row) {
                        isSameRow = false;
                        break;
                    }
                }
                if (isSameRow) {
                    res.add(word);
                }
            } else {
                res.add(word);
            }
        }
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }
}
