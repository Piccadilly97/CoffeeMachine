package CoffeeMachine.Display;

public final class DisplayConclusion {
    public static final void helloMenu() {
        final String HELLO = """
                -------------------------------------------------------
                Здравствуйте, это кофемашина построенная на языке Java
                -------------------------------------------------------
                """;
        System.out.println(HELLO);
    }

   public static final String EMPTY_STORAGE = "К сожалению склад нашей кофемашины пуст, поэтому сделать заказ не получиться\nЕсли вы являетесь админом, то введите пароль";

    public static final String REPEAT_PASSWORD = "Введите пароль снова";
    public static final String INVALID_PASSWORD = "Кажется пароль не верный";

    public static final String WARNING = "Осторожно, горячо";

    public static final String TRY_AGAIN = "Попробуйте выбрать ваш кофе сначала";

    public static final String NUM_LESS_ZERO = "Кажется вы ввели значение меньше или равно нулю, мы не сможем приготовить столько кофе((";

    public static final String NUM_OR_PASS = "Введите любую цифру для заказа кофе или введите администраторский пароль";

}

