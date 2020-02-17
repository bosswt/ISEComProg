public class Part_A {
    public static void main(String[] args) {
        Java101 j = new Java101();
        System.out.println(j.typeOf("3" + 2 + 1));
        System.out.println("3" + 2 + 1);
        System.out.println(j.typeOf(5 + "6" + 7));
        System.out.println(5 + "6" + 7);
        System.out.println(j.typeOf(4 / 6 * 3));
        System.out.println(4 / 6 * 3);
        System.out.println(j.typeOf(3.0 / 4 * 4));
        System.out.println(3.0 / 4 * 4);
        System.out.println(j.typeOf((short) 1.5));
        System.out.println((short) 1.5);
        System.out.println(j.typeOf((3 + 2.0F + 4.0)));
        System.out.println(3 + 2.0F + 4.0);
        System.out.println(j.typeOf((int) (5 - 6.5) == 1 - 2));
        System.out.println((int) (5 - 6.5));
    }
}