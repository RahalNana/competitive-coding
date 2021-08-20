import math

total = 0
n = math.factorial(100)

while n>0:
	total += n%10
	n = n/10

print total
