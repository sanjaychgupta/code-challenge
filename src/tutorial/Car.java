package tutorial;
// https://www.geeksforgeeks.org/java-basic-syntax/?ref=lbp
public class Car { //class
    // attribute,state
    public String brand;
    public String color;
    public int geatTransmission; // it only except 0 and 1. 0=manual; 1= automatic

    // Function/behaviour (input and output)
    public void drive() {
        System.out.println("Your car is ready for driving!.......");
    }

    public String gearUp(int currentGear, int gearCount) {
        String message = "Your car is "+ brand + " Gear is up by " + gearCount + " from " + currentGear + " to " + (currentGear + gearCount);
        return message;
    }

    public String gearDown(int currentGear, int gearCount) {
        int gearDown = currentGear - gearCount;
        String message = "Your car is "+ brand + " Gear is down by " + gearCount + " from " + currentGear + " to " + gearDown;
        return message;
    }

    public static void main(String xxxxxx[]){

        // carObj is instance variable  and  "new Car()" is  newly created memory reference
        Car carObj = new Car(); // Object
        System.out.println("first object for car carObj " + carObj);
        carObj.brand="Maruti";
        carObj.color="Red";
        carObj.geatTransmission=0;

        carObj.drive();
        String up=carObj.gearUp(3,1);
        System.out.println(up);

        String down= carObj.gearDown(5,2);
        System.out.println(down);




        System.out.println();
        System.out.println();
        System.out.println();



        Car carObj1 = new Car(); // Object
        System.out.println("Second object for car carObj1 " + carObj1);
        carObj1.brand="BMW";
        carObj1.color="Blue";
        carObj1.geatTransmission=1;

        carObj1.drive();
        up=carObj1.gearUp(10,3);
        System.out.println(up);

        down= carObj1.gearDown(15,5);
        System.out.println(down);


    }

}

/*  start of memory for object 1d44bcfa-31


Car
    attribute,state
        brand
        color
        gearTransmission
    Function/behaviour (input and output)
        drive()
        gearUp(number)
        gearDown(number)
                    1. {identifier  (public, private, protected, default)}
                    2. {returnType (void(no output), int , float , double, or your down object and so on...)}
                    3. {nameOfFunction }
                    4. {inputParameter (), (int),(int, float).....}
                    5. body
 endof memory of object  1d44bcfa-50 */