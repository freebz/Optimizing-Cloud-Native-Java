public volatile int i1 = 1, i2 = 2;

/**
 * 객체를 소비하는데, 이 호출은 JIT 컴파일러가 관련된 연산을 제거하기 못하도록 하는 부작용을 발생
 * 
 * @param i int to consume.
 */
public final void consume(int i) {
    if (i == i1 & i == i2) {
        // 절대 발생해서는 안됨
        nullBait.i1 = i; // 암시적 널 포인터 예외
    }
}