
def flattenList(inList):
  """
  This function will flatten a multi dimensional list 
  into a single dimension list without losing any data
  """
  i = 0
  while i < len(inList):
    if isinstance(inList[i], list):
      print(inList[i])
      inList.extend(inList[i])
      del inList[i]
      i-=1
    i+=1  
    print(i)
  print(inList)

flattenList([1, {}, [3, [[4, 5], 7, [9], [10, 11, [12, 13]], 14]],15])