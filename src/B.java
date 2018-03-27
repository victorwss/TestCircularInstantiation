public final class B {
    private final A a;

    private final C c;

    private final String d;

    private B(BBuilder $lombokTemp0) {
        if ($lombokTemp0.a == null) throw new NullPointerException("a");
        if ($lombokTemp0.c == null) throw new NullPointerException("c");
        if ($lombokTemp0.d == null) throw new NullPointerException("d");
        $lombokTemp0.$lombokLastInstance = this;
        this.a = $lombokTemp0.a.getOrBuild();
        this.c = $lombokTemp0.c.getOrBuild();
        this.d = $lombokTemp0.d;
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

    public BBuilderFactoryInterface $lombokHold() {
        return new BBuilderFactoryInterface() {
            @Override
            public B getOrBuild() {
                return B.this;
            }
        };
    }

    // equals(Object), hashCode() and toString() methods ommited.

    public static final class BBuilder implements BBuilderFactoryInterface {
        private A.ABuilderFactoryInterface a;
        private C.CBuilderFactoryInterface c;
        private String d;
        private B $lombokLastInstance;

        private BBuilder() {
        }

        public BBuilder a(A a) {
            $lombokLastInstance = null;
            this.a = a.$lombokHold();
            return this;
        }

        public BBuilder a(A.ABuilder a) {
            $lombokLastInstance = null;
            this.a = a;
            return this;
        }

        public BBuilder c(C c) {
            $lombokLastInstance = null;
            this.c = c.$lombokHold();
            return this;
        }

        public BBuilder c(C.CBuilder c) {
            $lombokLastInstance = null;
            this.c = c;
            return this;
        }

        public BBuilder d(String d) {
            $lombokLastInstance = null;
            this.d = d;
            return this;
        }

        public B build() {
            $lombokLastInstance = new B(this);
            return $lombokLastInstance;
        }

        @Override
        public B getOrBuild() {
            if ($lombokLastInstance == null) build();
            return $lombokLastInstance;
        }

        // toString() method ommited.
    }

    public static interface BBuilderFactoryInterface {
        public B getOrBuild();
    }
}
