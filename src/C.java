import java.util.List;

public final class C {
    private final List<A> as;

    private final B b1;

    private final B b2;

    private C(CBuilder $lombokTemp0) {
        if ($lombokTemp0.as == null) throw new NullPointerException("as");
        if ($lombokTemp0.b1 == null) throw new NullPointerException("b1");
        if ($lombokTemp0.b2 == null) throw new NullPointerException("b2");
        $lombokTemp0.$lombokLastInstance = this;
        java.util.List<A> $lombokTemp1 = new java.util.ArrayList<A>($lombokTemp0.as.size());
        for (A.ABuilderFactoryInterface $lombokTemp2 : $lombokTemp0.as) {
            $lombokTemp1.add($lombokTemp2.getOrBuild());
        }
        this.as = $lombokCopyList($lombokTemp1);
        this.b1 = $lombokTemp0.b1.getOrBuild();
        this.b2 = $lombokTemp0.b2.getOrBuild();
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

    public CBuilderFactoryInterface $lombokHold() {
        return new CBuilderFactoryInterface() {
            @Override
            public C getOrBuild() {
                return C.this;
            }
        };
    }

    private static <X> java.util.List<X> $lombokCopyList(java.util.List<X> list) {
        switch (list.size()) {
            case 0:
                return java.util.Collections.<X>emptyList();
            case 1:
                return java.util.Collections.singletonList(list.get(0));
            default:
                return java.util.Collections.unmodifiableList(list);
        }
    }

    public static class CBuilder implements CBuilderFactoryInterface {
        private final java.util.List<A.ABuilderFactoryInterface> as;
        private B.BBuilderFactoryInterface b1;
        private B.BBuilderFactoryInterface b2;
        private C $lombokLastInstance;

        private CBuilder() {
            this.as = new java.util.ArrayList<A.ABuilderFactoryInterface>();
        }

        public CBuilder a(A a) {
            $lombokLastInstance = null;
            this.as.add(a.$lombokHold());
            return this;
        }

        public CBuilder a(A.ABuilder a) {
            $lombokLastInstance = null;
            this.as.add(a);
            return this;
        }

        public CBuilder as(java.util.Collection<? extends A> as) {
            $lombokLastInstance = null;
            for (A a : as) {
                this.as.add(a.$lombokHold());
            }
            return this;
        }

        public CBuilder clearAs() {
            $lombokLastInstance = null;
            this.as.clear();
            return this;
        }

        public CBuilder b1(B b1) {
            $lombokLastInstance = null;
            this.b1 = b1.$lombokHold();
            return this;
        }

        public CBuilder b1(B.BBuilder b1) {
            $lombokLastInstance = null;
            this.b1 = b1;
            return this;
        }

        public CBuilder b2(B b2) {
            $lombokLastInstance = null;
            this.b2 = b2.$lombokHold();
            return this;
        }

        public CBuilder b2(B.BBuilder b2) {
            $lombokLastInstance = null;
            this.b2 = b2;
            return this;
        }

        public C build() {
            $lombokLastInstance = new C(this);
            return $lombokLastInstance;
        }

        @Override
        public C getOrBuild() {
            if ($lombokLastInstance == null) build();
            return $lombokLastInstance;
        }

        // toString() method ommited.
    }

    public static interface CBuilderFactoryInterface {
        public C getOrBuild();
    }
}
