import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/*
Написать программу, определяющую правильность расстановки скобок в выражении.
Пример 1: a+(d*3) - истина
Пример 2: [a+(1*3) - ложь
Пример 3: [6+(3*3)] - истина
Пример 4: {a}[+]{(d*3)} - истина
Пример 5: <{a}+{(d*3)}> - истина
Пример 6: {a+]}{(d*3)} - ложь
 */
public class Task_3 {
    public static void main(String[] args) {
        String str = "{a+]}{(d*3)}";

        boolean res = check(str);
        System.out.println(res);

    }

    static boolean check(String str){
        Map <Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('<', '>');

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                stack.push(chars[i]);
            }
            if (map.containsValue(chars[i])) {
                if (stack.isEmpty() || chars[i] != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
