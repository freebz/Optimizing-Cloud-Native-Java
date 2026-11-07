public int tlr = (int) System.nanoTime();

/**
 * 객체를 소비하는데, 이 호출은 JIT 컴파일러가 관련된 연산을 제거하기 못하도록 하는 부작용을 발생 .
 * 
 * @param obj object to consume.
 */
public final void consume(Object obj) {
    int tlr = (this.tlr = (this.tlr * 1664525 + 1013904223));
    if ((tlr & tlrMask) == 0) {
        // 측정 중에는 거의 발생해서는 안되는 상황임
        this.obj1 = obj;
        this.tlrMask = (this.tlrMask << 1) + 1;
    }
}