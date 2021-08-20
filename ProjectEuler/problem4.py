n=0
for a in range(9,-1,-1):
	for b in range(9,-1,-1):
		for c in range(9,-1,-1):
			num = str(a)+str(b)+str(c)+str(c)+str(b)+str(a)
			n=int(num)
			for x in range(100,1000):
				if n%x==0 and n/x<1000 and n/x>100:
					print n
					break
