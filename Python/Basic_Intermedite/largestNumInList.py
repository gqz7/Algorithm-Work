def largestInList (list):
  largest = None
  for num in list:
    numStr = str(num)
    if largest == None and numStr.isnumeric() :
      largest = int(num)
    if numStr.isnumeric() and int(num) > largest:
      largest = int(num)
  print(largest)


largestInList([4, 5, 1, 3])