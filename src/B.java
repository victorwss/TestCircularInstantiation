public final class B {
    private final A a;

    private final C c;

    private final String d;

    private B(
            java.util.function.Consumer<B> $lombokIncompletePublisher,
            java.util.function.Supplier<? extends A> a,
            java.util.function.Supplier<? extends C> c,
            String d)
    {
        if (a == null) throw new NullPointerException("a");
        if (c == null) throw new NullPointerException("c");
        if (d == null) throw new NullPointerException("d");
        $lombokIncompletePublisher.accept(this);
        this.a = a.get();
        this.c = c.get();
        this.d = d;
    }

    public A getA() {
        return a;
    }

    public C getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public static BBuilder builder() {
        return new BBuilder();
    }

    // equals(Object), hashCode() and toString() methods ommited.

    public static final class BBuilder {
        private java.util.function.Supplier<? extends A> a;
        private java.util.function.Supplier<? extends C> c;
        private String d;

        private BBuilder() {
        }

        public BBuilder a(A a) {
            this.a = () -> a;
            return this;
        }

        public BBuilder a(java.util.function.Supplier<? extends A> a) {
            this.a = a;
            return this;
        }

        public BBuilder c(C c) {
            this.c = () -> c;
            return this;
        }

        public BBuilder c(java.util.function.Supplier<? extends C> c) {
            this.c = c;
            return this;
        }

        public BBuilder d(String d) {
            this.d = d;
            return this;
        }

        public B build() {
            return build($lombokDummy -> {});
        }

        public B build(java.util.function.Consumer<B> $lombokIncompletePublisher) {
            return new B($lombokIncompletePublisher, this.a, this.c, this.d);
        }

        // toString() method ommited.
    }
}
