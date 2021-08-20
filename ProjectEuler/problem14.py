import time
start = time.time()

max_count=0
count=1
number=0
for n in range(2,1000001):
	i=n
	count=1
	while n!=1:
		if n%2==0:
			n=n/2
		else:
			n=3*n+1
		count = count + 1
	if count>max_count:
		max_count=count
		number=i
print number
print time.time()-start
