public final class A {
    private final B b;

    private final C c;

    private A(ABuilder $lombokTemp0) {
        if ($lombokTemp0.b == null) throw new NullPointerException("b");
        if ($lombokTemp0.c == null) throw new NullPointerException("c");
        $lombokTemp0.$lombokLastInstance = this;
        this.b = $lombokTemp0.b.getOrBuild();
        this.c = $lombokTemp0.c.getOrBuild();
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

    public ABuilderFactoryInterface $lombokHold() {
        return new ABuilderFactoryInterface() {
            @Override
            public A getOrBuild() {
                return A.this;
            }
        };
    }

    // equals(Object), hashCode() and toString() methods ommited.

    public static final class ABuilder implements ABuilderFactoryInterface {
        private B.BBuilderFactoryInterface b;
        private C.CBuilderFactoryInterface c;
        private A $lombokLastInstance;

        private ABuilder() {
        }

        public ABuilder b(B b) {
            $lombokLastInstance = null;
            this.b = b.$lombokHold();
            return this;
        }

        public ABuilder b(B.BBuilder b) {
            $lombokLastInstance = null;
            this.b = b;
            return this;
        }

        public ABuilder c(C c) {
            $lombokLastInstance = null;
            this.c = c.$lombokHold();
            return this;
        }

        public ABuilder suppliedC(C.CBuilder c) {
            $lombokLastInstance = null;
            this.c = c;
            return this;
        }

        public A build() {
            $lombokLastInstance = new A(this);
            return $lombokLastInstance;
        }

        @Override
        public A getOrBuild() {
            if ($lombokLastInstance == null) build();
            return $lombokLastInstance;
        }

        // toString() method ommited.
    }

    public static interface ABuilderFactoryInterface {
        public A getOrBuild();
    }
}