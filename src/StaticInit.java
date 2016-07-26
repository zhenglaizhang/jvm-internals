public class StaticInit {

    static class Parent {
        public static int A = 1;

        static {
            A = 3;
        }
    }

    static class Child extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Child.A);
    }
}
