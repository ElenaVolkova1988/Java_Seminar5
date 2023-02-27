import java.util.HashMap;
import java.util.Map;

/*
Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
буква может не меняться, а остаться такой же. (Например, note - code)
Пример 1:
Input: s = "foo", t = "bar"
Output: false
Пример 2:
Input: s = "paper", t = "title"
Output: true
 */
public class Task_2 {
    public static void main(String[] args) {
        String word1 = "paper";
        String word2 = "title";

        boolean res = checkIso(word1, word2);
        System.out.println(res);
    }

    static boolean checkIso (String s1, String s2){
        if (s1.length() != s2.length()) return false;

        Map<Character, Character> chars = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            if (chars.containsKey(c1[i])){
                if (chars.get(c1[i]) != c2[i]) {
                    return false;
                }
            }else {
                chars.put(c1[i], c2[i]);
            }
        }return true;
    }
}