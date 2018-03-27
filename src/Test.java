public class Test {
    public static void main(String[] args) {
        // 1. Declare all the builders.
        A.ABuilder builderA1 = A.builder();
        A.ABuilder builderA2 = A.builder();
        B.BBuilder builderB1 = B.builder();
        B.BBuilder builderB2 = B.builder();
        C.CBuilder builderC = C.builder();

        // 2. Populate all the builders.
        builderA1.b(builderB1).suppliedC(builderC);
        builderA2.b(builderB2).suppliedC(builderC);
        builderB1.a(builderA2).c(builderC).d("Cupcake");
        builderB2.a(builderA1).c(builderC).d("Brownie");
        builderC.a(builderA1).a(builderA2).b1(builderB1).b2(builderB2);

        // 3. Produce the objects.
        A a1 = builderA1.getOrBuild();
        A a2 = builderA2.getOrBuild();
        B b1 = builderB1.getOrBuild();
        B b2 = builderB2.getOrBuild();
        C c = builderC.getOrBuild();

        // 4. Assert that the objects are what we wanted.
        if (a1.getB() != b1) throw new AssertionError();
        if (a2.getB() != b2) throw new AssertionError();
        if (b1.getA() != a2) throw new AssertionError();
        if (b2.getA() != a1) throw new AssertionError();
        if (a1.getC() != c) throw new AssertionError();
        if (a2.getC() != c) throw new AssertionError();
        if (b1.getC() != c) throw new AssertionError();
        if (b2.getC() != c) throw new AssertionError();
        if (!"Cupcake".equals(b1.getD())) throw new AssertionError();
        if (!"Brownie".equals(b2.getD())) throw new AssertionError();
        if (c.getB1() != b1) throw new AssertionError();
        if (c.getB2() != b2) throw new AssertionError();
        if (c.getAs().size() != 2) throw new AssertionError();
        if (c.getAs().get(0) != a1) throw new AssertionError();
        if (c.getAs().get(1) != a2) throw new AssertionError();
        try {
            c.getAs().add(a1);
            throw new AssertionError();
        } catch (UnsupportedOperationException expected) {
            // Swallow it.
        }
        try {
            c.getAs().remove(a1);
            throw new AssertionError();
        } catch (UnsupportedOperationException expected) {
            // Swallow it.
        }

        // 4. Assert that the builders have expected side-effects if reused.
        B b3 = builderB1.getOrBuild();
        if (b3 != b1) throw new AssertionError();
        builderB1.d("Strawberry");
        B b4 = builderB1.getOrBuild();
        if (b1 == b4) throw new AssertionError();
        B b5 = builderB1.getOrBuild();
        if (b5 != b4) throw new AssertionError();
        B b6 = builderB1.build();
        if (b6 == b4) throw new AssertionError();
        B b7 = builderB1.build();
        if (b7 == b6) throw new AssertionError();
    }
}