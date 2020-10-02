from functools import reduce

welcomeMsg = "\nWelcome to the Fibonnaci Digits CLI\n\nEnter the number and this program will calculate the nth term of fibonacci that has the given number of digits\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    userInput = input("\nEnter A Target Number Of Digits\nInput: ")

    if not userInput.isnumeric():
      print(invalidMsg)
      init()

    userInput = int(userInput)

    result = fib(userInput) #enter user input as param

    # [str(element) for element in a_list]

    print(f'\nThe first Fibonacci number with {userInput} digits is {result[1]}.\nIt is in the {result[0]}th round of the Fibonacci sequence.')
    tryAgain()

def fib(digits): 
  
  num1 = 0
  num2 = 1
  count = 1
  fib = 1

  while len(str(fib)) < digits:
    count += 1
    fib = num1 + num2
    num1 = num2
    num2 = fib
    # print(fib)

  answer = [count, fib]

  return answer


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