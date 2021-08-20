def nDivisors(n):
	count = 1
	for i in range(2,n+1):
		icount=0
		while n%i==0:
			icount=icount+1
			n=n/i
		count=count*(icount+1)
	return count
