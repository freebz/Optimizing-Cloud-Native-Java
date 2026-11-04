@Inject
@Remote("animals")
RemoteCache<String, String> lastBattledAnimal;


lastBattledAnimal.put(topic, payload);