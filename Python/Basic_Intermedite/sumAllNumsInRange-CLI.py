welcomeMsg = "\nWelcome to the EZ-Cal CLI\n\nYou will enter two numbers and all numbers in that range(inclusive) will be summed and your answer will be logged\n"
notIntMsg = "\nThat's Not A Number, Try Again.\n"

def init():

  int1 = input("Enter Your First Number\nInt: ")
  parsedInt1 = isNum(int1)
  if not parsedInt1:
    print(notIntMsg)
    return init()

  int2 = input("Enter Your Second Number\nInt: ")
  parsedInt2 = isNum(int2)
  if not parsedInt2:
    print (notIntMsg)
    return init()

  rangeSum(parsedInt1, parsedInt2)

  restartCLI()

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

def restartCLI():
  answer = input("Would You Like To Try Again?\n(y/n): ")
  if answer == "y":
    init()
  else:
    print("Thanks for using this application, closing...")


def isNum(num):
  try:
    return int(num)
  except ValueError:
    return False


print(welcomeMsg)
init()