package main.scala.Labs.List9;

public class Ex2 {
    //There are three common issues in multi-thread programming:
    //
    //- deadlock
    //
    //- livelock
    //
    //- race condition
    //
    //Provide simple illustrative examples of these issues.

    private class DeadlockExample{
        final String resource1 = "ratan jaiswal";
        final String resource2 = "vimal jaiswal";
        public DeadlockExample(){
            Thread t1 = new Thread(){
                public void run() {
                    synchronized (resource1) {
                        System.out.println("Thread 1: locked resource 1");

                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                        }

                        synchronized (resource2) {
                            System.out.println("Thread 1: locked resource 2");
                        }
                    }
                }};

            Thread t2 = new Thread(){
                public void run(){
                    synchronized (resource2) {
                        System.out.println("Thread 2: locked resource 2");

                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                        }

                        synchronized (resource1) {
                            System.out.println("Thread 2: locked resource 1");
                        }
                    }}};

            t1.start();
            t2.start();
        }
    }
    private class LivelockExample{
public LivelockExample(){
            final Worker worker1 = new Worker("Worker 1 ", true);
            final Worker worker2 = new Worker("Worker 2 ", true);

            final CommonResource s = new CommonResource(worker1);

            new Thread(() -> worker1.work(s, worker2)).start();
            new Thread(() -> worker2.work(s, worker1)).start();
        }
        class CommonResource {
            private Worker owner;

            public CommonResource(Worker d) {
                owner = d;
            }

            public Worker getOwner() {
                return owner;
            }

            public synchronized void setOwner(Worker d) {
                owner = d;
            }
        }

        class Worker {
            private String name;
            private boolean active;

            public Worker(String name, boolean active) {
                this.name = name;
                this.active = active;
            }

            public String getName() {
                return name;
            }

            public boolean isActive() {
                return active;
            }

            public synchronized void work(CommonResource commonResource, Worker otherWorker) {
                while (active) {
                    if (commonResource.getOwner() != this) {
                        try {
                            wait(10);
                        } catch (InterruptedException e) {
                            //ignore
                        }
                        continue;
                    }

                    if (otherWorker.isActive()) {
                        System.out.println(getName() + " : handover the resource to the worker " + otherWorker.getName());
                        commonResource.setOwner(otherWorker);
                        continue;
                    }

                    System.out.println(getName() + ": working on the common resource");
                    active = false;
                    commonResource.setOwner(otherWorker);
                }
            }
        }
    }
    private class RaceConditionExample{
        public RaceConditionExample(){
            class Counter {
                private int c = 0;

                public void increment() {
                    c++;
                }

                public void decrement() {
                    c--;
                }

                public int value() {
                    return c;
                }
            }
            class CounterThread extends Thread {
                protected Counter counter = null;

                public CounterThread(Counter counter) {
                    this.counter = counter;
                }

                public void run() {
                    for (int i = 0; i < 10; i++) {
                        counter.increment();
                        System.out.println(this.getName() + ": " + counter.value());
                    }
                }
            }
            Counter counter = new Counter();
            Thread threadA = new CounterThread(counter);
            Thread threadB = new CounterThread(counter);
            threadA.start();
            threadB.start();
        }
    }

    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        //DeadlockExample deadlockExample = ex2.new DeadlockExample();
        //LivelockExample livelockExample = ex2.new LivelockExample();
        RaceConditionExample raceConditionExample = ex2.new RaceConditionExample();
    }

}
