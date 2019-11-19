function convertToRoman(num) {
    console.log('loop');
    
 var totalNum = num,
     romanNum = ' test';
        if (totalNum > 0) {
            
            if (totalNum >= 1000) {
                romanNum = "M" + romanNum;
                totalNum -= 1000;
                convertToRoman()
            };


        }
            
    console.log(romanNum);
    


}

convertToRoman(3000);
