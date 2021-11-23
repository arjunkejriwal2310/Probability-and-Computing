public class BallsIntoBinsRunner
{
    public static void main(String[] args)
    {
        //create new BallsIntoBin object and store it in a variable
        BallsIntoBins obj = new BallsIntoBins();
        //the call to this method generates stats for oneChoice
        obj.generateStats1();
        //the call to this method generates stats for twoChoice
        obj.generateStats2();
        //Generate the case for people's birthdays (Question 2)
        obj.generate(365);
        System.out.println(obj.timeOfFirstCollision);
    }
}
