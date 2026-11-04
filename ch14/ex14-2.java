record RequestVote (
    int term,
    int candidateId,
    int lastLogIndex,
    int lastLogTerm
) {}

record RequestVoteResponse(
    int term,
    boolean inFavor
) {}