function HtmlEntities(str) {
    str = str.trim().split("");
    for (let i = 0; i < str.length; i++) {
        switch (str[i]) {
            case "'":
                    str[i] = "&apos;"
                
                    break;
            case '"':
                    str[i] = "&quot;"
                    
                    break;
                    
            case "<":
                    str[i] = "&lt;"
                    
                    break;
            case ">":
                    str[i] = "&gt;"
                    
                    break;
            case "&":
                    str[i] = "&amp;"
                    
                    break;
            default:
                break;
        }
        
    }
    str = str.join("");
    console.log(str);
    return str
    

}
HtmlEntities('Stuff in "quotation marks"');