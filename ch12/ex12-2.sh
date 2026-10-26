jfr print --events CPULoad,JavaMonitorEnter recording.jfr


...

jdk.CPULoad {
  startTime = 11:51:57.745
  jvmUser = 8.75%
  jvmSystem = 0.57%
  machinTotal = 13.50%
}

jdk.JavaMonitorEnter {
  startTime = 11:51:58.065
  duration = 12.1 ms
  monitorClass = jdk.jfr.internal.PlatformRecorder (classLoader = bootstrap)
  previousOwner = "RMI TCP Connection(idle)" (javaThreadId = 32)
  address = 0x12CE66508
  eventThread = "JFR Periodic Tasks" (javaThreadId = 26)
}

...