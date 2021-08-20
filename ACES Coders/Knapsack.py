import math
import os
import random
import re
import sys

n=0

def unboundedKnapsack(k, arr):
    for el in arr:
        if k-el==0:
            return 0
    res = [k]*n
    for i in range(0,n):
        if (k>arr[i]):
            res[i] = unboundedKnapsack(k-arr[i],arr)
        else:
            res[i]=k
    return min(res)


array = [2,1]
n=2
k=0
print (k-unboundedKnapsack(k,array))
