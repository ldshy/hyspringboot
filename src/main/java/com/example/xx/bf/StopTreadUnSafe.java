package com.example.xx.bf;

public class StopTreadUnSafe {
    public static User user= new User();
    public static class User{
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        private int id;
        private String name;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(){
            id=0;
            name="0";
        }

        @Override
        public String toString(){
            return "User [id ="+id+"name="+name+"]";
        }
    }

    public static class ChangObjectThread extends Thread{

        @Override
        public void  run() {
            while(true){
                synchronized(user){
                    int v = (int)(System.currentTimeMillis()/10);
                    user.setId(v);
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    public static class ReadObjectThread extends Thread{
        @Override
        public void run(){
            while(true){
                synchronized(user){
                    if(user.getId() != Integer.parseInt(user.getName())){
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }

        }
    }


    public static void main(String arg[]) throws InterruptedException{

        new ReadObjectThread().start();
        while(true){
            Thread t = new ChangObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }

    }

}
