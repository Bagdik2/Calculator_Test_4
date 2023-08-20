import java.util.Objects;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        /* Создаём сканнер для считывания выражения для калькулятора из */
        Scanner inputer = new Scanner(System.in);

        String text = inputer.nextLine();
        inputer.close();
        /* Пытаемся воспользоваться методом "calc" и вывести в консоли ответ введённого математического выражения */
        try {
            System.out.println(calc(text));
        } catch (Exception e) {
            /* Если с выражением что-то не так или произошла ошибка на одном из этапов выкидываем исключение */
            throw new RuntimeException(e);
        }
    }
    /* Метод "calc" из задания в классе "Main" в котором происходят все операции с введёнными через консоль данными */
    public static String calc(String input) throws Exception{
        String[] words;
        try{
            /* Разделяем введённое выражение на слова при помощи пробелов между ними: */
            words = input.split(" ");
        }catch (Exception e){
            throw new Exception("Wrong Expression.");
        }

        /* Если в выражении более 3-х слов выкидываем исключение в котором сказано "недостаточно или слишком много пременных" */
        if(words.length != 3) throw new Exception("Not enough or too many variables.");
        /* Переводим значения из слов в выражении в переменные для последущего проведения математических операций */
        int a = Integer.parseInt(words[0]);
        String c = words[1];
        int b = Integer.parseInt(words[2]);
        /* По условию задачи выкидываем исключение если вводимые числа выражения больше 10 */
        if(0 > a || a > 10 || 0 > b || b > 10) throw new Exception("Unacceptable numbers.");

        if(!Objects.equals(c, "+") && !Objects.equals(c, "-") &&
                !Objects.equals(c, "*") && !Objects.equals(c, "/")) throw new Exception("Unacceptable math operation.");
        String output = "";
        /* Используем операцию выбора switch-case для выбора математической операции из выражения */
        switch (c) {
            case "+" -> output = Integer.toString(a + b);
            case "-" -> output = Integer.toString(a - b);
            case "*" -> output = Integer.toString(a * b);
            case "/" -> output = Integer.toString(a / b);
            /* Если каким-либо образом знак математического выражения был неправильным выкидываем исключение */
            default -> throw new IllegalStateException("Wrong math operation: " + c);
        }

        return output;
    }
}