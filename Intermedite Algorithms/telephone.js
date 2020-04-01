function telephoneCheck(str) {
//   str = str.replace(/\(|\)|\-|\s|[a-z]|[A-Z]/g, '');
//   console.log(str);
  
str = str.split('');

let finalNum = '',
    numbers = '0123456789';

    numbers = numbers.split('');


for (let i = 0; i < str.length; i++) {
    for (let j = 0; j < numbers.length; j++) {
        if (str[i].includes(numbers[j])) {
        finalNum += str[i];
        };
    };
};

console.log(finalNum);

  if (finalNum.length == 11 && finalNum[0] == 1) {
      console.log(true);
      
      return true;
  } else if (finalNum.length == 10) {
      console.log(true);

      return true;
  } else {
      console.log(false);

      return false;
  };
  
}

telephoneCheck("(6054756961)");


// For this challenge you will be presented with a string such as 800-692-7753 or 8oo-six427676;laskdjf. 
// Your job is to validate or reject the US phone number based on any combination of the formats provided above. 
// The area code is required. If the country code is provided, you must confirm that the country code is 1.
//  Return true if the string is a valid US phone number; otherwise return false.