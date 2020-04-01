function binaryAgent(str) {
  let biArr = str.split(' '), string = '';

  for (let i = 0; i < biArr.length; i++) {
      let charNum = 0,
          char, biPower;

      for (let j = 0; j < biArr[i].length; j++) {
        //   process.stdout.write(biArr[i][j] + "-");
        biPower = biArr[i].length - j - 1;

          if (biArr[i][j] == 1) {
              charNum += Math.pow(2, biPower)
          }
          
      }
        string += String.fromCharCode(charNum);
      
  }

  console.log(`Your converted string is...\n${string}`);
  return string;

}

binaryAgent("01000001 01110010 01100101 01101110 00100111 01110100 00100000 01100010 01101111 01101110 01100110 01101001 01110010 01100101 01110011 00100000 01100110 01110101 01101110 00100001 00111111");
