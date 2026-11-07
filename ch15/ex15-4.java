<T> List<T> runAll(List<Callable<T>> tasks)
        throws InterruptedException, ExecutionException {

    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
        List<? extends Subtask<T>> handles =
            tasks.stream().map(scope::fork).toList();
        
        scope.join()
            .throwIfFailed();   // 하위 작업 중 하나라도 실패하면 예외를 전파
        
        // 모든 작업이 성공했으므로, 그 결과를 합성
        return handles.stream().map(Subtask::get).toList();
    }
}