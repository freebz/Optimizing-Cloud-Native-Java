Thread.Builder tb = Thread.ofVirtual();
tb.name("MyVirtualThread");
Thread t = tb.unstarted(() -> System.out.println("Hello World!"));
System.out.println(t);
t.start();