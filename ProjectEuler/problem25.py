x1 = 1
x2 = 1
t = 0
count = 2
while t<10**999:
	count=count+1
	t=x1+x2
	x1=x2
	x2=t

print t>10**999
print count
