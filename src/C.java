import java.util.List;

public final class C {
    private final List<A> as;

    private final B b1;

    private final B b2;

    private C(
            java.util.function.Consumer<C> $lombokIncompletePublisher,
            java.util.List<java.util.function.Supplier<? extends A>> as,
            java.util.function.Supplier<? extends B> b1,
            java.util.function.Supplier<? extends B> b2)
    {
        if (as == null) throw new NullPointerException("as");
        if (b1 == null) throw new NullPointerException("b1");
        if (b2 == null) throw new NullPointerException("b2");
        $lombokIncompletePublisher.accept(this);
        this.as = as.stream().map(java.util.function.Supplier::get).collect(java.util.stream.Collectors.toUnmodifiableList());
        this.b1 = b1.get();
        this.b2 = b2.get();
    }

    public List<A> getAs() {
        return as;
    }

    public B getB1() {
        return b1;
    }

    public B getB2() {
        return b2;
    }

    public static CBuilder builder() {
        return new CBuilder();
    }

    // equals(Object), hashCode() and toString() methods ommited.

    public static class CBuilder {
        private final java.util.List<java.util.function.Supplier<? extends A>> as;
        private java.util.function.Supplier<? extends B> b1;
        private java.util.function.Supplier<? extends B> b2;

        private CBuilder() {
            this.as = new java.util.ArrayList<>();
        }

        public CBuilder a(A a) {
            this.as.add(() -> a);
            return this;
        }

        public CBuilder a(java.util.function.Supplier<? extends A> a) {
            this.as.add(a);
            return this;
        }

        public CBuilder as(java.util.Collection<? extends A> as) {
            as.forEach(a -> this.as.add(() -> a));
            return this;
        }

        public CBuilder clearAs() {
            this.as.clear();
            return this;
        }

        public CBuilder b1(B b1) {
            this.b1 = () -> b1;
            return this;
        }

        public CBuilder b1(java.util.function.Supplier<? extends B> b1) {
            this.b1 = b1;
            return this;
        }

        public CBuilder b2(B b2) {
            this.b2 = () -> b2;
            return this;
        }

        public CBuilder b2(java.util.function.Supplier<? extends B> b2) {
            this.b2 = b2;
            return this;
        }

        public C build() {
            return build($lombokDummy -> {});
        }

        public C build(java.util.function.Consumer<C> $lombokIncompletePublisher) {
            return new C($lombokIncompletePublisher, this.as, this.b1, this.b2);
        }

        // toString() method ommited.
    }
}
