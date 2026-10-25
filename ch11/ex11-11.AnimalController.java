@RestController
public class AnimalController {
    // ...
    
    private static final Random random = new Random();

    private final DistributionSummary winSummary;

    private final MeterRegistry registry;

    public AnimalController(MeterRegistry registry) {
        this.registry = registry;

        // 공격자가 승리했을 때 그 힘의 크기를 요약
        this.winSummary = registry.summary("attacker.win.size");

        // ...
    }
}