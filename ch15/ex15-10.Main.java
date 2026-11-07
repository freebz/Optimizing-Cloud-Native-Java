public class Main {
    private static final int INT_SIZE = 4;
    private static final long ARENA_SIZE = 4 * 1024 * 1024 * 1024;

    public static void main(String[] args) {
        long l = 0;
        try (var arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocate(INT_SIZE * ARENA_SIZE);
            for (l = 0 ; l < ARENA_SIZE ; l += 1) {
                segment.setAtIndex(ValueLayout.JAVA_INT, l, (int)(l % 16));
            }
        }
        System.out.println("l = "+ l);
    }
}