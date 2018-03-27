import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Cached<X> implements Supplier<X> {
    private Function<Consumer<X>, X> wrapped;

    private Cached(Function<Consumer<X>, X> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public X get() {
        return wrapped.apply(x -> wrapped = z -> x);
    }

    public static <X> Supplier<X> cache(Function<Consumer<X>, X> wrapped) {
        return new Cached<>(wrapped);
    }
}