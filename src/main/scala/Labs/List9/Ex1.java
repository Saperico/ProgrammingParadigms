package main.scala.Labs.List9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Ex1 {
    //Write a program that simulates the traffic of ships in a port.
    //Ships entry and leave the port. There are N ships.
    //After entering the port, each ship must occupy some free port location.
    //The number of places is limited, i.e. m: (m <N). Moreover, to enter or leave the port, the i-th ship needs ki tugs.
    //The total number of tugs is h: (h<(∑ni=1ki)).
    //
    //Write a program that represents ships as threads. The program should ensure that neither ship-thread will be deadlocked or starved.
    //Locations in port and tugs should be considered as resources.

    private class Ship extends Thread {
        private int id;
        private int neededTugs;
        private int currentTugs;
        private int location;
        private Port port;
        private boolean entered = false;
        public Ship(int id, int tugs, Port port) {
            this.id = id;
            this.neededTugs = tugs;
            this.port = port;

        }

        public void run() {
            try {
                while (true) {
                    if (!entered) {
                        double random = Math.random();
                        if (random > 0.9) {
                            sendMessage(Type.ENTER);
                            wait();//if notified by a port that there's place and tugs, then it's entering
                            Thread.sleep(5000); //ship is entering the port, it takes some time
                            sendMessage(Type.ENTERED); //notify the port that it entered
                            entered = true;
                        }
                    }
                    else{
                        Thread.sleep((int) (Math.random() * 14000 + 1000));//wait some random time between 1 and 15 seconds
                        sendMessage(Type.LEAVE);
                        wait();//if notified by a port that there's place and tugs, then it's leaving
                        Thread.sleep(3000); //ship is leaving the port, it takes some time
                        sendMessage(Type.LEFT); //notify the port that it left
                        entered = false;
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void sendMessage(Type message)
        {
            try {
                port.messages.put(new Message(this, message));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public long getId() {
            return id;
        }

        public int getNeededTugs() {
            return neededTugs;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }
    }
    private enum Type {
        ENTER, ENTERED, LEAVE, LEFT
    }
    private class Message {
        private Ship ship;
        private Type message;
        public Message(Ship ship, Type message) {
            this.ship = ship;
            this.message = message;
        }
    }
    private class Port {
        private int size;
        private int availableTugs;
        private Ship[] ships;
        private boolean[] locations;

        private BlockingQueue<Message> messages = new LinkedBlockingQueue<>();
        private Queue<Ship> enteringShips = new LinkedList<>();
        private Queue<Ship> leavingShips = new LinkedList<>();

        public Port(int size, int availableTugs) {
            this.size = size;
            this.availableTugs = availableTugs;
            ships = new Ship[size];
            locations = new boolean[size];
        }

        private void populateShips(int ships)
        {
            for (int i = 0; i < ships; i++) {
                new Ship(i, (int) (Math.random() * 3 + 1), this).start();
            }
        }

        public void run(){
            populateShips(100);
            while (true) {
                try {
                    Message message = messages.take();
                    switch (message.message) {
                        case ENTER:
                            enteringShips.add(message.ship);
                            break;
                        case ENTERED, LEFT:
                            availableTugs += message.ship.getNeededTugs();
                            break;
                        case LEAVE:
                            leavingShips.add(message.ship);
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                manageShips();
            }
        }

        private void manageShips()
        {
            if(!leavingShips.isEmpty()) //leaving ships have priority
            {
                Ship ship = leavingShips.peek();
                if(availableTugs >= ship.getNeededTugs())
                {
                    leavingShips.poll();
                    removeShip(ship);
                }
            }
            else if(!enteringShips.isEmpty())
            {
                Ship ship = enteringShips.peek();
                if(findFreeLocation() != -1 && availableTugs >= ship.getNeededTugs())
                {
                    enteringShips.poll();
                    addShip(ship);
                }
            }
        }

        private void removeShip(Ship ship) {
            availableTugs -= ship.getNeededTugs();
            int location = ship.getLocation();
            ships[location] = null;
            locations[location] = false;
            ship.notify();
        }

        private void addShip(Ship ship)
        {
            availableTugs -= ship.getNeededTugs();
            int location = findFreeLocation();
            ship.setLocation(location);
            ships[location] = ship;
            locations[location] = true;
            ship.notify();
        }
        private int findFreeLocation() {
            for (int i = 0; i < size; i++) {
                if (!locations[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    public void run() {
        int size = 10;
        int tugs = 24;
        Port port = new Port(size, tugs);
        port.run();
    }

    public static void main(String[] args) {
        new Ex1().run();
    }
}
