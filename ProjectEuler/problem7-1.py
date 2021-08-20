n=3
primeNo=1
isPrime = False
while primeNo<10001:
	for i in range(2,n):
		if n%i==0:
			isPrime = False
			break
		isPrime = True
	if isPrime:
		primeNo=primeNo+1
		print n
	n=n+2
