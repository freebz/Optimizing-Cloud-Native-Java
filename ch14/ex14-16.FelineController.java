@GetMapping("/getAnimal")
public String makeBattle() throws InterruptedException {
  // 무작위 중단
  Thread.sleep((int) (20 * Math.random()));

  // 마지막 부상당한 animal을 조회
  var injured = cacheManager.getCache(InfinispanConfiguration.CACHE_NAME)
                            .get("FELINE");
  String cat;
  do {
    Thread.sleep(1);
    cat = CATS.get((int) (CATS.size() * Math.random()));
    System.out.printf("Looking up uninjured cat - is %s OK?", cat);
  } while (injured == null || injured.equals(cat));

  // 무작위로 부상당하지 않은 cat을 반환하고, 동시에 카프카로 전송
  var key = UUID.randomUUID().toString();
  var producerRecord = new ProducerRecord<>("FELINE", key, cat);
  producer.send(producerRecord);
  return cat;
}


@Autowired private RemoteCacheManager cacheManager;