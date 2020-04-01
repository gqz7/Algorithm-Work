function convertToRoman(num) {
    
 var totalNum = num,
     romanNum = '';
        convert()
        function convert() {
            if (num > 0) {

                    if (num >= 1000) {
                        romanNum += 'M';
                        num -= 1000;
                        convert()
                    } else if (num >= 900) {
                        romanNum += 'CM';
                        num -= 900;
                        convert()
                    } else if (num >= 500) {
                        romanNum += 'D';
                        num -= 500;
                        convert()
                    } else if (num >= 400) {
                        romanNum += 'CD';
                        num -= 400;
                        convert()
                    } else if (num >= 100) {
                        romanNum += 'C';
                        num -= 100;
                        convert()
                    } else if (num >= 90) {
                        romanNum += 'XC';
                        num -= 90;
                        convert()
                    } else if (num >= 50) {
                        romanNum += 'L';
                        num -= 50;
                        convert()
                    } else if (num >= 40) {
                        romanNum += 'XL';
                        num -= 40;
                        convert()
                    } else if (num >= 10) {
                        romanNum += 'X';
                        num -= 10;
                        convert()
                    } else if (num >= 9) {
                        romanNum += 'IX';
                        num -= 50;
                        convert()
                    } else if (num >= 5) {
                        romanNum += 'V';
                        num -= 5;
                        convert()
                    } else if (num >= 4) {
                        romanNum += 'IV';
                        num -= 4;
                        convert()
                    } else if (num >= 1) {
                        romanNum += 'I';
                        num -= 1;
                        convert()
                    }
            }
        }
            
    console.log(romanNum);
    return romanNum
    


}

convertToRoman(9873);
