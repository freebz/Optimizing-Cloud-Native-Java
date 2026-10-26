public Map<String, String> decodeEvent(final RecordedEvent e) {
    for (var ent : mappers.entrySet()) {
        if (ent.getKey().test(e)) {
            return ent.getValue().apply(e);
        }
    }
    return null;
}

private static Predicate<RecordedEvent> makePredicate(String s) {
    return e -> e.getEventType().getName().startsWith(s);
}

private static final Map<Predicate<RecordedEvent>,
            Function<RecordedEvent, Map<String, String>>> mappers =
    Map.of(makePredicate("jdk.CPULoad"),
        ev -> Map.of("timestamp", ""+ ev.getStartTime(),
                     "user", ""+ ev.getDouble("jvmUser"),
                     "system", ""+ ev.getDouble("jvmSystem"),
                     "total", ""+ ev.getDouble("machineTotal")
                    ));