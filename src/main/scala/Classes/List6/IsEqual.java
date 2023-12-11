package Classes.List6;

public class IsEqual {

    static boolean isEqual(int x, int y) {
        return x == y;
    }

    static boolean isEqual(Integer x, Integer y) {
        return x == y;
    }

    public static void main(String[] args) {
        System.out.println(isEqual(421, 421));
        System.out.println(isEqual(421, 421));
        String s1 = "foo";
        String s2 = "foo";
        String s3 = new String("foo");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }
}


