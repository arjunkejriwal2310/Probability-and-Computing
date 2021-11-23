Responses for COSC-211 Assignment 5
---
#### Name: Arjun Kejriwal

#### Question 1
As we can see in the attached 'SingleChoice.csv' file, as the value of 
n increases, the first collision time increases as well. This can be
seen by how the average first collision time increases as the value of
n increases, as shown by the graph. From the graph, we can see that
the average first collision time and the value of n have a moderate 
positive linear relationship. In other words, we can see that, even 
though the two variables have a positive linear relationship, the 
variability in average first collision times increases as the value of
n increases. Even though the minimum and maximum values of the first 
collision times have been reported, they don't tell us much about the 
relationship between first collision times and the value of n since 
we are doing 5 trials for each n (thus, the average first collision 
times are a better indicator).

#### Question 2
According to my simulations, I would expect about 53 people to be in
a class before I would expect two people in the class to share a 
birthday. This result is indeed surprising at first since there are
365 days in a year. But when we look at it from a more probabilistic
point of view, it is highly unlikely to get a class of around 200 people,
not to mention 300 people, with all different birthdays. This value 
makes sense from this point of view. 

#### Question 3
As we can see in the attached 'SingleChoice.csv' file, as the value of
n increases, the maximum occupancy of n bins increases as well. 
This can be seen by how the average maximum occupancies increases as 
the value of n increases, as shown by the graph. From the graph, we can 
see that the average maximum occupancy and the value of n have a strong
positive linear relationship. However, the gradient of the relationship
is really low, which means that maximum occupancy grows relatively slowly
as the value of n increases. Still, only for the small values of n, 
maximum occupancy rises quickly. Even though the minimum and maximum values
of maximum occupancy have been reported, they don't tell us much about the
relationship between maximum occupancy and the value of n since
we are doing 5 trials for each n (thus, the average maximum occupancies
are a better indicator).

#### Question 4
As we can see in the attached 'DoubleChoice.csv' file, as the value of
n increases, the maximum occupancy of n bins increases as well.
This can be seen by how the average maximum occupancies increases as
the value of n increases, as shown by the graph. From the graph, we can
see that the average maximum occupancy and the value of n have a slight 
apparent positive linear relationship. However, the gradient of the relationship
is really low, which means that maximum occupancy grows relatively slowly
as the value of n increases. Still, only for the small values of n,
maximum occupancy rises quickly. Even though the minimum and maximum values
of maximum occupancy have been reported, they don't tell us much about the
relationship between maximum occupancy and the value of n since
we are doing 5 trials for each n (thus, the average maximum occupancies
are a better indicator). The maximum occupancy in the "power of two choices" 
simulation has a less strong relationship with the value of n than the maximum
occupancy in the initial simulation. In other words, in the "power of two
choices" simulation, maximum occupancy grows slower as the value of n 
increases as well as the values of maximum occupancy are much lower for this
simulation compared to the initial simulation. 

#### Question 5
As we can see in the attached 'SingleChoice.csv' file, as the value of
n increases, the number of trials needed until all bins have occupancy of at least 1 increases as well. This can be
seen by how the average fill time increases as the value of
n increases, as shown by the graph. From the graph, we can see that
the average fill time and the value of n have a strong
positive linear relationship. In other words, the average fill time increases
relatively quickly as the value of n increases. Even though the minimum and maximum 
values of the fill times have been reported, they don't tell us much about the
relationship between fill times and the value of n since
we are doing 5 trials for each n (thus, the average fill
times are a better indicator).

#### Question 6
The method I used doesn't iterate through all the bins to check if all of them
are filled, which would have taken a lot of time and have has a running time of
O(n) per trial. Instead, the method iterates over the trials and checks if the number of bins
filled (which is kept track of using a counter) is equal to the number of bins (a 
constant). This method is much more efficient and faster than the previous method 
and has a running time of O(1) per trial, which is better than O(n) per trial.