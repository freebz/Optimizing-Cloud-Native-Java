private static final ScopedValue<SecurityLevel> securitySV =
    ScopedValue.newInstance();
private static final ScopedValue<Integer> requestSV = ScopedValue.newInstance();

private final AtomicInteger req = new AtomicInteger();

public void run() {
    // 현재 보안 수준의 바인딩을 표시
    ScopedValue.where(securitySV, level())
            //현재 요청 번호의 바인딩을 표시
            .where(requestSV, req.getAndIncrement())
            //값들을 바인딩
            .run(() -> process());
}