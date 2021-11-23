import java.util.Random;

public class BallsIntoBins
{
    //initialize the variable storing the time of the first collision
    int timeOfFirstCollision = 0;
    //initialize the variable storing the maximum occupancy after the nth trial
    int maxOccupancy = 0;
    //initialize the variable storing the number of trials needed until all buckets have occupancy of at least 1
    int fillTime = 0;

    //this method generates values for the SingleChoice csv file
    public void generate(int size)
    {
        //Create a Random object and store it in a variable called 'rand'
        Random rand = new Random();

        //'binsContents' is the array of ints which stores the occupancy of each bin
        int[] binsContents = new int[size];

        //create and initialize a variable called 'trial' to 0 in order to keep track of the number of trials:
        int trial = 0;

        //create a boolean variable called 'collisionFlag' and set it to 0 (since no collision has occurred yet)
        boolean collisionFlag = false;
        //initialize timeOfFirstCollision (trial when first collision occurred) and maxOccupancy to 0
        timeOfFirstCollision = 0;
        maxOccupancy = 0;

        //create a variable called binsFilled which tells you how many bins have at least 1 ball in them
        //initialize the variable to 0 since no bins have a ball yet
        int binsFilled = 0;
        //initialize fillTime to -1 since this makes it easier to exit the loop
        fillTime = -1;

        //keep executing the contents of the loop until all bins have at least 1 ball in them
        while (fillTime == -1) {
            //increment the trial variable
            trial++;

            //in each trial, generate a random outcome between 0 and n-1
            int outcome = rand.nextInt(size);

            //check if the bin selected randomly is currently occupied
            if (binsContents[outcome] != 0) {
                //if the bin is indeed occupied, then report that a collision has occurred
                //if the collisionFlag is false, this means that no collision has occurred yet
                //Thus, set collisionFlag to true and store the trial number into timeOfFirstCollision
                if (!collisionFlag) {
                    collisionFlag = true;
                    timeOfFirstCollision = trial;
                }

            } else {
                //If bin was empty, it now has at least 1 ball in it. Thus, increment binsFilled by 1
                binsFilled++;
            }

            //increment the occupancy of the bin where the ball was added by 1
            binsContents[outcome]++;

            //check the contents of the bin exceeds maxOccupancy. If it does, reset the value of maxOccupancy
            if (binsContents[outcome] > maxOccupancy) {
                maxOccupancy = binsContents[outcome];
            }

            //if binsFilled is equal to n (the size), this means that all bins have been filled
            if (binsFilled == size) {
                fillTime = trial;
            }
        }
    }

    //this method generates values for the DoubleChoice CSV filed
    public void generate2(int size) {
        //Create a Random object and store it in a variable called 'rand'
        Random rand = new Random();

        //'binsContents' is the array of ints which stores the occupancy of each bin
        int[] binsContents = new int[size];

        //create and initialize a variable called 'trial' to 0 in order to keep track of the number of trials:
        int trial = 0;

        //create a boolean variable called 'collisionFlag' and set it to 0 (since no collision has occurred yet)
        boolean collisionFlag = false;
        //initialize timeOfFirstCollision (trial when first collision occurred) and maxOccupancy to 0
        timeOfFirstCollision = 0;
        maxOccupancy = 0;

        //create a variable called binsFilled which tells you how many bins have at least 1 ball in them
        //initialize the variable to 0 since no bins have a ball yet
        int binsFilled = 0;
        //initialize fillTime to -1 since this makes it easier to exit the loop
        fillTime = -1;

        //keep executing the contents of the loop until all bins have at least 1 ball in them
        while (fillTime == -1) {
            //increment the trial variable
            trial++;

            //generate two random outcomes in each trial between 0 and n-1
            int outcome1 = rand.nextInt(size);
            int outcome2 = rand.nextInt(size);
            int outcome;

            //compare the occupancy of the two bins
            // Continue with the bin that has the lesser occupancy for th rest of the operation
            if (binsContents[outcome1] <= binsContents[outcome2]) {
                outcome = outcome1;
            } else {
                outcome = outcome2;
            }

            //check if the bin selected randomly is currently occupied
            if (binsContents[outcome] != 0) {
                //if the bin is indeed occupied, then report that a collision has occurred
                //if the collisionFlag is false, this means that no collision has occurred yet
                //Thus, set collisionFlag to true and store the trial number into timeOfFirstCollision
                if (!collisionFlag) {
                    collisionFlag = true;
                    timeOfFirstCollision = trial;
                }

            } else {
                //If bin was empty, it now has at least 1 ball in it. Thus, increment binsFilled by 1
                binsFilled++;
            }

            //increment the occupancy of the bin where the ball was added by 1
            binsContents[outcome]++;

            //check the contents of the bin exceeds maxOccupancy. If it does, reset the value of maxOccupancy
            if (binsContents[outcome] > maxOccupancy) {
                maxOccupancy = binsContents[outcome];
            }

            //if binsFilled is equal to n (the size), this means that all bins have been filled
            if (binsFilled == size) {
                fillTime = trial;
            }
        }
    }

