c=0
product=0
done = False
for a in range(1,500):
	for b in range(1,500):
		c = 1000-(a+b)
		if a*a+b*b==c*c:
			print a
			print b
			print c
			done = True
			product = a*b*c
			break
	if done:
		break
print product
