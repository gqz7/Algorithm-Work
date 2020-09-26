
# informs user if the string in the first input contains all of the letters of the string in the second input.


welcomeMsg = "\nWelcome to the Mutations CLI\n\nYou will first enter a string to search within. Then you will enter character to search for in another string.\nYour output will be how many, if any, characters were missing from the first string\nNote it will be case-insentitive\n"
invalidMsg = "\nThat's Not A Valid Entry, Try Again.\n"
tryAginMsg = '\nWould you like to try again? (y/n)\nInput: '

def init():
    searchingIn = input("\nEnter A String That Will Be Searched Within\nString: ")

    if searchingIn.strip() == "":
      print(invalidMsg)
      init()
    
    searchingFor = input("\n\nEnter characters that you want to search in your string \n(spaces dont count, put multiple of the same if you want to check for duplicates) \nString: ")

    if searchingFor.strip() == "":
      print(invalidMsg)
      init()

    leftOver, missing = containsChars( searchingIn, searchingFor ) #will return an array of the missing characters of the first string

    result1 = 'no characters' if len(missing) == 0 else missing

    result2 = 'There were no characters left' if len(leftOver) == 0 else 'The characters left over were' + leftOver

    print(f'\nYour first string was missing :\n\n{result1}\n{result2}')
    tryAgain()

def containsChars(data, query): #add args

  testStr = data.lower()
  testQuery = query.lower() 
  
  for char in testQuery:
    print(char)
    if not testStr.find(char) == -1:
        testStr = testStr.replace(char, '')
        testQuery = testQuery.replace(char, '')
      
  answer = [testStr, testQuery] #define answer

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