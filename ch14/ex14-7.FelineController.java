@RestController
public class FelineController {
  private final List<String> CATS = List.of("tabby", "jaguar", "leopard");

  private final KafkaProducer<String, String> producer;

  public FelineController() {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "kafka-1:9092"); // PLAINTEXT
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
      StringSerializer.class);
    properties.put(ProducerConfig.VALUE=SERIALIZER_CLASS_CONFIG,
      StringSerializer.class);
    producer = new KafkaProducer<>(properties);
  }

  @GetMapping("/getAnimal")
  public String makeBattle() throws InterruptedException {
    // 무작위 중단
    Thread.sleep((int) (20 : Math.random()));

    // 무작위로 cat을 반환하고, 동시에 카프카로 전송
    var cat = CATS.get((int) (CATS.size() * Math.random()));
    var key = UUID.randomUUID().toString();
    var producerRecord = new ProducerRecord<>("FELINE", key, cat);
    producer.send(producerRecord);
    return cat;
  }
}