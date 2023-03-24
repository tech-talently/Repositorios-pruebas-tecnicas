
'''
method for determinate probability poisson for arrivals
'''
from scipy.stats import poisson
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import random
import math

num_planes_per_hour = [
  24, 18, 23, 26, 15, 20, 17, 31, 17, 26, 27, 8, 23, 17, 23, 17, 16,
  32, 15, 19, 23, 28, 18, 22, 21, 16, 25, 16, 19, 23, 24, 25, 20, 12,
  13, 18, 16, 17, 16, 13, 22, 24, 17, 28, 26, 25, 19, 15, 24, 18, 14,
  25, 16, 22, 23, 18, 10, 23, 18, 15, 14, 13, 20, 24, 22, 19, 14, 15,
  21, 19, 12, 21, 23, 31, 19, 22, 14, 12, 19, 24, 19, 16, 16, 13, 17,
  19, 25, 12, 23, 16, 15, 9, 13, 24, 26, 19, 19, 27, 21, 20,
]


'''
we first calculate the maximum number of planes that could potentially land per hour by finding
the maximum value in the num_planes_per_hour list. Then, we calculate the number of runways required
 by dividing the maximum number of planes by 5 (the maximum capacity of a single runway) 
and rounding up to the nearest integer using integer division and the modulo operator.
'''


max_planes_per_hour = max(num_planes_per_hour)
num_runways = max_planes_per_hour // 5 + (max_planes_per_hour % 5 > 0)

print("1) The new airport should build", num_runways, "runways.")

media=np.mean(num_planes_per_hour)
num_runways = math.ceil(media / 5)
if num_runways * 5 >= max(num_planes_per_hour):
    print("The airport should build", num_runways, "runways.")
else:
    print("The number of runways is insufficient.")

'''
fot this problem, i can use the Poisson Distribution
To use the Poissson Distribuition, i need to know the average rate of planes arriving per hour
2) What is the probability of 30 planes arriving during an hour? Explain your answer.
'''
print("-------------------------")
print("2)")
print("mean: "+str(media))

prob=poisson.pmf(30,media)
print("prob 30 planes: "+str(prob))



'''
3) The company wants a 48 hour simulation of planes landing in the airport, 
report the results like `num_planes_day_simulation`.
i can use the random.choice() method to randomly select a number of planes to simulate the landing of planes for 48 hours.
i calculate the required number of runways based on formula `int(number_planbes/5)+1 num_planes%5 else num_polnaes/5
'''
print("-------------------------")
print("3)")

num_planes_day_simulation=[]

for i in range(48):
    num_planes = random.choice(num_planes_per_hour)
    num_planes_day_simulation.append(num_planes)

num_runways = [int(num_planes/5)+1 if num_planes%5 else int(num_planes/5) for num_planes in num_planes_day_simulation]

print(num_runways)