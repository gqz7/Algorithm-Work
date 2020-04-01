function pairElement(str) {
   str = str.trim().split("");

   for (let i = 0; i < str.length; i++) {
        switch(str[i]) {
            case "A":
                    str[i] = [str[i],("T")];           
               break;
            case "T":
                    str[i] = [str[i],("A")];               
               break; 
            case "C":
                    str[i] = [str[i],("G")];               
                break;
            case "G":
                    str[i] = [str[i],("C")];                    
                break;     
       }
           
    }
    
    console.log(str);
    return str;
    
  }
  
  pairElement("CTCTA");