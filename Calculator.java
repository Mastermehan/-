import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Calculator {
    // ссылка на вызов конструктора класса Calculator() { }
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> {
        return x * y;
    };

    // BinaryOperator<Integer> devide = Calculator::apply;
    BinaryOperator<Integer> devide = (x, y)-> y == 0 ? Integer.MAX_VALUE : x / y;



    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    // эта строчка передает вывод в 32 и 33. без нее программа компилирует только через sout
    Consumer<Integer> println = System.out::println;

//    Проход делеения нуля через ArithmeticException в другом классе
//    private static Integer apply(Integer x, Integer y) {
//        if (y == 0) {
//            try {
//                throw new ArithmeticException();
//            } catch (ArithmeticException e) {
//                System.out.println("делим на ноль");
//            }
//            return y;
//        }
//        return x / y;
//    }


    public static void main(String[] args) {
        //экземпляр класса Calculator через вызов статической переменной instance
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);

        int d = calc.multiply.apply(2, 4);
        int e = calc.pow.apply(3);
        int f = calc.abs.apply(4);
        boolean g = calc.isPositive.test(3);

        calc.println.accept(c);
        calc.println.accept(d);
        calc.println.accept(e);
        calc.println.accept(f);
        System.out.println(g);

    }
}










