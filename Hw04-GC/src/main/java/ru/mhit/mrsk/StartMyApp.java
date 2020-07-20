package ru.mhit.mrsk;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;


public class StartMyApp  {
    public static void main(String[] args) throws InterruptedException {
        int ind = 1;
        System.out.println(Integer.toString(ind));
        ArrayList<Object> list = new ArrayList<>();
        try {
            while (ind<1000000) {
                for (int i = 1; i < 10000; i++) {
                    list.add(new Object());
                    if (i%2==0){
                        list.remove(list.size()-1);
                    }
                }
                System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
                switchOnMonitoring();

                long beginTime = System.currentTimeMillis();
                ind++;
                Thread.sleep(80);
            }
         }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("End");
        }
    }

    private static void switchOnMonitoring() {
        List<GarbageCollectorMXBean> gcbeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcbean : gcbeans) {
            System.out.println("GC name:" + gcbean.getName());
            NotificationEmitter emitter = (NotificationEmitter) gcbean;
            NotificationListener listener = (notification, handback) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
                    String gcName = info.getGcName();
                    String gcAction = info.getGcAction();
                    String gcCause = info.getGcCause();

                    long startTime = info.getGcInfo().getStartTime();
                    long duration = info.getGcInfo().getDuration();

                    System.out.println("start:" + startTime + " Name:" + gcName + ", action:" + gcAction + ", gcCause:" + gcCause + "(" + duration + " ms)");
                }
            };
            emitter.addNotificationListener(listener, null, null);
        }
    }
}
