primes = []
isPrime = [True]*200
isPrime[0]=False
isPrime[1]=False
for i in range(2,200):
	if isPrime[i]:
		for x in range(2,200/i):
			isPrime[x*i]=False
for i in range(200):
	if isPrime[i]:
		primes.append(i)


def ProductOfPrimes(n):
	div = {}
	for i in primes:
		if (n%i==0):
			div[i]=0
			while (n%i==0):
				div[i]+=1
				n=n/i
		if not div:
			div[n]=1
	return div

def sumDivisors(n):
	div = ProductOfPrimes(n)
	sum=1
	for i in div:
		sum=sum*(i**(div[i]+1)-1)/(i-1)
	sum=sum-n
	return sum

isAbundant = [False]*28123
for i in range(28123):
	if sumDivisors(i)<i:
		isAbundant[i]=True
