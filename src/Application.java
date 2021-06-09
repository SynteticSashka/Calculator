public class Application {

    /*
    Добрый день! Проанилизировав задачу, я пришёл к выводу что
    добавление большого числа классов хоть и соотвествует
    принципам ООП, но при этом бессмысленно усложняет конкретно
    это решение.

    В связи с этим я вынес все сервисные методы в отдельный класс,
    а в основном оставил саму логику решения.

    В качестве альтернативы можно было бы создать отдельные классы
    под считываемые с консоли числа, дать им свои поля (в арабских и римских числах) и т.д.,
    но это имело бы смысл если бы мы дальше расширяли функционал этого калькулятора.
     */

    public static String[] expression = new String[3];
    public static int[] arabicNumbers = Service.loadIntArray();
    public static String[] latinianNumbers = Service.loadStringArray();

    public static void main(String[] args) throws Exception{

        expression = Service.readFromConsole(expression);
        Service.check(expression);
        System.out.println(Service.convert(expression));
    }
}

