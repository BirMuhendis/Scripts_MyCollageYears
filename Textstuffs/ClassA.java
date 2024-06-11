import java.io.Serializable;

public class ClassA implements Serializable{
    String str;
    int a;
    float b;
    double c;
    
    ClassA(String str,int a,float b, double c)
    {
        this.str=str;   this.a=a;
        this.b=b;       this.c=c;
    }
    @Override
    public String toString()
    {
        return " str: "+ str + "\n a: " + a + "\n b: " + b + "\n c: " + c + " "; 
    }
}
