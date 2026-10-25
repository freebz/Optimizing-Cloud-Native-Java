@RestController
public class MammalController {
  // ...

  private final FelinePercent felinePercent;
  private int felineCount = 0;
  private int mustelidCount = 0;

  private final MeterRegistry registry;

  public MammalController(MeterRegistry registry) {
    this.registry = registry;
    felinePercent = this.registry.guage("battles.felinePercent",
      new FelinePercent(0.5));
  }

  @GetMapping("/getAnimal")
  public String getAnimal() throws IOException, InterruptedException {
    // ...

    var id = (int) (SERVICES.size() * Math.random());
    if (id == 0) {
      mustelidCount += 1;
    } else {
      felineCount += 1;
    }
    felinePercent.setValue((double) felineCount / (double) (felineCount
      + mustelidCount))
    
    // ...
  }
}