fact=1
for i in range(1,21):
	if fact%i!=0:
		x=i
		while x*i<20:
			x=x*i
		fact=fact*x
print fact
