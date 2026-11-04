@Configuration
public class InfinispanConfiguration {
  public static final String CACHE_NAME = "animals";

  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public InfinispanRemoteCacheCustomizer caches() {
    return b -> {
      URI cacheConfigUri;
      try {
        cacheConfigUri = this.getClass().getClassLoader()
                             .getResource("animals.xml").toURI();
      } catch (URISystemException e) {
        throw new RuntimeException(e);
      }
      b.remoteCache(CACHE_NAME).configurationURI(cacheConfigUri);
    };
  }
}