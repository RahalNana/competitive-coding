def sumDivisors(n):
	tot = 0
	for i in range(1,n):
		if n%i==0:
			tot+=i
	return tot

amic = []

for n in range(1,10001):
	x = sumDivisors(n)
	if n==sumDivisors(x) and n not in amic and x!=n:
		amic.append(n)
		print n

print sum(amic)
