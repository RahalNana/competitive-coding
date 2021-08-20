x = 2**1000
summ=0
while x>0:
	summ=summ+x%10
	x=x/10
print summ
