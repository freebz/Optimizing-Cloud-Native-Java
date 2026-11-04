@ApplicationScoped
public class VeterinaryHospital {

  public static final String FISH_CHANNEL = "fish";
  public static final String FELINE_CHANNEL = "feline";
  public static final String MUSTELID_CHANNEL = "mustelid";

  @PostConstruct
  public void init() {}

  void onStart(@Observes StartupEvent ev) {
    Log.infof("Hospital starting up");
  }

  @Incoming(FISH_CHANNEL)
  @Incoming(FELINE_CHANNEL)
  @Incoming(MUSTELID_CHANNEL)
  public CompletionStage<Void> processMainFlow(Message<String> message) {
    var payload = message.getPayload();
    var topic = message.getMetadata(IncomingKafkaRecordMetadata.class)
                       .get().getTopic();
    
    Log.infof("Processed: %s on topic %s, benching them for the next round",
     payload, topic);
    
    return message.ack();
  }
}