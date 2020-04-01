//my original
function titleCase00(str) {
    var fNewStr = str.split(" "),
    newStr = "",
    bNewStr = str.split(" ");
    str = str.split(" ");
       for(var i=0; i <str.length; i++){
        fNewStr[i] =  (str[i].substring(0, 1).toUpperCase());
        bNewStr[i] = (str[i].substring(1, str[i].length).toLowerCase());
        newStr += (fNewStr[i] + bNewStr[i] + " ");
        console.log(newStr);

    }
    return newStr;
  }
  
  titleCase00("sHoRt AnD sToUt");
  //my 10/6/19
  function titleCase01(str) {
    let newStr = "";
    str = str.split(" ");
       for(let i=0; i <str.length; i++){
        newStr += (str[i].substring(0, 1).toUpperCase() + str[i].substring(1, str[i].length).toLowerCase() + " ");
        console.log(newStr);

    }
    return newStr;
  }
  
  titleCase01("hunter is the best");

  //others

  function titleCase(str) {
    return str.toLowerCase().replace(/(^|\s)\S/g, (L) => L.toUpperCase());
  }


  String.prototype.replaceAt = function(index, character) {
    return this.substr(0, index) + character + this.substr(index+character.length);
};

function titleCase(str) {
    var newTitle = str.split(' ');
    var updatedTitle = [];
    for (var st in newTitle) {
        updatedTitle[st] = newTitle[st].toLowerCase().replaceAt(0, newTitle[st].charAt(0).toUpperCase());
    }
    return updatedTitle.join(' ');
}

function titleCase(str) {
    var convertToArray = str.toLowerCase().split(" ");
    var result = convertToArray.map(function(val){
        return val.replace(val.charAt(0), val.charAt(0).toUpperCase());
    });
    return result.join(" ");
  }
  
