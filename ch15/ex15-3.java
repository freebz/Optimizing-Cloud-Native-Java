<T> T race(List<Callable<T>> tasks, Instant deadline)
        throws InterruptedException, ExecutionException, TimeoutException {

    try (var scope = new StructuredTaskScope.ShutdownOnSuccess<T>()) {
        for (var task : tasks) {
            scope.fork(task);
        }
        return scope.joinUntil(deadline)
                    .result();  // 하위 작업 중 어느 것도 성공적으로 완료되지 않을 경우 예외를 발생
    }
}