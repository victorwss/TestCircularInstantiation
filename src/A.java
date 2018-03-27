public final class A {
    private final B b;

    private final C c;

    private A(
            java.util.function.Consumer<A> $lombokIncompletePublisher,
            java.util.function.Supplier<? extends B> b,
            java.util.function.Supplier<? extends C> c)
    {
        if (b == null) throw new NullPointerException("b");
        if (c == null) throw new NullPointerException("c");
        $lombokIncompletePublisher.accept(this);
        this.b = b.get();
        this.c = c.get();
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    public static ABuilder builder() {
        return new ABuilder();
    }

    // equals(Object), hashCode() and toString() methods ommited.

    public static final class ABuilder {
        private java.util.function.Supplier<? extends B> b;
        private java.util.function.Supplier<? extends C> c;

        private ABuilder() {
        }

        public ABuilder b(B b) {
            this.b = () -> b;
            return this;
        }

        public ABuilder b(java.util.function.Supplier<? extends B> b) {
            this.b = b;
            return this;
        }

        public ABuilder c(C c) {
            this.c = () -> c;
            return this;
        }

        public ABuilder suppliedC(java.util.function.Supplier<? extends C> c) {
            this.c = c;
            return this;
        }

        public A build() {
            return build($lombokDummy -> {});
        }

        public A build(java.util.function.Consumer<A> $lombokIncompletePublisher) {
            return new A($lombokIncompletePublisher, this.b, this.c);
        }

        // toString() method ommited.
    }
}