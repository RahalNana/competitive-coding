import math

n=6
primeNo=3
isPrime=False

while primeNo<10001:
	isPrime = False
	n=n+1
	i=5
	if n%2==0 or n%3==0:
		isPrime = False
	else:
		if n<25:
			isPrime = True
		else:
			while i<=math.sqrt(n):
				if n%i==0:
					isPrime = False
					break
				if n%(i+2)==0:
					isPrime=False
					break
				isPrime = True
				i=i+6
	if isPrime:
		primeNo=primeNo+1
		print n
