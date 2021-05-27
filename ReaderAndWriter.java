public class ReaderAndWriter {
    public static void main(String args[]){
        SysContainner sysContainner = new SysContainner();
        new ConcurrentReader(sysContainner).start();
        new ConcurrentWriter(sysContainner).start();
    }
}
class ConcurrentReader extends Thread{
    SysContainner sysContainner;
    public ConcurrentReader(SysContainner sysContainner){
        this.sysContainner = sysContainner;
    }

    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("写入了" + i + "个字符");
            sysContainner.push(new Stuff((char)i));
        }
    }

}
class ConcurrentWriter extends Thread{
    SysContainner sysContainner;
    public ConcurrentWriter(SysContainner sysContainner){
        this.sysContainner = sysContainner;
    }
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("读出了" + i + "个字符");
            Stuff stuff = sysContainner.pop();
        }
    }
}
class Stuff {
    char c;
    public Stuff (char c) {
        this.c = c;
    }
}

class SysContainner {
    Stuff[] stuffs = new Stuff[10];

    int count = 0;

    //put the stuff
    public synchronized void push(Stuff stuff){
        if(count == stuffs.length){
            try{
                this.wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        stuffs[count] = stuff;
        count++;

        this.notifyAll();
    }
    //pop the stuff
    public synchronized Stuff pop(){
        if(count == 0){
            try{
                this.wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        count--;
        Stuff stuff = stuffs[count];

        this.notifyAll();
        return stuff;

    }

}