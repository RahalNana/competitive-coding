with open('problem22_data') as f:
	data = f.read().replace("\"","").split(",")
total=0
data.sort()
for i in range(0,len(data)):
	l=list(data[i])
	score=0
	for j in l:
		score+=ord(j)-64
	score*=(i+1)
	total+=score
print total
