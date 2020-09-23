# classRandomizer.py
import random

listOfNames = ['A', 'Che', 'Cu', 'G', 'H', 'J', 'M', 'S', 'W', 'Chr']
newList = []

def randomizer (nList):
  count = 0 
  length = len(nList)
  while count < length :
    count += 1
    ranName = nList[random.randint(0, len(nList) - 1)]
    print(f"Count: {count}")
    # print(f"In Order: {name}")
    # print(f"Random: {ranName}")

    if not ranName in newList:
      newList.append(ranName)
    else: 
      length+=1

  print(newList)

randomizer(listOfNames)


## ~ Arniel

# 123456|
# 12346|5
# 1346|52
# 134|526
# 14|5263
# 4|52631
# |526314

# This algorithm works by pulling items from the array at random, and reordering to the right
def stackRandomizer (list):

  # Create a new array to avoid data mutation
  newList = []
  
  # Copy items of passed array
  for item in list: newList.append(item) 
  
  # Set indexer to top of array
  count = len(newList) - 1
  
  # While there are elements to the left
  while (count > 0):
    
    # Pull a random element (from working-stack) to the right
    newList.append(newList.pop(random.randint(0, count))) 

    # randomElm = newList.splice(random.randint(0, count), 1)
    # newList.append(randomElm)
    
    # Iterate down (Shorted working-stack)
    count-=1 
    
  # Return the randomized list
  return newList


# print(stackRandomizer(listOfNames))