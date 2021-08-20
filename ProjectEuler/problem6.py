summ =0
sqsum = 0
for i in range(1,101):
	summ = summ+i
	sqsum = sqsum+i*i
dif = summ*summ - sqsum
print dif
