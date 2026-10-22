//  logging_only 분기의 SLF4J 코드 예제
@RestController
public class AnimalController {
  private static Logger LOGGER = LoggerFactory.getLogger(AnimalController.class);

  // ...

  private String fetchRandomAnimal() throws IOException, InterruptedException {
    var pause = (int) (SERVICES.size() * Math.random());
    LOGGER.info("Pausing for: "+ pause);

    // ...
  }
}