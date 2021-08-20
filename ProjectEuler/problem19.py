count = 0
n = 1
m = 1
y = 1900
d=1

def isLeap(year):
	if year%400==0 or (year%100!=0 and year%4==0):
		return True
	return False

def days(month):
	if month==2:
		return 29 if isLeap(y) else 28
	elif month in [1,3,5,7,8,10,12]:
		return 31
	else:
		return 30

while y<2001:
	if d==7 and n==1 and y>1900:
		print str(n)+"."+str(m)+"."+str(y)
		count+=1
	if n==days(m) and m==12:
		n=1
		m=1
		y+=1
	elif n==days(m):
		n=1
		m+=1
	else:
		n+=1
	if d==7:
		d = 1
	else:
		d+=1	
print count
