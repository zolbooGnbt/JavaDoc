package mlc.methods.lab;

public class StaticMethodTestClass{

    public int addPublic(int number1, int number2 ) {
        return addPrivate(number1, number2);
    }

    private int addPrivate(int num1, int num2) {
        return num1 + num2;
    }

    static int addDefault(int num1, int num2) {
        return num1 + num2;
    }

}
