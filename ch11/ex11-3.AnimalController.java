@RestController
public class AnimalController {
  // ...

  private final Counter battlesTotal;

  private final MeterRegistry registry;

  // ...

  public AnimalController(MeterRegistry registry) {
    this.registry = registry;
    this.battlesTotal = this.registry.counter("battles.total");
  }

  @GetMapping("/battle")
  public String makeBattle() throws IOException, InterruptedException {
    battlesTotal.increment();

    // ...
  }
}