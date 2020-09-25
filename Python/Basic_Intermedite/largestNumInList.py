def largestInList (nlist):
  largest = None
  for num in nlist:
    if isinstance(num, list):
      num = largestInList(num)
    
    numStr = str(num)
    if largest == None and numStr.isnumeric() :
      largest = int(num)
    if numStr.isnumeric() and int(num) > largest:
      largest = int(num)
  if not largest == None:  
    print(f"\n\nLargest Num In\n{nlist} is...\n{largest}")
  

# largestInList([17, 23, 25, 12])
largestInList([[17, 23, 25, 12], [25, 7, 34, 48], [4, -10, 18, 21]])