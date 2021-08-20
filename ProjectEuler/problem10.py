import math

def isPrime(n):
	i=5
	if n==2 or n==3:
		return True
	if n%2==0 or n%3==0:
		return False
	else:
		if n<25:
			return True
		else:
			while i<=math.sqrt(n):
				if n%i==0 or n%(i+2)==0:
					return False
				i=i+6
			return True


sum = 5
n = 5
while n<2000000:
	if isPrime(n):
		sum = sum+n
	if isPrime(n+2):
		sum = sum+n+2
	n=n+6
print sum

