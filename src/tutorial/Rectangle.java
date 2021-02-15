package tutorial;

public class Rectangle
{
    public int length;
    public int breadth;
    public int area;


    public void rotate(){
        System.out.println("Your rectangle is rotated");
    }

    public void shrink(int currentArea, int shrunkArea)
    {
        float shrinkPercentage = (float)(currentArea - shrunkArea) / currentArea; // when you divide result is decimal
        String message = "Your rectangle's area has shrunk by" + shrinkPercentage + "percent";
        System.out.println(message); // I added
        return; // this correct for void method GOOD!!!
    }

    public void enlarge(int currentArea, int enlargedArea)
    {
        float enlargepercentage = (float)(enlargedArea - currentArea) / enlargedArea; // when you divide result is decimal
        String message = "Your rectangle's area has enlarged by" + enlargepercentage + "percent";
        System.out.println(message); // I added
        return; // this correct for void method GOOD!!!
    }






    public static void main(String args[])
    {
        Rectangle obj1=new Rectangle();
        obj1.length=5;
        obj1.breadth=4;


        obj1.rotate();
        obj1.shrink(20,10);
        obj1.shrink(20,10);
        /*
        String shrunk=obj1.shrink(20,10);
        System.out.println(shrunk);
         */


    }
}


/*

Attributes
Length, Breath, Height and Area

Function
Rotate, Shrink and Enlarge
*/