    //this method generates the statistics of the SingleChoice variation using the CSVWriter class
    public void generateStats1()
    {
        //this constant stores the number of times the method will test each size
        final int timesRepeated = 5;

        CSVWriter csv = new CSVWriter("SingleChoice.csv");
        csv.addEntry("Size");

        csv.addEntry("Minimum value for the First Collision");
        csv.addEntry("Maximum value for the First Collision");
        csv.addEntry("Average value for the First Collision");

        csv.addEntry("Minimum value for Maximum Occupancy");
        csv.addEntry("Maximum value for Maximum Occupancy");
        csv.addEntry("Average value for Maximum Occupancy");

        csv.addEntry("Minimum value for Fill Time");
        csv.addEntry("Maximum value for Fill Time");
        csv.addEntry("Average value for Fill Time");

        csv.endLine();

        //use a for loop to generate the 100 different sizes (n)
        for (int i = 10000; i <= 1000000; i = i + 10000) {
            int minFirstCollisionTime = 0;
            int maxFirstCollisionTime = 0;
            int averageFirstCollisionTime = 0;

            int minMaxOccupancy = 0;
            int maxMaxOccupancy = 0;
            int averageMaxOccupancy = 0;

            int minFillTime = 0;
            int maxFillTime = 0;
            int averageFillTime = 0;

            //for each size, repeat 5 times to account for any variance
            for (int j = 0; j < timesRepeated; j++)
            {
                this.generate(i);

                //find the minimum elements
                //if this is the first time running through the for loop, set each as the minimum value
                if (j == 0)
                {
                    minFirstCollisionTime = this.timeOfFirstCollision;
                    minMaxOccupancy = this.maxOccupancy;
                    minFillTime = this.fillTime;
                }
                //if it is not the first time running through the for loop
                else
                {
                    //check each individual element, and if it is lower than the current min element, update the min
                    if (this.timeOfFirstCollision < minFirstCollisionTime) {
                        minFirstCollisionTime = this.timeOfFirstCollision;
                    }
                    if (this.maxOccupancy < minMaxOccupancy) {
                        minMaxOccupancy = this.maxOccupancy;
                    }
                    if (this.fillTime < minFillTime) {
                        minFillTime = this.fillTime;
                    }
                }

                //update the max elements through a series of if statements
                if (this.timeOfFirstCollision > maxFirstCollisionTime) {
                    maxFirstCollisionTime = this.timeOfFirstCollision;
                }
                if (this.maxOccupancy > maxMaxOccupancy) {
                    maxMaxOccupancy = this.maxOccupancy;
                }
                if (this.fillTime > maxFillTime) {
                    maxFillTime = this.fillTime;
                }

                //In order to calculate the average, first keep a running sum
                // Then, at the end, divide by however many elements it went through (j)
                averageFirstCollisionTime = averageFirstCollisionTime + this.timeOfFirstCollision;
                averageMaxOccupancy = averageMaxOccupancy + this.maxOccupancy;
                averageFillTime = averageFillTime + this.fillTime;
            }
            averageFirstCollisionTime = averageFirstCollisionTime / timesRepeated;
            averageMaxOccupancy = averageMaxOccupancy / timesRepeated;
            averageFillTime = averageFillTime / timesRepeated;

            csv.addEntry(i);
            csv.addEntry(minFirstCollisionTime);
            csv.addEntry(maxFirstCollisionTime);
            csv.addEntry(averageFirstCollisionTime);

            csv.addEntry(minMaxOccupancy);
            csv.addEntry(maxMaxOccupancy);
            csv.addEntry(averageMaxOccupancy);

            csv.addEntry(minFillTime);
            csv.addEntry(maxFillTime);
            csv.addEntry(averageFillTime);
            csv.endLine();
        }
        csv.close();
    }

    //this method generates the statistics of the DoubleChoice variation using the CSVWriter class
    public void generateStats2() {
        ///this constant stores the number of times the method will test each size
        final int timesRepeated = 5;

        CSVWriter csv = new CSVWriter("DoubleChoice.csv");
        csv.addEntry("Size");

        csv.addEntry("Minimum value for Max Occupancy");
        csv.addEntry("Max value for Max Occupancy");
        csv.addEntry("Average value for Max Occupancy");

        csv.endLine();

        //for each size, repeat 5 times to account for any variance
        for (int i = 10000; i <= 1000000; i = i + 10000) {

            int minMaxOccupancy = 0;
            int maxMaxOccupancy = 0;
            int averageMaxOccupancy = 0;

            //for each size, repeats 5 times to check variance
            for (int j = 0; j < timesRepeated; j++) {
                this.generate2(i);

                //find the minimum elements
                //if this is the first time running through the for loop, set each as the minimum value
                if (j == 0) {
                    minMaxOccupancy = this.maxOccupancy;
                }
                //if it is not the first time running through the for loop
                else {
                    //check each individual element, and if it is lower than the current min element, update the min
                    if (this.maxOccupancy < minMaxOccupancy) {
                        minMaxOccupancy = this.maxOccupancy;
                    }
                }

                //update the max element using an if statement
                if (this.maxOccupancy > maxMaxOccupancy) {
                    maxMaxOccupancy = this.maxOccupancy;
                }

                //In order to calculate the average, first keep a running sum
                // Then, at the end, divide by however many elements it went through (j)
                averageMaxOccupancy = averageMaxOccupancy + this.maxOccupancy;
            }
            averageMaxOccupancy = averageMaxOccupancy / timesRepeated;

            csv.addEntry(i);

            csv.addEntry(minMaxOccupancy);
            csv.addEntry(maxMaxOccupancy);
            csv.addEntry(averageMaxOccupancy);

            csv.endLine();
        }
        csv.close();
    }
}


