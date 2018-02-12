



public class Application {}
//@SpringBootApplication
//@Import(CoherenceConfiguration.class)
//public class Application implements CommandLineRunner {
//  public static void main(String[] args) {
//    ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
//  }
//
//  @Override
//  public void run(String... strings) throws Exception {
//    String key = "k1";
//    String value = "Hello World!";
//
//    CacheFactory.ensureCluster();
//    NamedCache cache = CacheFactory.getCache("hello-example");
//
//    cache.put(key, value);
//    System.out.println((String)cache.get(key));
//
//    CacheFactory.shutdown();
//  }
//}
