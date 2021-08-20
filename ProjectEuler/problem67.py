raw_data = []
with open('problem67_data') as f:
	for i in range(0,100):
		raw_data.append(f.readline().rstrip().split(' '))

data = [map(int,x) for x in raw_data]
r=99

while r>0:
	c=0
	while c<r:
		data[r-1][c] = data[r-1][c]+data[r][c] if data[r][c]>data[r][c+1] else data[r-1][c]+data[r][c+1]
		c=c+1
	r=r-1
print data[0][0]
