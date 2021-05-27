public class DrawingProxy{
    public static void main(String[] args){
        RachelProxy rachelProxy = new RachelProxy(new Rachel("circle"));
        rachelProxy.Draw();
    }
}

interface Drawing{
    void Draw();
}

class Rachel implements Drawing{

    String shape;

    public Rachel(String shape){
        this.shape = shape;
    }

    @Override
    public void Draw(){
        System.out.println("Rachel wants to draw a "+shape);
    }
}

class RachelProxy implements Drawing{

    private Rachel rachel;

    public RachelProxy(Rachel rachel){
        this.rachel = rachel;
    }

    @Override
    public void Draw(){
        before();
        this.rachel.Draw();
        after();
    }

    public void before(){
        System.out.println("Before the drawing...");
    }

    public void after(){
        System.out.println("After the drawing...");
    }
}