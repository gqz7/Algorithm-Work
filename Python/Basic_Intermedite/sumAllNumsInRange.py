
def rangeSum(num1, num2):
  firstGrt = num1 < num2
  minNum = num1 if firstGrt else num2
  maxNum = num2 if firstGrt else num1 
  count = minNum
  total = 0
  while count <= maxNum:
    total+=count
    count+=1
  print (f"The Total of All Numbers Between {minNum} and {maxNum} is {total}")

rangeSum(77,33)