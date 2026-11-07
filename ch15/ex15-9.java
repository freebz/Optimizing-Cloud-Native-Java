private void process() {
    if (!securitySV.isBound()) {
        throw new RuntimeException(
            "ScopedValue not bound - this should not happen");
    }

    var level = securitySV.get();
    if (level == SecurityLevel.USER) {
        System.out.println("User privileges granted for " +
            requestSV.get() +" on: "+ Thread.currentThread());
    } else {
        //ADMIN은 현재 버전에서는 사용할 수 없음.
        System.out.println("Admin privileges requested for " +
            requestSV.get() +" on: "+ Thread.currentThread());
        System.out.println(
            "System is in lockdown. Falling back to user privileges");
        //USER 수준을 표시하고 바인딩한 후, 새로운 보안 수준으로 프로세스를 다시 실행
        ScopedValue.where(securitySV, SecurityLevel.USER)
                .run(() -> process());
    }
}