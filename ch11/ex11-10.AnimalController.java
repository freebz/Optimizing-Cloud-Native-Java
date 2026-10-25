@RestController
public class AnimalController {
  // ...

  private final Timer responseTimer;

  private final MeterRegistry registry;

  // ...

  public AnimalController(MeterRegistry registry) {
    this.registry = registry;

    // ...

    this.responseTimer = Timer
            .builder("response.time")
            .description("Response time")
            .register(registry);
  }

  @GetMapping("/battle")
  public String makeBattle() throws Exception {
    Callable<String> callable = () -> {
      // Send the two requests and return the response body as the response
      var good = fetchRandomAnimal();
      var evil = fetchRandomAnimal();
      return String.format("""
{ "good": "%s", "evil": "%s" }""", good, evil);
    };

    // ...

    return responseTimer.recordCallable(callable);
  }
}