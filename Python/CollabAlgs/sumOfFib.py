from functools import reduce

welcomeMsg = "\nWelcome to the Fibonnaci CLI\n\nEnter the number of rounds in the Fibonacci sequence you would like to prin\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Number (rounds of Fibonacci)\nInput: ")

    if not userInput.isnumeric():
      print(invalidMsg)
      init()

    userInput = int(userInput)

    result = fib(userInput) #enter user input as param

    # [str(element) for element in a_list]

    sequence = ', '.join(map(lambda integer: str(integer) , result))

    fibSum = reduce(lambda a,b: a+b, result)

    print(f'\nYour is Fibonacci Squence is...\n\n{sequence}\nAnd the sum of this sequence is {fibSum}')
    tryAgain()

def fib(rounds): #add args
  
  answer = [0,1]
  num1 = 0
  num2 = 1
  count = 0
  fib = None

  while count < rounds-2:
    count += 1
    fib = num1 + num2
    num1 = num2
    num2 = fib
    answer.append(fib)

  return answer[0:rounds]

def tryAgain():
  ta = input(tryAginMsg)[0].lower()
  if ta == 'y':
    init()
  elif ta == 'n':
    return
  else: 
    print('\nEnter yes or no')
    tryAgain()

print(welcomeMsg)

init()