record AppendEntry (
    int term,
    int leaderId,
    List<Payload> payloads,
    int prevLogTerm,
    int leaderCommit) { }

record appendEntryResponse (
    int term,
    boolean accepted,
    int conflictIndex,
    int conflictTerm) { }