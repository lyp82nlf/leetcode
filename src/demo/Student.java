package demo;

public class Student extends Person {

    private int tmp2 = 1;

    @Override
    public void show() {
        super.show();
    }

    public static void main(String[] args) {
        Person person = new Student();
    }
}

