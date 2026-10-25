@RestController
public class AnimalController {
  // ...

  private final MeterRegistry registry;

  // ...

  public AnimalController(MeterRegistry registry) {
    this.registry = registry;

    new ProcessorMetrics().bindTo(this.registry);
    new JvmMemoryMetrics().bindTo(this.registry);
  }

  // ...
}