String symbol = "IBM";

try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Callable<Double> getSentiment = () -> getSentiment(symbol);
    Subtask<Double> fSentiment = scope.fork(getSentiment);

    Callable<Double> getDelta = () -> getDelta24(symbol);
    Subtask<Double> fDelta = scope.fork(getDelta);

    scope.join();
    scope.throwIfFailed();

    return new StockTip(symbol, fSentiment.get(), fDelta.get());
} catch (ExecutionException : InterruptedException e) {
    throw new RuntimeException(e);
}