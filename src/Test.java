import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        // 1. Declare all the builders.
        A.ABuilder builderA1 = A.builder();
        A.ABuilder builderA2 = A.builder();
        B.BBuilder builderB1 = B.builder();
        B.BBuilder builderB2 = B.builder();
        C.CBuilder builderC = C.builder();

        // 2. Get the cached suppliers.
        Supplier<A> sa1 = Cached.cache(builderA1::build);
        Supplier<A> sa2 = Cached.cache(builderA2::build);
        Supplier<B> sb1 = Cached.cache(builderB1::build);
        Supplier<B> sb2 = Cached.cache(builderB2::build);
        Supplier<C> sc = Cached.cache(builderC::build);

        // 3. Populate all the builders
        builderA1.b(sb1).suppliedC(sc);
        builderA2.b(sb2).suppliedC(sc);
        builderB1.a(sa2).c(sc).d("Cupcake");
        builderB2.a(sa1).c(sc).d("Brownie");
        builderC.a(sa1).a(sa2).b1(sb1).b2(sb2);

        // 4. Produce the objects.
        A a1 = sa1.get();
        A a2 = sa2.get();
        B b1 = sb1.get();
        B b2 = sb2.get();
        C c = sc.get();

        // 5. Assert that the objects are what we wanted.
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
    }
}