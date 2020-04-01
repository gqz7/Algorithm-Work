//my "notworking"

var str = ""
function truncateString(str, num) {
    // Clear out that junk in your trunk
    if(str.length >= num){
       return str;
       console.log(str);
       
    }else{
     str.substring(str.length - num, str.length);
     return (str + "...");
        console
    }
  }
  
  truncateString("A-tket a-tasket A green and yellow basket", 8);

//other
  function truncateString(str, num) {
    if (str.length <= num) {
      return str;
    } else {
      return str.slice(0, num > 3 ? num - 3 : num) + '...';
    }
  }