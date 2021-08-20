import timeit

start = timeit.timeit()
n = 6514751430434
i=2
largest=0
while i<=n:
	if n%i==0:
		while n%i==0:
			n=n/i
		if i>largest:
			largest=i
	i=i+1
print largest
end = timeit.timeit()
print end-start
