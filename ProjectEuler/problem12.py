def nDivisors(n):
	count = 1
	for i in range(2,n+1):
		icount=0
		while n%i==0:
			icount=icount+1
			n=n/i
		count=count*(icount+1)
	return count

n1=1
n2=2
dn1=1
dn2=2
while True:
	n1=n1+2
	dn1 = nDivisors(n1)
	if dn1*dn2>500:
		break
	n2=n2+2
	dn2 = nDivisors(n2/2)
	if dn1*dn2>500:
		break
num = n1*n2/2
print num
