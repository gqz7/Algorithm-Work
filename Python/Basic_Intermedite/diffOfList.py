def diffList (list1, list2):
  for elm in list1:
    if elm in list2:
      list1.remove(elm)
      list2.remove(elm)
  for elm in list2:
    if elm in list1:
      list1.remove(elm)
      list2.remove(elm)
  
  diffrence = list1 + list2
  print(diffrence)
  return diffrence
diffList(["andesite", "grass", "dirt", "pink wool", "dead shrub"], ["diorite", "andesite", "grass", "dirt", "dead shrub"])