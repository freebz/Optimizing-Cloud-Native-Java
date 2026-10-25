@GetMapping("/fight/{a}/{d}")
public String resolveFight(
    @PathVariable("a") String attacker, @PathVariable("d") String defender) {
  final String winner;
  // 방어자의 전투력은 0.5로 간주
  var attackerStrength = random.nextDouble();
  if (attackerStrength > 0.5) {
    winner = attacker;
    // 분포 요약에 추가
    winSummary.record(attackerStrength);
  } else {
    winner = defender;
  }
  return String.format("""
{ "winner": "%s"}""", winner);
}